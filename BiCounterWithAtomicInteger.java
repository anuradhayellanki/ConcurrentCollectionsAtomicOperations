package com.cashapona.concurrentcollectionandatomicoperations.jun27;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Anuradha
 *
 */
class BiCounter1{
	private AtomicInteger i=new AtomicInteger(1);
	private AtomicInteger j=new AtomicInteger(1);
	void incrementI() {
		i.getAndIncrement();
	}
	public int getI() {
		return i.get();
	}
	void incrementJ() {
		j.getAndIncrement();
	}
	public int getJ() {
		return i.get();
	}
}
public class BiCounterWithAtomicInteger {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiCounter1 biCounter=new BiCounter1();
		biCounter.incrementI();
		biCounter.incrementJ();
		System.out.println("getI() : "+biCounter.getI());
		System.out.println("getJ() : "+biCounter.getJ());
	}

}
