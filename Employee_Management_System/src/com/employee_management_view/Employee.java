package com.employee_management_view;

import java.util.Date;
import java.util.Objects;

//Entity class Employee contains empno, first name, city & salary attributes

public class Employee implements Comparable<Object>{
	  	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", firstName=" + firstName + ", city=" + city + ", salary=" + salary
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

		private int empno;
	  	private String firstName;
	    private String city;
	    private double salary;
	    private Date dateOfJoining;
	  
		public Employee() {		}
		
		//parameterized constructor to initialize values
		public Employee(int empno, String name, String city, Date dateOfJoining) {
			this.empno = empno;
	        this.firstName = name;
	        this.city = city;
	        this.dateOfJoining= dateOfJoining;
		}
		
		//method to get employee number
		public int getEmpno() {
			return empno;
		}
		
		//method to set employee number
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		//method to get employee name
		public String getFirstName() {
			return firstName;
		}
		//method to set employee name
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		//method to get employee city
		public String getCity() {
			return city;
		}
		//method to set employee city
		public void setCity(String city) {
			this.city = city;
		}
		//method to get employee salary
		public double getSalary() {
			return salary;
		}
		//method to set employee salary
		public void setSalary(double salary) {
			this.salary = salary;
		}

		 // Hash code method for efficient comparison
		@Override
		public int hashCode() 
		{
			return Objects.hash(empno, firstName, salary,city);
		}

		// Equals method to compare two Employee objects
		public boolean equals(Object obj) {
		        if (this == obj) return true;
		        if (obj == null || getClass() != obj.getClass()) return false;
		        Employee other = (Employee) obj;
		        return empno == other.empno &&
		               Double.compare(other.salary, salary) == 0 &&
		               Objects.equals(firstName, other.firstName) &&
		               Objects.equals(city, other.city);
		    }

		//method to get Date
		public Date getDateOfJoining() {
			return dateOfJoining;
		}
		
		//method to set the date
		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}
		
		// Comparable implementation to compare Employee objects based on employee number
		@Override
		public int compareTo(Object o) {
		    Employee other = (Employee) o;
		    return Integer.compare(this.empno, other.empno);
		}
	    
	    
}
