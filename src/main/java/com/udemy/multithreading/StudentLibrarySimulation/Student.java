package com.udemy.multithreading.StudentLibrarySimulation;

public class Student implements Runnable {

	private int studentId;
	private String name;
	private int bookId;

	public void run() {
		System.out.println(this);
		
		
	}

	public Student(int studentId, String name,int bookId) {

		this.studentId = studentId;
		this.name = name;
		this.bookId = bookId;
	}

	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}

	public void preparing() {
		System.out.println("Student got the book and he is prpeparing..");
	}

}
