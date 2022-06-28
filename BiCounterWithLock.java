package com.cashapona.concurrentcollectionandatomicoperations.jun27;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Anuradha
 *
 */
class Counter{
	private int i=0;
	private int j=0;
	Lock lockForI=new ReentrantLock();
	Lock lockForJ=new ReentrantLock();
	public void incrementI() {
		lockForI.lock();
		i++;
		lockForI.unlock();
	}
	public int getI() {
		return i;
	}
	public void incrementJ() {
		lockForI.lock();
		j++;
		lockForI.unlock();
	}
	public int getJ() {
		return j;
	}
}
public class BiCounterWithLock {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter biCounter=new Counter();
		biCounter.incrementI();
		biCounter.incrementJ();
		System.out.println("BiCounter with locks get(5) : "+biCounter.getI());
		System.out.println(biCounter.getJ());
	}
}
