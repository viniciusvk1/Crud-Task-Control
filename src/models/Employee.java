package models;

public class Employee {

    private String employeeName;
    private String employeePosition;

    public Employee(String employeeName, String employeePosition) {
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
}
