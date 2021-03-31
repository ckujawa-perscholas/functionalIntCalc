package com.perscholas.inclass.arraylist_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListChallenge {

	public static void main(String[] args) {
		List<Integer> ints1 = Arrays.asList(3, 4, 6, 7, 9, 12, 15, 17, 23);
		List<Integer> ints2 = Arrays.asList(3, 5, 7, 9, 10, 13, 15, 18, 23);
		
		List<Integer> shortest = ints1.size() <= ints2.size() ? ints1 : ints2;
		List<Integer> longest = shortest.equals(ints1) ? ints2 : ints1;
		List<Integer> result = new ArrayList<>(shortest.size());
		
		for (Integer i : shortest) {
			if (longest.contains(i)) {
				result.add(i);
			}
		}
		
		
		System.out.println(result);
	}
}
