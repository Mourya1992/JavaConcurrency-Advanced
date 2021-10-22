package com.udemy.multithreading.Executors;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapExample {

	public static void main(String... Args) {
		System.out.println("Hi there");

		ExecutorService readerService = Executors.newFixedThreadPool(3);
		ExecutorService writerExecutorService = Executors.newFixedThreadPool(5);
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

		for (int i = 0; i < 10; i++) {

			writerExecutorService.execute(new Writer(map, i));
			readerService.execute(new Reader(map, i));

		}

	}

}

class Reader implements Runnable {

	private ConcurrentHashMap<Integer, String> map;
	private int number;

	public Reader(ConcurrentHashMap<Integer, String> map, int number) {

		this.map = map;
		this.number = number;
	}

	public void run() {
		System.out.println("Reading .."+number+":" + map.get(number));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Writer implements Runnable {
	private ConcurrentHashMap<Integer, String> map;
	private Random rand = new Random();
	private int number = 0;

	public Writer(ConcurrentHashMap<Integer, String> map, int number) {

		this.map = map;
		this.number = number;
	}

	@Override
	public void run() {

		System.out.println("Writing to Map... with key::" + number);

		map.put(number, UUID.randomUUID().toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
