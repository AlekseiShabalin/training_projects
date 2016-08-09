package ru.ashabalin.start;

import ru.ashabalin.models.*;

/**
 * Created by Aleksei Shabalin.
 */

public class MenuTracker {
	private IO io;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	
	public MenuTracker(IO io, Tracker tracker) {
		this.io = io;
		this.tracker = tracker;
	}
	
	/**
	* Method contain list actions
	*/
	public void fillActions() {
		this.actions[0] = new AddItems();
		this.actions[1] = new ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = new SearchById();
		this.actions[4] = new SearchByName();
		this.actions[5] = new AddComment();
		this.actions[6] = new DelTask();
	}
	
	/**
	* Method return size menu
	*/
	
	public int[] getSize(){
		int[] size = new int[this.actions.length];
		for(int i = 0; i < this.actions.length; i++){
			if(actions[i] != null){
				size[i] = i + 1;
			}else {
				break;
			}
		}
		return size;
	}
	
	/**
	* Method select actions
	*/
	public void select(int key) {
		if(key > 0 || key <= this.actions.length){
			this.actions[key - 1].execute(this.io, this.tracker);
		} else {
			throw new MenuOutException("Out of menu range.");
		}		
	}
	
	/**
	* Method show task
	*/
	public void show(){
		System.out.println("<<<<<<< Menu programm >>>>>>>");
		for (UserAction action : this.actions) {
			if(action != null) {
				System.out.println(action.info());
			}
		}
	}
	
	/**
	* Class create new Task
	*/
	private class AddItems implements UserAction {
		
		public int key() {
			return 1;
		}
		
		public void execute(IO io, Tracker tracker) {
			String name = io.ask("Please, enter the task`s name: ");
			String description = io.ask("Please, enter the task`s description: ");
			String comment = io.ask("Please, enter the task`s comment (optional): ");
			tracker.add(new Task(name, description, comment));
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Add the new item.");
		}
	}
	
	/**
	* Class show all Tasks
	*/
	private static class ShowItems implements UserAction {
		
		public int key() {
			return 2;
		}
		
		public void execute(IO io, Tracker tracker) {
			for(Item item : tracker.getAll()) {
				if(item != null) {
					io.println(
						String.format("%s, %s, %s, %s", item.getName(), item.getDescription(), item.getId(), item.getComment())
					);
				}else {
					io.println("Tasks is not found.");
					}
			}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items.");
		}
	}
	
	/**
	* Class edit Task
	*/
	private class EditItem implements UserAction {
		public int key() {
				return 3;
			}
			
		public void execute(IO io, Tracker tracker) {
			String id = io.ask("Please, enter the task`s id: ");
			// validation id
			if(tracker.findById(id) != null){
				String description = io.ask("Please, enter the task`s description: ");
				String comment = io.ask("Please, enter the task`s comment (optional): ");
				Task task = (Task) tracker.findById(id);

				// validation description
				if(description.equals("")){
					task.setDescription(task.getDescription());
				}else{
					task.setDescription(description);
					}
				// validation comment
				if(comment.equals("")){
					task.setComment(task.getComment());
				}else{
					task.setComment(comment);
					}
				
				task.setId(id);
				tracker.editItem(task);
			}else{
				io.println("This id not found");
				}		
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Edit the new item.");
		}
	}
	
	/**
	* Class search Task by id
	*/
	private class SearchById implements UserAction {
		public int key() {
				return 4;
			}
			
		public void execute(IO io, Tracker tracker) {
			String id = io.ask("Please, enter the task`s id: ");
			// validation id
			if(tracker.findById(id) != null) {
				Task task = (Task) tracker.findById(id);
				io.println(
					String.format("%s, %s, %s, %s", task.getName(), task.getDescription(), task.getId(), task.getComment())
				);
			}else {
				io.println("This id not found.");
				}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Search task by ID.");
		}
	}
		
	/**
	* Class search Task by Name
	*/
	private class SearchByName implements UserAction {
		public int key() {
				return 5;
			}
			
		public void execute(IO io, Tracker tracker) {
			String name = io.ask("Please, enter the task`s name: ");
			//validation name
			if(tracker.findByName(name) != null) {
				Task task = (Task) tracker.findByName(name);
				io.println(
					String.format("%s, %s, %s, %s", task.getName(), task.getDescription(), task.getId(), task.getComment())
				);
			}else {
				io.println("This name not found.");
			}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Search task by Name.");
		}
	}
	
	/**
	* Class add comment to Task
	*/
	private class AddComment implements UserAction {
		public int key() {
				return 6;
			}
			
		public void execute(IO io, Tracker tracker) {
			String id = io.ask("Please, enter the task`s id: ");
			
			// validation id
			if(tracker.findById(id) != null){
				Task task = (Task) tracker.findById(id);
				tracker.printOneTask(task);	
				String comment = io.ask("Please enter comment: ");
				task.setComment(comment);
				// tracker.printOneTask(task);	
			}else{
				io.println("This id not found");
				}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Add comment to task.");
		}
	}
	
	/**
	* Class delete Task
	*/
	private class DelTask implements UserAction {
		public int key() {
				return 7;
		}
			
		public void execute(IO io, Tracker tracker) {
			String id = io.ask("Please, enter the task`s id: ");
			Task task = new Task();;
			
			// validation id
			if(tracker.findById(id) != null){
					task = (Task) tracker.findById(id);
					tracker.printOneTask(task);	
					String question = io.ask("Are you sure what want remove task: Yes (y)/ No (n): ");
				if(question.equals("y")){
					tracker.removeItem(task);
				}
			}else{
			io.println("This id not found");
			}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Delete task.");
		}
	}
}