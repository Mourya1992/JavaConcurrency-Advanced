package com.udemy.multithreading.DiningPhilosophersProblem;

import java.util.Random;

public class Philosopher implements Runnable {
	private boolean full;
	private volatile int eatCount = 0;
	private int id;
	private ChopStick leftChopStick;
	private ChopStick rightChopstick;
	private Random random;

	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopstick) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopstick = rightChopstick;
		this.random = new Random();

	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public int getEatCount() {
		return eatCount;
	}

	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}

	public void run() {

		while (!isFull()) {
			think();
			try {
				if (leftChopStick.pick(this, State.LEFT)) {

					if (rightChopstick.pick(this, State.RIGHT)) {
						eat();
						eatCount++;
						rightChopstick.putDown(this, State.RIGHT);
					}
					leftChopStick.putDown(this, State.LEFT);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void eat() throws InterruptedException {

		System.out.println("Eating in progress" + this);
		Thread.sleep(random.nextInt(1000));

	}

	public void think() {
		System.out.println(this + " is thinking");

	}

	public String toString() {
		return "Philosopher [id=" + id + "]";
	}

}
