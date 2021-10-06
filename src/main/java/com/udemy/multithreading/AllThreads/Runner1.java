package com.udemy.multithreading.AllThreads;

import com.udemy.multithreading.Objects.Incrementor;

public class Runner1 implements Runnable {

	private Incrementor incrementor;

	public Runner1(Incrementor incrementor) {
		this.incrementor = incrementor;
	}

	public void run() {

		try {
			incrementor.increment();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
