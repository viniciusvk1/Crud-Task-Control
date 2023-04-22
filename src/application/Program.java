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

        } while(option != 0);


        sc.close();
    }
}