package ru.ashabalin.start;

import ru.ashabalin.models.*;

/**
 * Created by Aleksei Shabalin.
 */
 
public class StartUI{
	public static void main(String[] args){
		Tracker tracker = new Tracker();
		
		// add item		
		Task taskFirst = new Task("first", "description Fisrt");
		tracker.add(taskFirst);
		Task taskSecond = new Task("second", "description Second");
		tracker.add(taskSecond);
		Task taskThird = new Task("third", "description Third");
		tracker.add(taskThird);
		Task taskFourth = new Task("fourth", "description Fourth");
		tracker.add(taskFourth);
		Task taskFifth = new Task("fifth", "description Fifth");
		tracker.add(taskFifth);
		
		//print all
		tracker.printTask();
		
		//edit item
		Task taskSixth = new Task("Sixth", "description Sixth");
		taskSixth.setId(taskFourth.getId());
		tracker.editItem(taskSixth);
		
		//look for id
		Task taskSeven = new Task("seventh", "description Seventh");
		taskSeven = (Task) tracker.findById(taskSecond.getId());
		System.out.printf("%s, %s, %s%n%n", taskSeven.getName(), taskSeven.getDescription(), taskSeven.getId());
		
		//look for name
		Task taskEighth = new Task("eighth", "description Eighth");
		taskEighth = (Task) tracker.findByName(taskThird.getName());
		System.out.printf("%s, %s, %s%n%n", taskEighth.getName(), taskEighth.getDescription(), taskEighth.getId());
		
		// remove item
		tracker.removeItem(taskFifth);
		
		tracker.printTask();
	}
}