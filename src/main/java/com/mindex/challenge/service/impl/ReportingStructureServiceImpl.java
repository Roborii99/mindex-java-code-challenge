package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        ReportingStructure rs = new ReportingStructure();
        rs.setEmployee(employee);

        // find number of reports
        int count = 0;
        List<Employee> directReports = employee.getDirectReports();
        HashSet<Employee> hs = new HashSet<>();
        for (Employee emp:directReports) {
            emp = employeeRepository.findByEmployeeId(emp.getEmployeeId());

            hs.add(emp);
            count++;
            count += getDirectReportsRec(hs, emp);
        }

        // set number of reports
        rs.setNumberOfReports(count);
        return rs;
    }

    private int getDirectReportsRec(HashSet<Employee> hs, Employee e){
        int count = 0;
        if(e.getDirectReports() != null) {
            for (Employee emp : e.getDirectReports()) {
                emp = employeeRepository.findByEmployeeId(emp.getEmployeeId());
                if (hs.add(emp)) {
                    System.out.println("Added: " + emp.getEmployeeId());
                    count++;
                }
                if (emp.getDirectReports() != null) {
                    count += getDirectReportsRec(hs, emp);
                }
            }
        }
        return count;
    }

}