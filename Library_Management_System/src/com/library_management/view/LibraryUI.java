package com.library_management.view;

import java.util.List;
import java.util.Scanner;

import com.library_management.business.Book;
import com.library_management.business.LibraryService;
import com.library_management.data.LibraryFactory;
import com.library_management.exceptions.BookAlreadyExistsException;
import com.library_management.exceptions.BookNotFoundExcpetion;

public class LibraryUI {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner1 = new Scanner(System.in);

	public static void userOptions() {
		System.out.println("1. Add Book");
		System.out.println("2. Update Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Fetch All Books");
		System.out.println("5. Fetch Using Book Id");
		System.out.println("6. Exit");
	}

	public static void main(String[] args) {

		System.out.println("Enter Your DB Choice >>>");
		int code = scanner.nextInt();

		LibraryService libraryService = new LibraryService(LibraryFactory.getRepository(code));

		while (true) {
			userOptions();
			System.out.println("Enter Choice:");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Enter Book Id:");
				int bookId = scanner.nextInt();

				System.out.println("Enter Book Name:");
				String bookName = scanner.next();

				System.out.println("Enter Book Genre:");
				String bookGenre = scanner.next();

				System.out.println("Enter Book Availability:");
				String bookAvailable = scanner.next();

				Book book = new Book(bookId, bookName, bookGenre, bookAvailable);
				try {
					libraryService.addBook(book);
				} catch (BookAlreadyExistsException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				System.out.println("Enter Book ID");
				int bookIdUpdate = scanner.nextInt();
				Book updateBook;
				try {
					updateBook = libraryService.retrieveBookById(bookIdUpdate);
					System.out.println("Enter New Book Name");
					String bookName1=scanner.next();
					
					System.out.println(libraryService.updateBook(bookIdUpdate, bookName1));
				}
				catch(BookNotFoundExcpetion e)
				{
					System.out.println(e.getMessage());
				}
				
				break;

			case 3:
				System.out.println("Enter Book ID");
				int bookIdDelete = scanner.nextInt();
				try {
					System.out.println(libraryService.deleteBook(bookIdDelete));
				} catch (BookNotFoundExcpetion e) {
					System.out.println(e.getMessage());
				}
				
				break;

			case 4:
				List<Book> books = libraryService.retrieveAllBooks();
				books.forEach(System.out::println);
				break;

			case 5:
				System.out.println("Enter Book ID");
				int bookIdFetch = scanner.nextInt();
				
				Book getBook;
				try {
					
					getBook = libraryService.retrieveBookById(bookIdFetch);
					System.out.println("Book Details:");
					System.out.println("Book ID: " + getBook.getBookId());
					System.out.println("Book Name: " + getBook.getBookName());
					System.out.println("Genre: " + getBook.getBookGenre());
					System.out.println("Available: " + getBook.isAvailable());
				}
				catch (BookNotFoundExcpetion e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				System.exit(0);
			default:
				break;
			}
		}
	}
}
