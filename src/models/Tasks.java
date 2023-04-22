package models;

import java.time.LocalDate;

public class Tasks {

    private String taskName;
    private Employee employeeTask;
    private String taskDescription;
    private LocalDate deadline;

    public Tasks(String taskName, Employee employeeTask, String taskDescription, LocalDate deadline) {
        this.taskName = taskName;
        this.employeeTask = employeeTask;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Employee getEmployeeTask() {
        return employeeTask;
    }

    public void setEmployeeTask(Employee employeeTask) {
        this.employeeTask = employeeTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
