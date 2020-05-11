package com.javamsdt.javaMaven;

import java.util.Random;

public class App {
	private static Random random = new Random();

	public static void main(final String[] args) {

		final String bin = "110101";


		int n = 20;
		for (final int i = 0; i < n; n--) {
			System.out.println("Printerd");
		}
		/*
		 * int[][] binaryArray = new int[6][6]; fillArray(binaryArray);
		 * printArray(binaryArray);
		 * 
		 * printbinaryToDecimalArray(binaryArray);
		 */
	}

	// To Fill an 2 Dimensional Array with Random values
	static void fillArray(final int[][] array) {
		for (int o = 0; o < array.length; o++) {
			for (int i = 0; i < array[o].length; i++) {
				array[o][i] = random.nextInt(2);
			}
		}
	}

	// First Option just to print the results Directly
	static void printArray(final int[][] arr) {
		int binaryCalculator = 0;
		String binaryString = "";
		for (int o = 0; o < arr.length; o++) {
			for (int i = 0; i < arr[o].length; i++) {
				final int cellValue = arr[o][i];
				binaryString = binaryString + Integer.toString(cellValue);
				binaryCalculator = binaryCalculator + getBinaryValue(i, cellValue);
			}
			System.out.println(binaryString + " = " + binaryCalculator);
			binaryString = "";
			binaryCalculator = 0;
		}
	}

	static int getBinaryValue(final int iterator, final int binaryValue) {
		int value = 0;

		switch (iterator) {
		case 0:
			value = binaryValue == 1 ? 32 : 0;
			break;
		case 1:
			value = binaryValue == 1 ? 16 : 0;
			break;
		case 2:
			value = binaryValue == 1 ? 8 : 0;
			break;
		case 3:
			value = binaryValue == 1 ? 4 : 0;
			break;
		case 4:
			value = binaryValue == 1 ? 2 : 0;
			break;
		case 5:
			value = binaryValue == 1 ? 1 : 0;
			break;
		default:
			break;
		}
		return value;
	}

	// Second Option
	static int[][] binaryToDecimal(final int[][] arr) {
		final int[][] binaryDecimal = new int[arr.length][];

		int binaryCalculator = 0;
		String binaryString = "";
		for (int o = 0; o < arr.length; o++) {
			for (int i = 0; i < arr[o].length; i++) {
				final int cellValue = arr[o][i];
				binaryString = binaryString + Integer.toString(cellValue);
				binaryCalculator = binaryCalculator + getBinaryValue(i, cellValue);
				System.out.println(binaryString);
			}

			binaryDecimal[o][0] = Integer.getInteger(binaryString.trim());
			binaryDecimal[o][1] = binaryCalculator;
			binaryString = "";
			binaryCalculator = 0;
		}

		return binaryDecimal;
	}

	// Print For Second Option
	static void printbinaryToDecimalArray(final int[][] binaryDecimal) {
		final int[][] binaryToDecimal = binaryToDecimal(binaryDecimal);

		for (int o = 0; o < binaryToDecimal.length; o++) {
			for (int i = 0; i < binaryToDecimal[o].length; i++) {
				System.out.println(binaryToDecimal[o][i]);
			}
		}
	}

}
