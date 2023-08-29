package com.employee_management.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.employee_management_exceptions.EmployeeAlreadyExistsException;
import com.employee_management_exceptions.EmployeeNotFoundException;
import com.employee_management_view.Employee;
// Implementation of the Storage interface for file-based employee storage
public class StorageFileImpl implements Storage 
{
	//String that stores file name
	private String filePath;

	//constructor to initialize the file 
    public StorageFileImpl(String filePath) 
    {
        this.filePath = filePath;
    }
    
    //overriding the Storage interface method which might throw exception
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException 
	{
		//Using file writer to write in the file by specifying file in file path variable
		try (FileWriter writer = new FileWriter(filePath, true)) 
		{
            writer.write(e.getEmpno() + "," + e.getFirstName() + "," + e.getCity() + "," + e.getDateOfJoining() + System.lineSeparator());
        } 
		catch (IOException e1)
		{
            e1.printStackTrace();
        }
	}

	//overriding the Storage interface method which might throw exception
	public Employee getEmployee(int empno) throws EmployeeNotFoundException 
	{
		//using buffered reader to read file contents by specifying file path in file path variable
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
		{
            String line;
            Date dateofjoining=new Date();
            //scanning file till the end of file
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                //storing employee id in id variable and likewise storing parts of file in respective variables
                int id = Integer.parseInt(parts[0]);
                if (id == empno) {
                    String name = parts[1];
                    String city = parts[2];
                    
                    return new Employee(id, name, city,dateofjoining);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        throw new EmployeeNotFoundException("Employee not found with empNo: " + empno);
    }
}
