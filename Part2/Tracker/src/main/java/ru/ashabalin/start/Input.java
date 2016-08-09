package ru.ashabalin.start;

/**
 * Created by Aleksei Shabalin.
 */
 
public interface Input {
	
	String ask(String question);
	
	int ask(String question, int[] range);
}