package com.github.hlaunay.e2011;

import java.util.ArrayList;

public class Ex2 {
		
	public static void main(String[] args) {
		firstNumbers(18, 38);
		firstNumbers(123, 234);
	}

	private static boolean isDivideGotRest(int a, int b) {
		return a % b != 0;
	}
	
	private static boolean isFirsNumber(int num) {
		for (int i = 2; i < num; i++) {
			if (! isDivideGotRest(num, i)) {
				return false;
			}
		}
		return true;
	}
	
	private static void firstNumbers(int lowBoundary, int highBounary) {
		System.out.println("Compute number between " + lowBoundary + " and " + highBounary);
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i = lowBoundary; i < highBounary + 1; i++) {
			boolean result = isFirsNumber(i);
			if (result) {				
				numberList.add(i);
			}
		}
		System.out.println("il y a "+ numberList.size() +" nombres premiers");
		System.out.print("les valeurs sont ");
		for (Integer integer : numberList) {
			System.out.print(integer + ", ");
		}
		System.out.println("");
		System.out.println("");
	}
}
