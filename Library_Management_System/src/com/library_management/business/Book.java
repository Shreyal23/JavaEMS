package com.library_management.business;

import java.util.Objects;

public class Book {
	private int bookId;
	private String bookName;
	private String bookGenre;
	private String available;
	
	public int getBookId() {
		return bookId;
	}
	
	public Book(int bookId, String bookName, String bookGenre, String available) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
		this.available = available;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String isAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public int hashCode() {
		return Objects.hash(available, bookGenre, bookId, bookName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return available == other.available && Objects.equals(bookGenre, other.bookGenre) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName);
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookGenre=" + bookGenre + ", available="
				+ available + "]";
	}
		
	
}
