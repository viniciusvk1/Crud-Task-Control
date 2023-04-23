package application;

import models.Employee;
import models.Tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Tasks> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        int option = -1;

        do {
            System.out.println("""
                    ================================================
                    =               Choose an option:              =
                    ================================================        
                    =    1 - Register an employee                  =
                    =    2 - List of registered employees          =
                    =    3 - Create a new task                     =
                    =    4 - List all created tasks                =
                    =    5 - Update a task                         =
                    =    6 - Delete a task                         =
                    =    0 - Exit program                          =
                    ================================================       
                           """);
            System.out.println("================================================ ");
            System.out.print("Enter your choice:  ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("================================================ ");

            switch (option) {
                case 1:
                    registerEmployee();
                    break;

                case 2:
                    listEmployees();
                    break;

                case 3:
                    createTask();
                    break;

                case 4:
                    listTasks();
                    break;

                case 5:
                    updateTask();
                    break;

                case 6:
                    deleteTask();
                    break;

                case 0:
                    System.out.println("""
                                                       
                            Closing the program!
                            Thanks for using and testing...
                            """);
                    System.out.println("================================================ ");
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
                    break;
            }

        } while (option != 0);
        sc.close();
    }

    public static void registerEmployee() {
        System.out.println("Registering a new employee!");
        System.out.println("================================================ ");
        System.out.print("Enter the employee's name: ");
        String employeeName = sc.nextLine();
        System.out.print("Enter the employee's position: ");
        String employeePosition = sc.nextLine();
        Employee newEmployee = new Employee(employeeName, employeePosition);
        employees.add(newEmployee);
        System.out.println("Employee registered!");
    }

    public static void listEmployees() {
        System.out.println("Registered Employees :");
        System.out.println("================================================ ");
        for (Employee employeesList : employees) {
            System.out.println("Employee Name: " + employeesList.getEmployeeName() + ", Position: " + employeesList.getEmployeePosition() + ".");
        }
    }

    public static void createTask() {
        System.out.println("Creating a new task!");
        System.out.println("================================================ ");
        System.out.print("Enter the name of the task you want to create: ");
        String taskName = sc.nextLine();
        System.out.print("Enter the task description: ");
        String taskDescription = sc.nextLine();
        System.out.print("Employee responsible for the task: ");
        String employeeTask = sc.nextLine();

        Employee responsibleEmployee = null;
        for (Employee emp : employees) {
            if (emp.getEmployeeName().equals(employeeTask)) {
                responsibleEmployee = emp;
                break;
            }
        }

        if (responsibleEmployee == null) {
            System.out.println("Employee not found. Do you want to register a new employee? (Y/N)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                registerEmployee();
                responsibleEmployee = employees.get(employees.size() - 1);
            } else {
                System.out.println("Task creation canceled!");
                return;
            }
        }

        System.out.println("Enter the deadline for task completion (in the format yyyy--MM-dd): ");
        LocalDate deadline = LocalDate.parse(sc.nextLine());

        Tasks newTask = new Tasks(taskName, responsibleEmployee, taskDescription, deadline);
        tasks.add(newTask);

        System.out.println("Task created succesfully!");
    }

    public static void listTasks() {
        System.out.println("All the tasks:");
        System.out.println("================================================ ");
        for (Tasks tasks : tasks) {
            System.out.println("Task name: " + tasks.getTaskName()
                    + " - responsable employee: " + tasks.getEmployeeTask().getEmployeeName()
                    + " - description: " + tasks.getTaskDescription()
                    + " - deadline: " + tasks.getDeadline()
            );
        }
    }

    public static void updateTask() {
        System.out.println("Updating an existing task!");
        System.out.println("================================================ ");
        System.out.println("Enter the name of the task you want to change: ");
        String taskUpdateName = sc.nextLine();

        Tasks taskSearch = null;

        for (Tasks tasks1 : tasks) {
            if (tasks1.getTaskName().equals(taskUpdateName)) {
                taskSearch = tasks1;
                break;
            }
        }

        if (taskSearch == null) {
            System.out.println("Task not found! Please try again.");
            System.out.println("================================================ ");
            return;
        }

        System.out.println("================================================ ");
        System.out.println("Task found!");
        System.out.println("Do you want to change the name of the task? (Y/N) ");
        String answerNameTask = sc.nextLine();
        if (answerNameTask.equalsIgnoreCase("y")) {
            System.out.println("Type the new name for the task: ");
            String newTaskName = sc.nextLine();
            taskSearch.setTaskName(newTaskName);
            System.out.println("Task name updated!");
        }

        System.out.println("Do you want to change the employee assigned to the task? (Y/N) ");
        String answerEmployeeTask = sc.nextLine();
        if (answerEmployeeTask.equalsIgnoreCase("y")) {
            System.out.println("Enter the new employee assigned to this task: ");
            String newEmployeeName = sc.nextLine();
            Employee newEmployee = null;

            for (Employee emp : employees) {
                if (emp.getEmployeeName().equals(newEmployeeName)) {
                    newEmployee = emp;
                    break;
                }
            }

            if (newEmployee == null) {
                System.out.println("Employee not found. Do you want to register a new employee? (Y/N)");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    registerEmployee();
                    newEmployee = employees.get(employees.size() - 1);
                } else {
                    System.out.println("Task update canceled!");
                    return;
                }
            }

            taskSearch.setEmployeeTask(newEmployee);
            System.out.println("Employee assigned to the task updated!");
        }

        System.out.println("Do you want to change the task description? (Y/N) ");
        String answerDescriptionTask = sc.nextLine();
        if (answerDescriptionTask.equalsIgnoreCase("y")) {
            System.out.println("Enter the new description: ");
            String newTaskDescription = sc.nextLine();
            taskSearch.setTaskDescription(newTaskDescription);
            System.out.println("Task description updated!");
        }

        System.out.println("Do you want to change the task deadline? (Y/N)");
        String answerDeadline = sc.nextLine();
        if (answerDeadline.equalsIgnoreCase("y")) {
            System.out.println("Enter the new deadline (in the format yyyy-MM-dd): ");
            LocalDate newDeadline = LocalDate.parse(sc.nextLine());
            taskSearch.setDeadline(newDeadline);
            System.out.println("Task updated successfully!");
        }

        System.out.println("Task updated successfully!");

    }

    public static void deleteTask() {

    }


}