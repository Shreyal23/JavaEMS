package com.employee_management.storage;

import java.util.HashMap;

import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;

public class StorageMapImpl implements Storage{

	// HashMap to store employees with their employee number as the key
	private HashMap<Integer, Employee> mapOfEmployees;

	// Constructor initializes the HashMap
    public StorageMapImpl() {
    	mapOfEmployees = new HashMap<>();
    }
    
    // Method to add an employee to the HashMap
	@Override
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		//checking if employee with same id already exists otherwise add employee object to the map
		if (mapOfEmployees.containsKey(e.getEmpno())) 
		{
            throw new EmployeeAlreadyExistsException("Employee with the same ID already exists.");
        }
        
		//add employee to the map
		mapOfEmployees.put(e.getEmpno(), e);
	}

	 // Method to get an employee based on their employee number
	@Override
	public Employee getEmployee(int empno) throws EmployeeNotFoundException {
		  // Return the employee associated with the given employee number else throw exception
		if (mapOfEmployees.containsKey(empno)) {
            return mapOfEmployees.get(empno);
        } else {
            throw new EmployeeNotFoundException("Employee not found with empNo: " + empno);
        }
	}
	

}
