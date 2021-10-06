package com.udemy.multithreading.Objects;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	private List<Integer> newList = new ArrayList<Integer>();
	private static final int UPPER_LIMIT = 5;
	private static final int LOWER_LIMIT = 0;
	private int value = 0;
	private volatile boolean terminated;

	public boolean isTerminated() {
		return terminated;
	}

	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}

	public void threadExecution() throws InterruptedException {

		while (!isTerminated()) {
			Thread.sleep(500);
			System.out.println("This is being executed by..." + Thread.currentThread().getName());
		}
	}

	public void producer() throws InterruptedException {
		synchronized (this) {

			while (true) {
				Thread.sleep(500);
				if (newList.size() == UPPER_LIMIT) {
					System.out.println("Waiting for consumer to remove the values..");
					wait();
				} else {
					newList.add(value);
					System.out.println("Added.." + value);
					value++;
					notify();
				}

			}

		}

	}

	public void consumer() throws InterruptedException {

		synchronized (this) {
			Thread.sleep(1000);
			while (true) {
				if (newList.size() == LOWER_LIMIT) {
					System.out.println("Waiting for producer to add the values..");
					wait();
				} else {
					value = 0;
					System.out.println("Removed.." + newList.remove(newList.size() - 1));
					notify();
				}

			}

		}

	}

}
