package ru.ashabalin.start;

import ru.ashabalin.models.*;
import java.util.*;
import java.io.PrintStream;

/**
 * Created by Aleksei Shabalin.
 */
 
public class StartUI{
	private IO io;
	private Tracker tracker;
	// private int[] ranges = new int[7];
	
	public StartUI(IO io, Tracker tracker){
		this.io = io;
		this.tracker = tracker;
	}
	
	/**
	* Method initialization StartUI
	*/
	public void init(){
		System.out.println("***Hello!!!***");
		MenuTracker menu = new MenuTracker(this.io, tracker);
		menu.fillActions();
		// int[] ranges = new int[menu.getSize()];
		do{
			menu.show();
			menu.select(io.ask("Please select what you want to do: ", menu.getSize()));
		}while(!"y".equals(this.io.ask("Exit? Yes (y)/ No (n): ")));
		
	}
		
	public static void main(String[] args){	
	
		IO io = new ValidateInput(new Scanner(System.in), System.out);
		Tracker tracker = new Tracker();
		new StartUI(io, tracker).init();
	}
}