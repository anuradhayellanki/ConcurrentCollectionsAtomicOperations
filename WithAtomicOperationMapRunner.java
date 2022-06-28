package com.cashapona.concurrentcollectionandatomicoperations.jun28;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Anuradha
 *
 */
public class WithAtomicOperationMapRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Character, LongAdder> occurences=new Hashtable<>();
		String string="abcd abcd abcd abcd";
		/*
		 * code in for loop is atomic
		 * it is thread safe
		 */
		for(char character :string.toCharArray()) {
			LongAdder longAdder=occurences.get(character);
			if(longAdder==null) {
				longAdder=new LongAdder();
			}
			longAdder.increment();
			occurences.put(character, longAdder);
		}
		System.out.println(occurences);
	}
}
