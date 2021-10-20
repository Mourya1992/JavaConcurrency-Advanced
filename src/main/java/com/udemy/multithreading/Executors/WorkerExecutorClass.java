package com.udemy.multithreading.Executors;

import java.util.concurrent.TimeUnit;

public class WorkerExecutorClass implements Runnable {

	private int id;

	public WorkerExecutorClass(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println(
				"I am being an Object with Id-" + id + " Executed by thread-" + Thread.currentThread().getId());
		long duration = (long) (Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
