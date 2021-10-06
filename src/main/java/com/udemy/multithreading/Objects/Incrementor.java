package com.udemy.multithreading.Objects;

public class Incrementor {

	private int count;

	public void increment() throws InterruptedException {

		synchronized (this) {
			for (int i = 0; i < 25; i++) {

				System.out.println("Incremented by.." + Thread.currentThread().getName());
				count = count + 1;
			}
		}

	}

	public void decrement() throws InterruptedException {

		synchronized (this) {
			for (int i = 0; i < 25; i++) {

				System.out.println("Decemented by.." + Thread.currentThread().getName());
				count = count - 1;
			}
		}

	}

	public int getCount() {
		return count;
	}

}
