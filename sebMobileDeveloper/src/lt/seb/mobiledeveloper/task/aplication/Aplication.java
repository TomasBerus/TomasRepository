package lt.seb.mobiledeveloper.task.aplication;

import java.util.Scanner;

public class Aplication {
	public static void main(String[] args) {
		// Controllable variables
		int coefficientA = 16807;
		int coefficientB = 48271;
		int divisor = 2147483647;
		int cyclesNumber = 1000000;
		int bitsRequired = 8;

		// Initialized variables
		int result = 0;
		int valueA = 0;
		int valueB = 0;

		Scanner scanner = new Scanner(System.in);
		valueA = enterValue(scanner, valueA);
		valueB = enterValue(scanner, valueB);

		scanner.close();

		generateComparison(coefficientA, coefficientB, divisor, result, cyclesNumber, valueA, valueB, bitsRequired);
	}

	public static int enterValue(Scanner scanner, int value) {
		while (value <= 0) {
			System.out.println("Please enter the starting number");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a positive number");
				scanner.next();
			}
			value = scanner.nextInt();
			System.out.println("Number entered: " + value);
		}
		return value;
	}

	public static void generateComparison(int coefficientA, int coefficientB, int divisor, int result, int cyclesNumber,
			int valueA, int valueB, int bitsRequired) {
		String comparisonA;
		String comparisonB;
		for (int i = 0; i < cyclesNumber; i++) {
			long multipliedValueA = (long) valueA * (long) coefficientA;
			long multipliedValueB = (long) valueB * (long) coefficientB;
			int remainderA = (int) (multipliedValueA % divisor);
			int remainderB = (int) (multipliedValueB % divisor);

			String binaryA = Integer.toBinaryString(remainderA);
			String binaryB = Integer.toBinaryString(remainderB);
			try {
				comparisonA = binaryA.substring(binaryA.length() - bitsRequired);
				comparisonB = binaryB.substring(binaryB.length() - bitsRequired);
				if (comparisonA.contentEquals(comparisonB)) {
					result++;
				}
			} catch (Exception e) {
				if (binaryA.contentEquals(binaryB)) {
					result++;
				}
			}
			valueA = remainderA;
			valueB = remainderB;
		}
		System.out.println("Number of matches be after " + cyclesNumber + " cycles is " + result);
	}
}
