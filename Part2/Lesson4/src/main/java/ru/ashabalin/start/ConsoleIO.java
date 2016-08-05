package ru.ashabalin.start;

import java.util.*;
import java.io.PrintStream;

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
	
	public void println(Object value) {
		this.out.println(value);
	}
}