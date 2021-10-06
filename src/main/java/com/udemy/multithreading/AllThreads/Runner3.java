package com.udemy.multithreading.AllThreads;

public class Runner3 implements Runnable{

	@Override
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Deamon thread Running");
		}
		
	}

}
