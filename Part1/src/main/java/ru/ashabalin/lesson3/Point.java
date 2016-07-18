package ru.ashabalin.lesson3;

import static java.lang.Math.*;

public class Point{
	public double x;
	public double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point){
		//calculate distance between two points
		return sqrt(pow((x - point.x), 2) + pow((y - point.y), 2));
	}
}