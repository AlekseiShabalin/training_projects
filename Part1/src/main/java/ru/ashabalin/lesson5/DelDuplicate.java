package ru.ashabalin.lesson5;

/**
 * Created by Aleksei on 25.06.2016.
 */

public class DelDuplicate{
	private String[] mas;

	public DelDuplicate(String[] mas){
		this.mas = mas;
	}

	public String[] removeDuplicate(){
        for(int i = 0; i < mas.length; i++){
            if(mas[i] != null) {
                for (int j = i + 1; j < mas.length; j++) {
                    if (mas[i].equals(mas[j]) && mas[j] != null) {
                        mas[j] = null;
                        String t = mas[j];
                        for (int k = j; k < mas.length - 1; k++) {
                            mas[k] = mas[k + 1];
                       }
                       mas[mas.length - 1] = t;
                   }
               }
           }
       }
		return mas;
	}

    public String[] getDelDuplicate(){
        return mas;
    }

    public void printMassive(String mas[]){
        for(int i = 0; i < mas.length; i++){
            System.out.printf("%4s ", mas[i]);
        }
		System.out.printf("%n");
    }

	public static void main(String[] args){
		String[] mas = {"a", "b", "a", "c", "d", "f", "a", "g", "h", "j"};

		DelDuplicate delDuplicate = new DelDuplicate(mas);
		System.out.printf("%s%n", "Massive");
		delDuplicate.printMassive(mas);
		delDuplicate.removeDuplicate();
		System.out.printf("%n%s%n", "Format Massive");
		delDuplicate.printMassive(mas);
	} 
}