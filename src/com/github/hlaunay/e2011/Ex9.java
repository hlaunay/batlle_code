package com.github.hlaunay.e2011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex9 {

	private static final int SIZE = 9;

	public static void main(String[] args) {
		String sudoku_dir = "2011" + File.separator + "sudoku";
		String grid_file = sudoku_dir + File.separator + "n1.txt";
		File f = new File(grid_file);
		int[][] grid = readGridFile(f);
		System.out.println("Solution found; " + String.valueOf(haveSolution(grid, 0)));
		printGrid(grid);
	}

	/**
	 * @param grid
	 *            sudoku grid
	 * @param cellNumber
	 *            cell number to fill 0 <= cellNumber < 81
	 * @return true if the grid have a solution
	 */
	private static boolean haveSolution(int[][] grid, int cellNumber) {
		// if you reach the 81 cell
		// it means that the grid have solution for
		// each previous lines
		if (cellNumber == 81) {
			return true;
		} else {
			int line = cellNumber / 9;
			int column = cellNumber % 9;
			int cellValue = grid[line][column];

			if (cellValue == -1) {
				boolean[] possibilities = checkPossibilities(grid, line, column);
				int nbPossibilities = nbPossibilities(possibilities);
				if (nbPossibilities == 0) {
					return false;
				}
				for (int i = 0; i < possibilities.length; i++) {
					if (possibilities[i]) {
						int value = i+1;
						grid[line][column]=value;
						if(haveSolution(grid, cellNumber+1)){
							return true;
						}
					}
				}
				grid[line][column]=-1;
				return false;
			} else {
				return haveSolution(grid, cellNumber + 1);
			}
		}
	}

	private static int nbPossibilities(boolean[] possibilities) {
		int nbPossibilities = 0;
		for (int i = 0; i < SIZE; i++) {
			if (possibilities[i]) {
				nbPossibilities++;
			}
		}
		return nbPossibilities;
	}

	/*
	 * Check cell by cell every number not in the line nor in the column nor in
	 * the square
	 */
	private static boolean[] checkPossibilities(int[][] grid, int line, int column) {

		// init: every number is a possibility to fill the cell
		boolean[] possibilities = new boolean[SIZE];
		for (int k = 0; k < SIZE; k++) {
			possibilities[k] = true;
		}

		// check line
		for (int cursor = 0; cursor < SIZE; cursor++) {
			int cellValue = grid[line][cursor];
			if (cellValue != -1) {
				possibilities[cellValue-1] = false;
			}
		}

		// check column
		for (int cursor = 0; cursor < SIZE; cursor++) {
			int cellValue = grid[cursor][column];
			if (cellValue != -1) {
				possibilities[cellValue-1] = false;
			}
		}

		// check square
		// compute boundaries of the square
		int lowerLineBoundary = ((line) / 3) * 3;
		int upperLineBoundary = (((line) / 3) + 1) * 3;
		int lowercolumnBoundary = ((column) / 3) * 3;
		int uppercolumnBoundary = ((column) / 3 + 1) * 3;
		for (int cursorLine = lowerLineBoundary; cursorLine < upperLineBoundary; cursorLine++) {
			for (int cursorcolumn = lowercolumnBoundary; cursorcolumn < uppercolumnBoundary; cursorcolumn++) {
				int cellValue = grid[cursorLine][cursorcolumn];
				if (cellValue != -1) {
					possibilities[cellValue-1]=false;
				}
			}
		}
		
		return possibilities;
	}

	private static void printGrid(int[][] grid) {
		System.out.println();
		System.out.println("**********");
		for (int line = 0; line < SIZE; line++) {
			for (int column = 0; column < SIZE; column++) {
				int value = grid[line][column];
				if (value > 0) {
					System.out.print(value + ",");
				} else {
					System.out.print(" ,");
				}
			}
			System.out.print("\n");
		}
	}

	private static int[][] readGridFile(File f) {
		int[][] grid = new int[SIZE][SIZE];

		try {
			InputStream ips = new FileInputStream(f);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			for (int i = 0; i < SIZE; i++) {
				String line = br.readLine();
				for (int y = 0; y < SIZE; y++) {
					String cell = "" + line.charAt(y);
					if (cell.equals(" ")) {
						grid[i][y] = -1;
					} else {
						int value = Integer.parseInt(cell);
						grid[i][y] = value;
					}
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grid;
	}
}
