package com.github.hlaunay.e2011;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phrase1 = "ça compile ça marche stop";
		String phrase2 = "mon chien s appelle rodi stop";
		
		compte(phrase1);
		compte(phrase2);
		
	}

	private static void compte(String phrase1) {
		List<String> mots = new ArrayList<>();
		String reste = phrase1;
//		System.out.println("reste  = " + reste);
		while (reste.contains(" ") && reste.length() > 0) {
			int position = reste.indexOf(" ");
//			System.out.println("position = " + position);
			String word = reste.substring(0, position);
//			System.out.println("word = " + word);
			if (!word.equals("stop")) {	
//				System.out.println("Add word");
				mots.add(word);
			}
			reste = reste.substring(position + 1);
//			System.out.println("new reste  = " + reste);
//			System.out.println(String.valueOf(reste.contains(" ")));
//			System.out.println(reste.length());
		}
		
		float somme = 0;
		for (String string : mots) {
//			System.out.println(string);
			somme+=(string.length()/10.0)+1;
		}
		System.out.println("somme = " + somme);
	}

}
