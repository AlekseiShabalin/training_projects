package ru.ashabalin;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Aleksei Shabalin on 24.10.2016.
 */

/* Создать программу, которая будет проверять, является ли слово из пяти букв,
* введённое пользователем, палиндромом (примеры: «комок», «ротор»). Если введено
* слово не из 5 букв, то сообщать об ошибке. Программа должна нормально обрабатывать
* слово, даже если в нём использованы символы разного регистра. Например, слова
* «Комок» или «РОТОР» следует также считать палиндромами.
* */

/**
 * Return true if word is palindrome and contains five letters.
 */
public class Palindrome {

	public boolean chekerWord() throws IOException {
		int LENGTH_WORD = 5;
		boolean result = false;
		StringBuilder tempWord = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		String inWord = String.valueOf(scanner.next());
		String reverseWord = "";

			if(inWord.length() == LENGTH_WORD){
				reverseWord = tempWord.append(inWord).reverse().toString();
				if(inWord.toUpperCase().equals(reverseWord.toUpperCase())){
					result = true;
				}
			}else throw new IOException(String.format("%s %s", "This word doesn`t contain five letters", inWord));

		return result;
	}

}
