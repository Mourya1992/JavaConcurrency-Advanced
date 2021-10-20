package com.udemy.multithreading.Objects;

import java.util.concurrent.Semaphore;

public enum SemaphoreExample {
	INSTANCE;

	private Semaphore semaphore = new Semaphore(4, true);

	public void downloadtheData() throws InterruptedException {
		semaphore.acquire();
		Thread.sleep(1000);
		System.out.println("Data Downloading..");
		semaphore.release();
	}

}
