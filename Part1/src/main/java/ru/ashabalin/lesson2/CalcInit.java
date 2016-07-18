package ru.ashabalin.lesson2;


public class CalcInit{

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.add(25, 16);
		System.out.printf("add: %.3f%n", calc.getResult());
	
		calc.substraction(24, 18);
		System.out.printf("substraction: %.3f%n", calc.getResult());
	
		calc.div(32, 5);
		System.out.printf("div: %.3f%n", calc.getResult());
	
		calc.multiple(6, 8);
		System.out.printf("multiple: %.3f%n", calc.getResult());
		
	}
}