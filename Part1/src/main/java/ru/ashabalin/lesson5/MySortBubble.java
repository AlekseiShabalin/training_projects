package ru.ashabalin.lesson5;

public class MySortBubble{
	
	public int values[];
	
	public int[] getValues(){
		return values;
	}
	
	public void sortBubbleMinToMax(int values[]){
		this.values = values;
		for(int i = values.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(values[j] > values[j + 1]){
					int a = values[j];
					values[j] = values[j + 1];
					values[j + 1] = a;
				}
			}
		}
	}

	public void sortBubbleMaxToMin(int values[]){
		this.values = values;
		for(int i = values.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(values[j] < values[j + 1]){
					int a = values[j];
					values[j] = values[j + 1];
					values[j + 1] = a;
				}
			}
		}		
	}

	
	public static void main(String[] args){
		int values[] = new int[] {2, 12, 3, 1, 5, 16, 18, 4, 22, 6};
		MySortBubble mySortBubble = new MySortBubble();
		mySortBubble.sortBubbleMinToMax(values);
		for(int i = 0; i < values.length; i++){
			System.out.printf("%d ", values[i]);
		}
		
		System.out.printf("%n");	
		
		mySortBubble.sortBubbleMaxToMin(values);
		for(int i = 0; i < values.length; i++){
			System.out.printf("%d ", values[i]);
		}
	}
}