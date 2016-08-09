package ru.ashabalin.start;

import java.util.*;
import java.io.PrintStream;

/**
 * Created by Aleksei Shabalin.
 */

public class ValidateInput extends ConsoleIO {
	
	public ValidateInput (Scanner scanner, PrintStream out) {
		super(scanner, out);
	}
	
	public int ask(String question, int[] range){
		boolean invalid = true;
		int value = -1;
		do{
			try{
				value = super.ask(question, range);
				invalid = false;
			}catch(MenuOutException moe){
				System.out.println("Please select menu number.");
			}catch(NumberFormatException nfe){
				System.out.println("Please enter validate data again.");
			}
		} while(invalid);
		return value;
	}
}