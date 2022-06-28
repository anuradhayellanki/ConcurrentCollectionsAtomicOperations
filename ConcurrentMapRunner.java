
package com.cashapona.concurrentcollectionandatomicoperations.jun28;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Anuradha
 *
 */
public class ConcurrentMapRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentMap<Character, LongAdder> occurances=new ConcurrentHashMap<>();
		String string="abcd abcd abcd abcd";
		/*
		 * for loop replaced by concurrent atomic operation
		 */
		for(char character:string.toCharArray()) {
			occurances.computeIfAbsent(character, ch->new LongAdder()).increment();
		}
		System.out.println(occurances);
	}

}
