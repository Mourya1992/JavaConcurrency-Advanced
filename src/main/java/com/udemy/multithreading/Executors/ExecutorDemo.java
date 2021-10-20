package com.udemy.multithreading.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<Future<String>> result = new ArrayList<Future<String>>();
		try {
			for (int i = 0; i < 10; i++) {

				Future<String> process = executor.submit(new Processor(i));
				result.add(process);

				// System.out.println(process.get());

			}

			result.forEach(r -> {
				try {
					System.out.println(r.get());
				} catch (InterruptedException | ExecutionException e) {

					e.printStackTrace();
				}
			});
		} finally {
			((ExecutorService) executor).shutdown();
		}
	}

}
