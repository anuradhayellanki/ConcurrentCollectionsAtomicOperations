package com.cashapona.concurrentcollectionandatomicoperations.jun28;

/**
 * @author Anuradha
 * program shows a unsafe implementation of counter in thread based environment
 */
class CounterThread{
	/*
	 * initialize counter variale as zero
	 */
	private int c=0;
	/**
	 * increment c value
	 */
	public void increment() {
		c++;		
	}
	/**
	 * @return
	 */
	public int get() {
		return c;
	}
}
public class WithoutAtomicVariableCounterRunner {
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
