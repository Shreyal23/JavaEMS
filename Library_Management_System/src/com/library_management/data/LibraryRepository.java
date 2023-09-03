package com.library_management.data;

import java.util.ArrayList;

import com.library_management.business.Book;
import com.library_management.exceptions.BookAlreadyExistsException;
import com.library_management.exceptions.BookNotFoundExcpetion;

public interface LibraryRepository {
	
	void save(Book book) throws BookAlreadyExistsException;
	
	String update(int bookId,String bookName) throws BookNotFoundExcpetion;
	
	String delete(int bookId) throws BookNotFoundExcpetion;
	
	ArrayList<Book> fetch();
	
	Book fetchById(int bookId) throws BookNotFoundExcpetion;
	
	void issuingBook(int bookId) throws BookNotFoundExcpetion;
}
