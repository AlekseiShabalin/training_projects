package ru.ashabalin;

/**
 * @author Aleksei Shabalin on 03.10.2016.
 */
public class ExtraTask {
	private int longArray;
	private int array[];

	public int[] getArray() {
		return array;
	}

	public void mergerArray(int array1[], int array2[]){
		this.longArray = array1.length + array2.length;
		this.array = new int[longArray];

		for(int i = 0; i < array1.length; i++){
			this.array[i] = array1[i];
		}

		for(int j = 0; j < array2.length; j++){
			this.array[array1.length + j] = array2[j];
		}

		// sort bubble
		for(int i = array.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(array[j] > array[j + 1]){
					int a = array[j];
					array[j] = array[j + 1];
					array[j + 1] = a;
				}

			}
		}

	}
}
