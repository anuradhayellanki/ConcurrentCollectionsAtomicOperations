package com.cashapona.concurrentcollectionandatomicoperations.jun27;
/**
 * @author Anuradha
 */
class Table{
	/*
	 * method not synchronized
	 */
	void printTable(int n) {
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
class MyThread1 extends Thread{
	Table t;
	public MyThread1(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(5);
	}
}
class MyThread3 extends Thread{
	Table t;
	public MyThread3(Table t) {
		this.t=t;
	}
	public void run() {
		t.printTable(100);
	}
}
public class WithoutThreadSyncronizationRunner extends Thread{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table obj=new Table();
		MyThread1 myThread1=new MyThread1(obj);
		MyThread3 myThread3=new MyThread3(obj);
		myThread1.start();
		myThread3.start();
	}
}
