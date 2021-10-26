package com.udemy.multithreading.DiningPhilosophersProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	private Lock lock;
	private int id;

	public ChopStick(int id) {

		this.lock = new ReentrantLock(true);
		this.id = id;
	}

	public boolean pick(Philosopher philosopher, State state) throws InterruptedException {

		if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {

			System.out.println(philosopher + " Picked up " + this + " with his " + state + " hand");
			return true;

		}

		return false;

	}

	public void putDown(Philosopher philosopher, State state) throws InterruptedException {

		System.out.println(philosopher + " puts down " + this + " with his " + state + " hand");
		lock.unlock();

	}

	public String toString() {
		return "ChopStick [id=" + id + "]";
	}

}
