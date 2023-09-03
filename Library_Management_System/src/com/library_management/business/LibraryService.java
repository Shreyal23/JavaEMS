package com.library_management.business;

import java.util.List;

import com.library_management.data.LibraryRepository;
import com.library_management.exceptions.BookAlreadyExistsException;
import com.library_management.exceptions.BookNotFoundExcpetion;

public class LibraryService {
	LibraryRepository libraryRepository;
	
	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
	
	public void addBook(Book book) throws BookAlreadyExistsException
	{
		libraryRepository.save(book);
	}
	public String updateBook(int bookId,String bookName) throws BookNotFoundExcpetion
	{
		try
		{
			return libraryRepository.update(bookId, bookName);
		}
		catch(BookNotFoundExcpetion e)
		{
			throw e;
		}
	}
	public String deleteBook(int bookId) throws BookNotFoundExcpetion
	{
		try
		{
			return libraryRepository.delete(bookId);
		}
		catch(BookNotFoundExcpetion e)
		{
			throw e;
		}
		
	}
	public List<Book> retrieveAllBooks()
	{
		return libraryRepository.fetch();
	}
	
	public Book retrieveBookById(int bookId) throws BookNotFoundExcpetion
	{
		Book b=null;
		try
		{
			b=libraryRepository.fetchById(bookId);
		}
		catch(BookNotFoundExcpetion e)
		{
			throw e;
		}
		return b;
	}
	public void issueBook(int bookId) throws BookNotFoundExcpetion
	{
		
	}

}
