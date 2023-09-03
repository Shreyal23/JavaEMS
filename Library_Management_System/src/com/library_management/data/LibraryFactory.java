package com.library_management.data;

public class LibraryFactory {
	public static LibraryRepository getRepository(int code)
	{
		switch (code) {
		case 1:
			return new ListLibraryRepository();
		
		default:
			return new DBLibraryRepository();
		
			
		}
	}
}
