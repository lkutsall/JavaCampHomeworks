package miniProjectPrimeNumber;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number bigger then 1 please.");

		int number = scanner.nextInt();

		boolean isPrime = true;

		if (number < 2) {
			System.out.println("You've entered an invalid number.");
			return;
		}

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
			}
		}

		if (isPrime) {
			System.out.println("The number you've entered is a prime number.");
		} else {
			System.out.println("The number you've entered is not a prime number.");
		}

	}

}
