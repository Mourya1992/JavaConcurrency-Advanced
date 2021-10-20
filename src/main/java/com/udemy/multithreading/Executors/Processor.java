package com.udemy.multithreading.Executors;

import java.util.concurrent.Callable;

public class Processor implements Callable<String> {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Processor(int id) {

		this.id = id;
	}

	public String call() throws Exception {
		
		Thread.sleep(2000);

		return "Id being processed is: "+this.id+"Which was processed by:"+Thread.currentThread().getId();
	}

}
