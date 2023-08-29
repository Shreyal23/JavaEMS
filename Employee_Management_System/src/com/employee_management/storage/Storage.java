package com.employee_management.storage;

import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;

//View layer will communicate with storage layer for all CRUD operations
//As it is interface it need to be extends i.e by StorageImpl class
public interface Storage {
	
	//throws exception which is handled in the StorageImpl layer
	void addEmployee(Employee a) throws EmployeeAlreadyExistsException;
	Employee getEmployee(int empno) throws EmployeeNotFoundException;
	
}
