package ru.ashabalin.lesson3;

import ru.ashabalin.lesson3.*;

public class MaxLenghtPolygon{

	public static void main(String[] args) {
	
		Point a = new Point(1, 1);
		Point b = new Point(2, 5);
		Point c = new Point(4, 3);	
		Point d = new Point(8, 6);
		Point e = new Point(14, 9);
		
		Polygon polygon = new Polygon(a, b, c, d, e);	
			
		double maxLenghtTwo = Math.max(a.distanceTo(b), b.distanceTo(c));
		double maxLenghtTree = Math.max(c.distanceTo(d), maxLenghtTwo);
		double maxLenghtFour = Math.max(d.distanceTo(e), maxLenghtTree);
		double maxLenghtFive = Math.max(d.distanceTo(e), maxLenghtFour);
	
		System.out.println(maxLenghtFive);

	}

		public Point a;
		public Point b;
		public Point c;
		public Point d;
		public Point e;
		
		public Polygon(Point a, Point b, Point c, Point d, Point e) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
		}

}