package com.cashapona.concurrentcollectionandatomicoperations.jun27;
/**
 * @author Anuradha
 *
 */
class BiCounter{
	private int i=1;
	private int j=1;
	synchronized void incrementI() {
		i++;
	}
	public int getI() {
		return i;
	}
	synchronized void incrementJ() {
		j++;
	}
	public int getJ() {
		return j;
	}
}
	public class BiCounterWithSynchronized {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiCounter biCounter=new BiCounter();
		biCounter.incrementI();
		biCounter.incrementJ();
		System.out.println("getI() : "+biCounter.getI());
		System.out.println("getJ() : "+biCounter.getJ());
	}
}