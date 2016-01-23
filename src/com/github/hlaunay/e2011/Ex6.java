package com.github.hlaunay.e2011;

public class Ex6 {

	public static void main(String[] args) {		
		printResult(1000.23);
		printResult(123.456);
	}

	private static void printResult(double litres) {
		System.out.println("Pour " + litres + "L,");
		// conversion en mL
		int ml = (int)(litres*1000);

		int nbGirafes = ml/3000;
		int nbPintes = (ml%3000)/500;
		int nbDemi = (ml%3000%500)/250;
		int nbGalopin = (ml%3000%500%250)/125;

		System.out.print("l'architecte va boire ");
		System.out.print(nbGirafes);
		System.out.print(" girafe(s), ");
		System.out.print(nbPintes);
		System.out.print(" pinte(s), ");
		System.out.print(nbDemi);
		System.out.print(" demi(s) et ");
		System.out.print(nbGalopin);
		System.out.print(" galopin(s) avant d'aller faire un autre bar...");
		System.out.print("\n\n");
	}

}
