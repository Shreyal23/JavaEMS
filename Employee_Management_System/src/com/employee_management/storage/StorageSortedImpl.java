package com.employee_management.storage;

import java.util.TreeSet;

import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;

public class StorageSortedImpl implements Storage{

	// TreeSet to store employees in sorted order
	 private TreeSet<Employee> setOfEmployees;

	// Constructor initializes the TreeSet
	 public StorageSortedImpl() {
		 setOfEmployees = new TreeSet<>();
	    }
	// Method to add an employee to the TreeSet
	@Override
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		 // Check if an employee with the same ID already exists otherwise add employee to the set
		for(Employee emp: setOfEmployees)
		{
			if(emp.getEmpno() ==  e.getEmpno())
			{
				throw new EmployeeAlreadyExistsException("Employee With This ID Already Exists");
			}
		}
		//add employee to the treeset
		setOfEmployees.add(e);
	}

	// Method to get an employee based on their employee number
	@Override
	public Employee getEmployee(int empno) throws EmployeeNotFoundException {
		// Traverse and Check if the employee number matches otherwise throw exception if not found
        for (Employee empl : setOfEmployees) {
        	
            if (empno == empl.getEmpno()) {
                return empl;
            }
        }
        throw new EmployeeNotFoundException("Employee Not Found in Set Class");
    }
	

}
