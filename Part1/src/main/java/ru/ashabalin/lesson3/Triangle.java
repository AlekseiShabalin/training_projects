package ru.ashabalin.lesson3;

import static java.lang.Math.*;
import ru.ashabalin.lesson3.*;

public class Triangle{

	public static void main(String[] args) {
			
			Point a = new Point(1, 1);
			Point b = new Point(2, 5);
			Point c = new Point(4, 3);		
	
			Triangle triangle = new Triangle(a, b, c);	
			triangle.area();
	
	}

		public Point a;
		public Point b;
		public Point c;
		
		public Triangle(Point a, Point b, Point c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	
		public void area(){
			//calculate the triangle area
		
			
			if (a.distanceTo(b) >= b.distanceTo(c) + c.distanceTo(a) | b.distanceTo(c) >= a.distanceTo(a) + c.distanceTo(a) | c.distanceTo(a) >= a.distanceTo(b) + b.distanceTo(c)){
				System.out.println("A triangle can't be created");
			} else{
				double perim = (a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a)) * 0.5;
				double areaTriangle = sqrt(perim * (perim - a.distanceTo(b)) * (perim - b.distanceTo(c)) * (perim - c.distanceTo(a)));
				System.out.println("Area triangle = " + areaTriangle);
				}
	
		}
	}	