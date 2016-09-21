package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */
 
public class Figure {
	private String name;
	private String color;
	private boolean rightStep;


	public Figure() {
	}

	public Figure(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	/**
	 * @param fromX start coordinate x
	 * @param fromY start coordinate y
	 * @param toX finish coordinate x
	 * @param toY finish coordinate y
	 */
	public boolean move(int fromX, int fromY, int toX, int toY){
		if((toX - fromX == 0 && toY - fromY == 0)|| fromX < 0 || fromX > 7 || fromY < 0 || fromY > 7 || toX < 0 || toX > 7 || toY < 0 || toY > 7) {
			this.rightStep = false;
		}else{
			rightStep = true;
			}
		return rightStep;

	}


}