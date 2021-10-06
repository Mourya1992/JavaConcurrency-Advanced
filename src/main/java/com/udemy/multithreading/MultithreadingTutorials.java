package com.udemy.multithreading;

import com.udemy.multithreading.Objects.DeadLockClass;
import com.udemy.multithreading.Objects.Incrementor;
import com.udemy.multithreading.Objects.Worker;

public class MultithreadingTutorials {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("hi");

		Incrementor incrementor = new Incrementor();
		Worker worker = new Worker();
		DeadLockClass deadlock = new DeadLockClass();

		Thread t1 = new Thread(() -> {
			deadlock.worker1();
		}, "Thread-12");

		Thread t3 = new Thread(() -> {
			deadlock.worker2();
		}, "Thread-13");

		Thread t4 = new Thread(() -> {
			try {
				worker.threadExecution();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		t1.start();
		t3.start();
		t4.start();

		Thread.sleep(4000);
		worker.setTerminated(true);
		System.out.println("Thread terminated..");

		/*
		 * t1.start();
		 * 
		 * t3.start(); try { t1.join();
		 * 
		 * t3.join(); } catch (InterruptedException e) { e.printStackTrace(); }
		 */

		// System.out.println("Hi,the final count is ::" + incrementor.getCount());

	}

}
