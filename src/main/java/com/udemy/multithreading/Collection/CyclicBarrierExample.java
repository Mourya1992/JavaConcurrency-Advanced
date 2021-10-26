package com.udemy.multithreading.Collection;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("All the tasks are fininshed..");
		});

		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 15; i++)
			executor.execute(new Worker(i + 1, barrier));
		executor.shutdown();
	}

}

class Worker implements Runnable {

	private int id;
	private CyclicBarrier barrier;
	private Random random;

	public Worker(int id, CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
		this.random = new Random();
	}

	public void run() {
		try {
			doWork();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	private void doWork() throws InterruptedException {
		System.out.println("Thread with id " + id + " started Processing...");
		Thread.sleep(3000);

		System.out.println("Thread with id " + id + "Finished..");

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {

			e.printStackTrace();
		}
		
		System.out.println("AFter Await Statement...");

	}

}
