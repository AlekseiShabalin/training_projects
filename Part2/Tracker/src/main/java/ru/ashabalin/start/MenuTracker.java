package ru.ashabalin.start;

import ru.ashabalin.models.*;

/**
 * Created by Aleksei Shabalin.
 */

public class MenuTracker {
	private IO io;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	private int position = 0;
	
	public MenuTracker(IO io, Tracker tracker) {
		this.io = io;
		this.tracker = tracker;
	}
	
	/**
	* Method contain list actions
	*/
	public void fillActions() {
		this.actions[position++] = new AddItems("Add the new item.");
		this.actions[position++] = new ShowItems("Show all items.");
		this.actions[position++] = new EditItem("Edit the new item.");
		this.actions[position++] = new SearchById("Search task by ID.");
		this.actions[position++] = new SearchByName("Search task by Name.");
		this.actions[position++] = new AddComment("Add comment to task.");
		this.actions[position++] = new DelTask("Delete task.");
	}
	
	/**
	* Method add event
	*/	
	public void addAction(UserAction action) {
		this.actions[position++] = action;
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
	private class AddItems extends BaseAction {
		
		AddItems(String name){
			super(name);
		}
		
		public int key() {
			return 1;
		}
		
		public void execute(IO io, Tracker tracker) {
			String name = io.ask("Please, enter the task`s name: ");
			String description = io.ask("Please, enter the task`s description: ");
			String comment = io.ask("Please, enter the task`s comment (optional): ");
			tracker.add(new Task(name, description, comment));
		}
	}
	
	/**
	* Class show all Tasks
	*/
	private static class ShowItems extends BaseAction {
		
		ShowItems(String name){
			super(name);
		}
		
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
	}
	
	/**
	* Class edit Task
	*/
	private class EditItem extends BaseAction {
		
		EditItem(String name){
			super(name);
		}
		
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
	}
	
	/**
	* Class search Task by id
	*/
	private class SearchById extends BaseAction {
		
		SearchById(String name){
			super(name);
		}
		
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
	}
		
	/**
	* Class search Task by Name
	*/
	private class SearchByName extends BaseAction {
		
		SearchByName(String name){
			super(name);
		}
		
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
	}
	
	/**
	* Class add comment to Task
	*/
	private class AddComment extends BaseAction {
		
		AddComment(String name){
			super(name);
		}
		
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
	}
	
	/**
	* Class delete Task
	*/
	private class DelTask extends BaseAction {
		
		DelTask(String name){
			super(name);
		}
		
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
	}
}