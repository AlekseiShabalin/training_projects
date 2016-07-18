package ru.ashabalin.lesson4;

import static java.lang.Math.*;

public class Square{
	
	public double a;
	public double b;
	public double c;
	public double x;
	public double y;
		
	public Square(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float calculate(int x){
	
		this.x = x;
						
			y = (a * pow(x, 2) + b * x + c);
			return (float) y;
	}


	public static void main(String[] args){

		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		int x1 = Integer.valueOf(args[3]);
		int x2 = Integer.valueOf(args[4]);
		int step = Integer.valueOf(args[5]);
		
		Square square = new Square(a, b, c);

		if(x2 < x1){
			System.out.printf("%s%n", "x2 < x1!!! Enter other value x1 and x2.");
		} else{
				while(x1 < x2){
						System.out.printf("%f%n", square.calculate(x1));
						x1 += step;
				}
			}
	}
	
}