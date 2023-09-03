package com.library_management.data;

import java.util.ArrayList;

import com.library_management.business.Book;
import com.library_management.exceptions.BookAlreadyExistsException;
import com.library_management.exceptions.BookNotFoundExcpetion;

public class ListLibraryRepository implements LibraryRepository {

	static ArrayList<Book> books = new ArrayList<>();

	@Override
	public void save(Book book) throws BookAlreadyExistsException {
		for (Book b : books) {
			if (b.getBookId() == book.getBookId()) {
				throw new BookAlreadyExistsException("Book With this ID already Exists");
			}
		}
		books.add(book);
		System.out.println("Book Added");
	}

	@Override
	public String update(int bookId, String bookName) throws BookNotFoundExcpetion {

		Book bookToUpdate = null;

		for (Book b : books) {
			if (b.getBookId() == bookId) {
				bookToUpdate = b;
				break;
			}
		}

		if (bookToUpdate != null) {
			bookToUpdate.setBookName(bookName);
			return "Book Name Updated";
		} else {
			throw new BookNotFoundExcpetion("Book not found for updating with ID: " + bookId);
		}
	}

	@Override
	public String delete(int bookId) throws BookNotFoundExcpetion {
		Book b1 = fetchById(bookId);
		books.remove(b1);
		return "Book Removed ";

	}

	@Override
	public ArrayList<Book> fetch() {
		return books;
	}

	@Override
	public Book fetchById(int bookId) throws BookNotFoundExcpetion {
		for (Book b : books) {
			if (b.getBookId() == bookId) {
				return b;
			}
		}
		throw new BookNotFoundExcpetion("Book Not found");

	}

	@Override
	public void issuingBook(int bookId) throws BookNotFoundExcpetion {

	}

}
