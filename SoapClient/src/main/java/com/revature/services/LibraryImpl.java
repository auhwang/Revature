package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Book;
import com.revature.exceptions.InvalidYearException;

public class LibraryImpl implements Library {

	public static List<Book> bookList = new ArrayList();
	
	public LibraryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("=======Get all books=======");
		
		bookList.add(new Book("Lord of the Bobberts", "Bobbert", 1990));
		bookList.add(new Book("Bobbert and the Philosophers Stone", "Ryan", 2002));
		bookList.add(new Book("The Hitchhikers Guide to the Gala-Bobbert", "Bobbert", 2020));
		
		return bookList;
	}

	@Override
	public String addBook(Book book) throws InvalidYearException {
		System.out.println("====== Adding a book: " + book + "=====");
		
		bookList.add(book);
		if(book.getYear() > 2018) {
			throw new InvalidYearException();
		}
		return "Successful book add" + book.getTitle();
	}

}
