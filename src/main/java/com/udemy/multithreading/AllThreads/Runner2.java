package com.udemy.multithreading.AllThreads;

import com.udemy.multithreading.Objects.Incrementor;

public class Runner2 implements Runnable {
	private Incrementor incrementor;

	public Runner2(Incrementor incrementor) {

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
