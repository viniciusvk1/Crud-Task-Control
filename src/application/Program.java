package application;

import models.Employee;
import models.Tasks;

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
            System.out.println("================================================ ");

            switch (option) {
                case 1:
                    registerEmployee();
                    break;

                case 2:
                    listEmployees();
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

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
        sc.nextLine();
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


}