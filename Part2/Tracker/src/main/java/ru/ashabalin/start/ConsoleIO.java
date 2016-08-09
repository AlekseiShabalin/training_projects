package ru.ashabalin.start;

import java.util.*;
import java.io.PrintStream;

/**
 * Created by Aleksei Shabalin.
 */
 
public class ConsoleIO implements IO {
	private Scanner scanner = new Scanner(System.in);
	private PrintStream out = new PrintStream(System.out);
	
	public ConsoleIO (Scanner scanner, PrintStream out) {
		this.scanner = scanner;
		this.out = out;
	}
	
	public String ask(String question) {
		this.out.print(question);
		return scanner.nextLine();
	}
	
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if(exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
		
	public void println(Object value) {
		this.out.println(value);
	}
}