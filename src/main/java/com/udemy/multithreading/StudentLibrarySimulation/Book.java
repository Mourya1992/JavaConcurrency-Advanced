package com.udemy.multithreading.StudentLibrarySimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	private int bookId;
	private String bookname;
	private Lock lock;
	private List<Book> bookStore;

	public Book(int bookId, String bookname) {
		this.bookId = bookId;
		this.bookname = bookname;
		this.lock = new ReentrantLock();
		this.bookStore = new ArrayList<Book>();
	}

	public boolean grab(Student student) throws InterruptedException {
		if (lock.tryLock(50, TimeUnit.MILLISECONDS)) {
			System.out.println(this + "was issued to the student:" + student);
			return true;
		}
		return false;

	}

	public void returnBook(Student student) {
		System.out.println(this + "was returned by the student:" + student);
		lock.unlock();

	}

	public Optional<Book> getBook(int id) {
		return bookStore.stream().filter(b->b.bookId==id).findAny();
		
	}

	public void setBookStore(List<Book> bookStore) {
		this.bookStore = bookStore;
	}


}
