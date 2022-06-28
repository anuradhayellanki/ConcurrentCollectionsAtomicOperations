package com.cashapona.concurrentcollectionandatomicoperations.jun27;
/**
 * @author Anuradha
 * implementation of Synchronization block
 */
class Table2{
	/*
	 * used to perform synchronization on any specific resource of the method
	 * Suppose we have 50 lines of code in our method, but we want to synchronize only 5 lines,
	 * in such cases, we can use synchronized block.
	 */
	void printTable(int n) {
		synchronized(this) {
			for(int i=1;i<=5;i++) {
				System.out.println(n*i);
			}
			try {
				Thread.sleep(400);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}//end of synchronized block
}
class MyThread4 extends Thread{
	Table t;
	public MyThread4(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(5);
	}
}
class MyThread5 extends Thread{
	Table t;
	public MyThread5(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(100);
	}
}
public class SynchronizedBlockTableRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table obj=new Table();
		MyThread4 myThread4=new MyThread4(obj);
		MyThread5 myThread5=new MyThread5(obj);
		myThread4.start();
		myThread5.start();
	}
}
