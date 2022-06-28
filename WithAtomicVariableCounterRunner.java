package com.cashapona.concurrentcollectionandatomicoperations.jun28;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Anuradha
 * program shows a safe implementation of counter using AtomicInteger in thread based environment
 */
class CounterThread1{
	static class Counter{
		private AtomicInteger c=new AtomicInteger(0);
		/**
		 * increment c value automatically
		 */
		public void increment() {
			c.getAndIncrement();		
		}
		/**
		 * @return c
		 */
		public int get() {
			return c.get();
		}
	}
}
public class WithAtomicVariableCounterRunner {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		CounterThread counterThread=new CounterThread();
		//100 threads
		for(int i=0;i<100;i++) {
			new Thread(new Runnable() {
				public void run() {
					counterThread.increment();
				}
			}).start();
		}
		Thread.sleep(2000);
		System.out.println("Final number (should be 100) : "+counterThread.get());
	}
}


