package ru.ashabalin;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * @author Aleksei Shabalin on 22.10.2016.
 */


/**
 * Return the minimum number of modulo from three numbers
 */

public class MinimumNumber {

	public double minimumNumber() {
		Scanner scanner = new Scanner(System.in);
		double result;
		double[] inNumber = new double[3];

		System.out.println("Enter three value");
		for(int i = 0; i < inNumber.length; i++){
			inNumber[i] = Double.valueOf(scanner.next());
		}

		result = inNumber[0];

		for(int j = 0; j < inNumber.length; j++){
			if(abs(result) >= abs(inNumber[j])){
				result = inNumber[j];
			}
		}

		return result;
	}
}
