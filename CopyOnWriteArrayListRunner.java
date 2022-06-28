package com.cashapona.concurrentcollectionandatomicoperations.jun28;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Anuradha
 *
 */
public class CopyOnWriteArrayListRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * CopyOnWriteArrayList synchronises only write(add) operations, you get more concurrency
		 */
		List<String> list=new CopyOnWriteArrayList<>();
		/*
		 * adding 3 threads
		 * if 10000 threads consuming the list values and printing them in this 
		 * situation i synchronized add method using CopyOnWriteArrayList
		 */
		list.add("anu");
		list.add("ball");
		list.add("winter");
		/*
		 * looping and printing a list of strings
		 */
		for(String element:list) {
			System.out.println(element);
		}
	}

}
