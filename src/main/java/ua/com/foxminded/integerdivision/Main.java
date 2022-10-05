package ua.com.foxminded.integerdivision;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter two digits (use space to separate) to divide them"
				+ "\nTo quit enter '-1' for one of numbers");
		IntegerDivision integerDivision = new IntegerDivision();
		DivisionFormatter formatter = new DivisionFormatter();
		int dividend = scanner.nextInt();
		int divisor = scanner.nextInt();
		while (dividend != -1 && divisor != -1) {
			System.out.println("Result: ");
			DivisionResult result = integerDivision.divide(dividend, divisor);
			System.out.println(formatter.format(result));
			dividend = scanner.nextInt();
			divisor = scanner.nextInt();
		}
		System.out.println("Successfully quited!");
		scanner.close();
	}
}
