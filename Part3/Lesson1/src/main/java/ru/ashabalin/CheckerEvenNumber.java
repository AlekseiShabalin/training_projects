package ru.ashabalin;

import java.io.*;

/**
 * @author Aleksei Shabalin on 09.10.2016.
 */
public class CheckerEvenNumber {

	public boolean isNumber(InputStream in) throws IOException {
		boolean isEvenNumber;

		if(in.read() % 2 == 0){
			isEvenNumber = true;
		}else{
			isEvenNumber = false;
		}

		return isEvenNumber;
	}

}
