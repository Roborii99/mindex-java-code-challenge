package com.mindex.challenge.data;


public class Compensation {
    private String employeeId;
    private String salary;
    private String effectiveDate;

    public Compensation(){
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployee(String id) {
        this.employeeId = id;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
}
