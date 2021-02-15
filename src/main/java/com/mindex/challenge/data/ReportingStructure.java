package com.mindex.challenge.data;


import com.mindex.challenge.controller.EmployeeController;
import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.service.impl.EmployeeServiceImpl;
import com.mindex.challenge.service.impl.ReportingStructureServiceImpl;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;
import java.util.HashSet;
import java.util.List;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){

    }

    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
