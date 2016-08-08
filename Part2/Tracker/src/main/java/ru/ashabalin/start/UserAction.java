package ru.ashabalin.start;

/**
 * Created by Aleksei Shabalin.
 */
 
public interface UserAction {
	int key();
	void execute(IO io, Tracker tracker);
	String info();
}