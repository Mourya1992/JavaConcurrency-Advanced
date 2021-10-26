package com.udemy.multithreading.DiningPhilosophersProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to Dining philosophers Problem..." + Thread.currentThread().getName());
		ExecutorService executorService = Executors.newFixedThreadPool(Constants.NO_OF_PHILOSOPHERS);
		ChopStick[] chopstick = new ChopStick[Constants.NO_OF_CHOPSTICKS];
		Philosopher[] philosophers = new Philosopher[Constants.NO_OF_PHILOSOPHERS];
		for (int i = 0; i < Constants.NO_OF_CHOPSTICKS; i++) {
			chopstick[i] = new ChopStick(i);
		}

		try {
			for (int i = 0; i < 5; i++) {
				philosophers[i] = new Philosopher(i, chopstick[i], chopstick[(i + 1) % Constants.NO_OF_CHOPSTICKS]);
				executorService.submit(philosophers[i]);

			}
			Thread.sleep(Constants.EXECUTION_RUNNING_TIME);
			for (Philosopher philosopher : philosophers) {
				philosopher.setFull(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			executorService.shutdown();
			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}

			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + "has eaten #  :" + philosopher.getEatCount() + " times");
			}

		}

	}

}
