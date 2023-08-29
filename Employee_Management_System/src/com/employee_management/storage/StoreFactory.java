package com.employee_management.storage;

public class StoreFactory 
{
	// Method to get the appropriate storage implementation based on the provided code.
    public static Storage getStorage(int code)
    {
    	switch (code) 
    	{
        case 1:
            return new StorageImpl(); // Returns Storage implementation using ArrayList
		case 2:
            return new StorageListImpl();// Returns Storage implementation using ArrayList
		case 3:
            return new StorageSortedImpl(); // Returns Storage implementation using TreeSet
        default:
            return new StorageMapImpl(); // Returns Storage implementation using HashMap
    	}
      
    }
    
    // Method to get a file-based storage implementation with the specified filename.
    public static Storage getFileStorage() 
    {
        return new StorageFileImpl("employee_data.txt");
    }

}