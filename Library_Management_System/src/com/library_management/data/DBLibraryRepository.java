package com.library_management.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.library_management.business.Book;
import com.library_management.exceptions.BookAlreadyExistsException;

import com.library_management.exceptions.BookNotFoundExcpetion;


public class DBLibraryRepository implements LibraryRepository {
	

	Connection connection = DBUtil.getConn();

	@Override
	public void save(Book book) throws BookAlreadyExistsException {
		try
		{
			// otherwise insert the product details in database by insert query
			String insertQuery = "insert into library VALUES (?, ?, ?, ?)";
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
			// Set the parameter values using setters
			insertStatement.setInt(1, book.getBookId());
			insertStatement.setString(2, book.getBookName());
			insertStatement.setString(3, book.getBookGenre());
			insertStatement.setString(4, book.isAvailable());

			insertStatement.executeUpdate();
			System.out.println("Added");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String update(int bookId, String bookName) throws BookNotFoundExcpetion {
		try {
			// Define the SQL update query
			String updateQuery = "update library SET bookName = ? WHERE bookid = ?";
			// Prepare the statement with the update query
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			// Set the parameter values using setters
			preparedStatement.setString(1,bookName);
			preparedStatement.setInt(2,bookId);

			// Execute the update query and get the number of rows affected
			int rowsUpdated = preparedStatement.executeUpdate();
			
		
			// Check if any rows were updated, and if not, throw an exception
			if (rowsUpdated == 0) {
				throw new BookNotFoundExcpetion("Product not found in the database.");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Book Updated";
	}

	@Override
	public String delete(int bookId) throws BookNotFoundExcpetion {
		try {
			// Define the SQL update query
			String updateQuery = "delete from library WHERE bookid = ?";
			// Prepare the statement with the update query
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			// Set the parameter values using setters
			
			preparedStatement.setInt(1,bookId);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Deleted" ;

	}

	@Override
	public ArrayList<Book> fetch() {
		
		ArrayList<Book> books = new ArrayList<>();
		try {
			// Define the SQL select query for fetching all products
			String selectQuery = "select * from library";

			// Create a statement to execute the select query
			Statement statement = connection.createStatement();

			// Execute the query and get the result set
			ResultSet resultSet = statement.executeQuery(selectQuery);

			// Iterate through the result set
			while (resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String bookName = resultSet.getString("bookName");
				String genre = resultSet.getString("bookGenre");
				String available = resultSet.getString("available");

				// Create a Product object and add it to the list
				Book product = new Book(bookId, bookName, genre, available);
				books.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Return the list of products
		return books;
	}

	@Override
	public Book fetchById(int bookId) throws BookNotFoundExcpetion {
		Book book=null;
		try {
			// Define the SQL select query for fetching products by price
			String selectQuery = "select * from library where bookId = ?";
			// Execute the query and get the result set
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();

			// Iterate through the result set
			while (resultSet.next()) {
				int bookid = resultSet.getInt("bookId");
				String bookname = resultSet.getString("bookName");
				String bookgenre = resultSet.getString("bookGenre");
				String available = resultSet.getString("available");

				// Create a Product object and add it to the list
				book = new Book(bookid, bookname, bookgenre, available);
				// Create a Product object and add it to the list
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return book;
	}

	@Override
	public void issuingBook(int bookId) throws BookNotFoundExcpetion {

	}

}
