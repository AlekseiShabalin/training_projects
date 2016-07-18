package ru.ashabalin.lesson5;

public class RotateMassive{
    private int values[][];

    public RotateMassive(int[][] values){
        this.values = values;
    }

    public int[][] rotateLeft(){
        for(int i = 0; i < values.length-1; i++){
            for(int j = i; j < values[i].length-1 - i; j++){
                int a = values[i][j];
                values[i][j] = values[j][values[i].length-1 - i];
                values[j][values[i].length-1 - i] = values[values.length-1 - i][values[i].length-1 - j];
                values[values.length-1 - i][values[i].length-1 - j] = values[values.length-1 - j][i];
                values[values.length-1 - j][i] = a;
            }
        }
        return values;
    }

    public int[][] rotateRight(){
        for(int i = 0; i < values.length-1; i++){
            for(int j = i; j < values[i].length-1 - i; j++){
                int a = values[i][j];
                values[i][j] = values[values.length-1 - j][i];
                values[values.length-1 - j][i] = values[values.length-1 - i][values[i].length-1 - j];
                values[values.length-1 - i][values[i].length-1 - j] = values[j][values[i].length-1 - i];
                values[j][values[i].length-1 - i] = a;
            }
        }
        return values;
    }

    public void printMassive(int values[][]){
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[i].length; j++){
                System.out.printf("%4d ", values[i][j]);
            }
            System.out.printf("%n");
        }
    }

	public int[][] getMassive(){
		return values;
	}

    public static void main(String[] args){
        int mas[][] = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };
        
        RotateMassive rotateMassive = new RotateMassive(mas);
        System.out.printf("%s%n", "Massive");
		rotateMassive.printMassive(mas);

        System.out.printf("%n");
        System.out.printf("%n");

        rotateMassive.rotateLeft();
		System.out.printf("%s%n", "Rotate Massive on Left");
        rotateMassive.printMassive(mas);

        System.out.printf("%n");
        System.out.printf("%n");

        rotateMassive.rotateRight();
		System.out.printf("%s%n", "Rotate Massive on Right");
        rotateMassive.printMassive(mas);
    }
}