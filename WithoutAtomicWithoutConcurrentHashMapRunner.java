package com.cashapona.concurrentcollectionandatomicoperations.jun28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anuradha
 * concurrent collections offer thread safety without significance performs impact in soecific scenarios
 */
public class WithoutAtomicWithoutConcurrentHashMapRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string="abcd abcd abcd abcd";
		Map<Character,Integer> occurances=new HashMap<>();
		char[] characters=string.toCharArray();
		/*
		 * code in for loop is not atomic
		 * it is not thread safe
		 */
		for(char character:characters) {
			/*
			 * get the character
			 */
			Integer integer=occurances.get(character);
			if(integer==null) {
				occurances.put(character, 1);
			}else {
				occurances.put(character, integer+1	);
			}
		}
		System.out.println(occurances);
	}
}
