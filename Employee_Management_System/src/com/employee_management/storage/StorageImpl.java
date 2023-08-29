package com.employee_management.storage;

import java.util.*;


import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;

//Implements the Storage interface and provides logic of all methods

public class StorageImpl implements Storage 
{
	//Creating ArrayList to Store Employee Information
    private List<Employee> employeesList; 

    public StorageImpl() {
        employeesList = new ArrayList<>();
    }

    //Overridden method to add employee in ArrayList
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
    	for (Employee emp : employeesList) {
            if (emp.getEmpno() == e.getEmpno()) {
                throw new EmployeeAlreadyExistsException("Employee with the same ID already exists.");
            }
        }
        
        employeesList.add(e);
    }
    
    //Overridden method to display employee details according to Employee Number provided
    public Employee getEmployee(int empno) throws EmployeeNotFoundException 
    {
    	//Traversing through the list to check whether employee exists or not
    	for (Employee emp : employeesList) {
            if (emp.getEmpno() == empno) {
                return emp;
            }
        }

        throw new EmployeeNotFoundException("Employee not found with empNo: " + empno);
    
    }
}
