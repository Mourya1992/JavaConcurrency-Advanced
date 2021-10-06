package com.udemy.multithreading.Objects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockClass {

	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);

	public void worker1() {
		lock1.lock();
		try {
			System.out.println("Worker1 acquired Lock 1:" + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		lock2.lock();
		System.out.println("Worker1 acquired Lock 2:" + Thread.currentThread().getName());

		lock1.unlock();
		lock2.unlock();
	}

	public void worker2() {
		lock1.lock();
		try {
			System.out.println("Worker2 acquired Lock 2:" + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		lock2.lock();
		System.out.println("Worker2 acquired Lock 1:" + Thread.currentThread().getName());

		lock1.unlock();
		lock2.unlock();
	}

}
