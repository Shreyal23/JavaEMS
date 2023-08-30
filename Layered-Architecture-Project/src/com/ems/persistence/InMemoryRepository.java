package com.ems.persistence;

import java.util.ArrayList;

import com.ems.business.Employee;

import com.ems.exceptions.EmployeeNotFoundException;

public class InMemoryRepository implements EmployeeRepository {

	static ArrayList<Employee> employees = new ArrayList<>();

	@Override
	public void save(String ename) {
		Employee employee = new Employee(ename);
		employees.add(employee);
	}

	@Override
	public ArrayList<Employee> show() {
		return employees;
	}

	@Override
	public Employee fetch(int eid) throws EmployeeNotFoundException {
		return employees
				.stream()
				.filter(e -> e.getEid() == eid)
				.findAny()
				.orElseThrow(
						() -> new EmployeeNotFoundException("Employee Not Found: " + eid));
	}

	@Override
	public String delete(int eid) throws EmployeeNotFoundException {
		Employee emp = fetch(eid);
		employees.remove(emp);
		return "Employee Deleted Successfully";
	}

	@Override
	public Employee update(int eid, Employee newData) throws EmployeeNotFoundException {
		return null;
	}
}