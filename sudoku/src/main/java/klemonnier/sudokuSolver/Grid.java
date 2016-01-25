package klemonnier.sudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Grid {
	private int[][] grille;
	
	public Grid() {
		grille = new int[9][9];
	}
	
	public void parseFile(File fileToParse) throws FileNotFoundException {
		Scanner scanner = new Scanner(fileToParse);
		for (int i = 0; i < 9; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < 9; j++) {
				if (Character.isDigit(line.charAt(j))) {
					grille[i][j] = Character.getNumericValue(line.charAt(j));
				} else {
					grille[i][j] = 0;
				}
			}
		}
		scanner.close();
	}
	
	public void displayGrid() {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print(grille[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isPossible(int l, int c, int nb) {
		//Lignes
		for (int j = 0; j < 9; j++) {
			if (grille[l][j] == nb) {
				return false;
			}
		}
		
		//Colonnes
		for (int i = 0; i < 9; i++) {
			if (grille[i][c] == nb) {
				return false;
			}
		}
		
		//Carré
		int l1 = 3 * (l/3);
		int c1 = 3 * (c/3);
		for (int i = l1; i < l1+3; i++) {
			for (int j = c1; j < c1+3; j++) {
				if (grille[i][j] == nb) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean solveSudoku() {
		List<Integer> possibilities = new LinkedList<Integer>();
		int l, c;
		l = 0;
		c = 0;
		int nbPos = 10;
		
		// Look for first
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int count = 0;
				List<Integer> localPos = new LinkedList<Integer>();
				if (grille[i][j] == 0) {
					for (int n = 1; n <= 9; n++) {
						if (isPossible(i, j, n)) {
							count++;
							localPos.add(n);
						}
					}
					if (count < nbPos) {
						nbPos = count;
						possibilities = localPos;
						l=i;
						c=j;
					}
				}
			}
		}
		
		if (nbPos == 10) {
			// The sudoku is solved
			displayGrid();
			return true;
		} else {
			for (int pos : possibilities) {
				grille[l][c] = pos;
				//récursion :-)
				if (solveSudoku()) {
					return true;
				}
			}
			grille[l][c] = 0; //Réinitialisation
			return false;
		}
	}
}
