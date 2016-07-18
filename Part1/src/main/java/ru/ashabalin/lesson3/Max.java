package ru.ashabalin.lesson3;

public class Max{

	public static void main(String[] args) {
	
		Point a = new Point(1, 1);
		Point b = new Point(2, 5);
		Point c = new Point(4, 3);	
		
		Triangle triangle = new Triangle(a, b, c);	
			
		double maxLenghtTwo = Math.max(a.distanceTo(b), b.distanceTo(c));
		double maxLenghtTree = Math.max(c.distanceTo(a), maxLenghtTwo);
	
		System.out.println(maxLenghtTree);


	}
}