package ru.ashabalin.start;

import ru.ashabalin.models.*;
import java.util.*;
import java.io.PrintStream;

/**
 * Created by Aleksei Shabalin.
 */
 
public class StartUI{
	private IO io;
	
	public StartUI(IO io){
		this.io = io;
	}
	
	/**
	* Method initialization StartUI
	*/
	public void init(){
		System.out.println("***Hello!!!***");
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.io, tracker);
		menu.fillActions();
		do{
			menu.show();
			int key = Integer.valueOf(io.ask("Please select what you want to do: "));
			if(key > 0 && key < 8) {
				menu.select(key);
			}else{
				io.println("You have entered an incorrect menu number.");
				}
		}while(!"y".equals(this.io.ask("Exit? Yes (y)/ No (n): ")));
		
	}
		
	public static void main(String[] args){	
	
		IO io = new ConsoleIO(new Scanner(System.in), System.out);
		new StartUI(io).init();
	}
}