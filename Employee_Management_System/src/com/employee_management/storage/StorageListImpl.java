package com.employee_management.storage;

import java.util.List;
import java.util.ArrayList;
import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;

public class StorageListImpl implements Storage 
{
	//Creating ArrayList to Store Employee Information
    List<Employee> employeesList; 

 // Constructor initializes the ArrayList
    public StorageListImpl() {
        employeesList = new ArrayList<>();
    }

    //Overridden method to add employee in ArrayList
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException 
    {
    	//traversing through the list to check if employee with same id already exists otherwise add employee object to the list
    	for (Employee emp : employeesList) 
    	{
            if (emp.getEmpno() == e.getEmpno()) 
            {
                throw new EmployeeAlreadyExistsException("Employee with the same ID already exists.");
            }
        }
        //Add Employee to the list
        employeesList.add(e);
        
    }
    
    //Overridden method to display employee details according to Employee Number provided
    public Employee getEmployee(int empno) throws EmployeeNotFoundException 
    {
    	//Traversing through the list to check whether employee exists or not , otherwise throw exception
    	for (Employee empl : employeesList) 
    	{
            if (empno == empl.getEmpno()) 
            {
                return empl;
            }
        }

        throw new EmployeeNotFoundException("Employee not found in ListImpl ");
    }
}
