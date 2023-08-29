package com.employee_management_view;

import java.util.Date;
import java.util.Scanner;
import com.employee_management.storage.Storage;
import com.employee_management.storage.StorageImpl;
import com.employee_management.storage.StoreFactory;
import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;

//This is the main class that handles user interaction and manages the employee management application.
//It uses a layered architecture where the presentation layer interacts with the storage layer.


class UserUI 
{
	// Scanner objects for user input
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);

	public static void main(String[] args) {
		// Display storage options to the user and get their choice
		Storage storage;
		System.out.println("Enter Code Value to Select Storage Method");
		System.out.println("For ArrayList : 2");
		System.out.println("For TreeSet : 3");
		System.out.println("For HashMap: Greater than 3");
		System.out.println("Enter Code Value For Choosing the Storage System:");

		int code = scanner.nextInt();
		Storage storage1 = StoreFactory.getStorage(code);

		StorageImpl storageImpl = new StorageImpl();

		while (true) {
			int choice = 0;
			// Providing User with Choices

			System.out.println("\n1.Add Employee");
			System.out.println("2.Get Employee");
			System.out.println("3.Store Employee Data in File");
			System.out.println("4.Check Whether Employee Exists in the File");
			System.out.println("5.Add employee in StoreFactory Class according to the Code");
			System.out.println("6.Display Employee in StoreFactory class according to the Code");
			System.out.println("7.Exit");

			System.out.println("Enter Choice:");
			choice = scanner.nextInt();

			switch (choice) {
			// case 1 for adding employee details to the Array list
			case 1:
				// Accepting employee details from the user
				Employee employee = new Employee();

				System.out.print("Enter Employee Number: ");
				employee.setEmpno(scanner.nextInt());

				System.out.print("Enter First Name: ");
				employee.setFirstName(scanner2.nextLine());

				System.out.print("Enter City: ");
				employee.setCity(scanner2.nextLine());

				System.out.print("Enter Salary: ");
				employee.setSalary(scanner.nextDouble());

				// calling addEmployee Method
				try {
					storageImpl.addEmployee(employee);
					System.out.println("Employee details added.");
				} catch (EmployeeAlreadyExistsException e1) {
					System.out.println(e1.getMessage());
				}

				break;

			case 2:
				// Display employee by Employee Number
				System.out.print("Enter Employee Number: ");

				int employeeNo = scanner.nextInt();

				Employee emp;
				try {
					// Calling getEmployee Method
					emp = storageImpl.getEmployee(employeeNo);
					System.out.println("Employee Details:");
					System.out.println("Employee Number: " + emp.getEmpno());
					System.out.println("First Name: " + emp.getFirstName());
					System.out.println("City: " + emp.getCity());
					System.out.println("Salary: " + emp.getSalary());
				}
				// if not found then raise exception and display message accordingly
				catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			// Storing employee data in a file
			case 3:
				// calling getFileStorage method that return the file
				storage = StoreFactory.getFileStorage();
				// calling addEmployee method from StorageFileImple class
				try {
					Date dateofJoining = new Date();
					storage.addEmployee(new Employee(1, "Shreyal", "Ahmedabad", dateofJoining));
					storage.addEmployee(new Employee(2, "Shah", "Mehsana", dateofJoining));
					System.out.println("Employee Details Added in File");
				} catch (EmployeeAlreadyExistsException e) {
					System.out.println(e.getMessage());
				}

				break;

			// Checking if an employee exists in the file
			case 4:
				// calling getFileStorage method that return the file
				storage = StoreFactory.getFileStorage();
				// enter employee number to search in the file

				System.out.println("Enter Employee Number to Search");
				int empnum = scanner.nextInt();

				try {
					// search in the file , if it exists then print the name of employee otherwise
					// raise an exception
					Employee employee1 = storage.getEmployee(empnum);
					System.out.println("Employee Found: " + employee1.getFirstName());
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			// Adding employee using the chosen storage class
			case 5:
				// Calling inbuilt class Date for getting date
				Date dateofJoining = new Date();
				try {
					// calling add method to add Employee data according to the storage class
					// selected
					storage1.addEmployee(new Employee(1, "Shreyal", "Ahmedabad", dateofJoining));
					storage1.addEmployee(new Employee(5, "Shaha", "Baroda", dateofJoining));
					System.out.println("Employee details added.");
				} catch (EmployeeAlreadyExistsException e1) {
					System.out.println(e1.getMessage());
				}

				break;

			// Displaying employee using the chosen storage class
			case 6:
				// Get Employee Number from user to get details
				System.out.print("Enter Employee Number: ");
				int employeeNum = scanner.nextInt();

				try {
					// calling getEmployee method to get relevant details according to the storage
					// class selected
					Employee employeeNew = storage1.getEmployee(employeeNum);
					System.out.println("Employee Details:");
					System.out.println("Employee Number: " + employeeNew.getEmpno());
					System.out.println("First Name: " + employeeNew.getFirstName());
					System.out.println("City: " + employeeNew.getCity());
					System.out.println("Salary: " + employeeNew.getSalary());
					System.out.println("Date" + employeeNew.getDateOfJoining());
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 7:
				// Terminating the program
				System.exit(0);

			default:
				System.out.println("Invalid!");
			}
			
		}

	}

}
