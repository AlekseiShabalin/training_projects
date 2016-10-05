package ru.ashabalin;

/**
 * @author Aleksei Shabalin on 03.10.2016.
 */
public class ExtraTask {
	private int array[];

	public int[] getArray() {
		return array;
	}

	public void mergerArray(int array1[], int array2[]){
		int indexArray1 = 0;
		int indexArray2 = 0;
		int index = 0;
		this.array = new int[array1.length + array2.length];

		// сравниваем элементы массивов пока есть хоть один необработанный элемент
		while(indexArray1 < array1.length && indexArray2 < array2.length){
			// меньший из элементов массива записываем в
			// результирующий маассив, обновляем нужный индек массива
			if(array1[indexArray1] < array2[indexArray2]){
				array[index] = array1[indexArray1];
				indexArray1++;
			}else{
				array[index] = array2[indexArray2];
				indexArray2++;
			}
			index++;
		}

		// оставшиеся элементы одного из массивов
		// дописываем в результирующий массив
		while (indexArray1 < array1.length){
			array[index] = array1[indexArray1];
			index++;
			indexArray1++;
		}

		while (indexArray2 < array2.length){
			array[index] = array2[indexArray2];
			index++;
			indexArray2++;
		}

	}
}
