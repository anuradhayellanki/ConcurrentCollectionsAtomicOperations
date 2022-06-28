package com.cashapona.concurrentcollectionandatomicoperations.jun27;
/**
 * @author Anuradha
 */
class Table1{
	/*
	 * syncronization is the capability to control the access of multiple threads to any shared recource
	 * allow only one thread to access the shared resource
	 */
	synchronized void printTable(int n) {
		for(int i=1;i<=5;i++) {
			System.out.println(n*i);
		}
		try {
			Thread.sleep(400);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class MyThread extends Thread{
	Table t;
	public MyThread(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(5);
	}
}
class MyThread2 extends Thread{
	Table t;
	public MyThread2(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(100);
	}
}
public class WithSyncrionizationTableRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table obj=new Table();
		MyThread myThread1=new MyThread(obj);
		MyThread2 myThread2=new MyThread2(obj);
		myThread1.start();
		myThread2.start();
	}

}
