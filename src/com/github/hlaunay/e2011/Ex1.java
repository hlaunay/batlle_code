package com.github.hlaunay.e2011;

public class Ex1 {
	
	
	public static void main(String[] args) {
		System.out.println("Ex1");
		int start=0;
		int stop=10001;
		int somme = 0;
		for (int i = start; i < stop; i++) {			
			int result = sommeOfCube(decompose(i));
			if (result == i) {
				System.out.println(i + " is a Amstrong number");
				somme++;
			}
		}
		System.out.println("There is " + somme + " Amstrong Number between " + start + " and " + stop);
	}
	
	private static int cube(int a) {
		return a*a*a;
	}
	
	private static int[] decompose(int a) {
		String str = String.valueOf(a);
		int[] result = new int[str.length()]; 
		for (int i = 0; i < str.length(); i++) {
			result[i] = Integer.valueOf(str.substring(i, i+1));
		}
		return result;
	}

	private static int sommeOfCube(int[] result) {
		int somme = 0;
		for (int i = 0; i < result.length; i++) {
			int tmp = cube(result[i]);
			somme += tmp;
		}
		return somme;
	}

}
