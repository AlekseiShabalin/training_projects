package ru.ashabalin.start;

import ru.ashabalin.models.*;

/**
 * Created by Aleksei Shabalin.
 */
 
public class StartUI{
	private Input input;
	/**
	* Massive contains items Menu
	*/
	private String[] startMenu = new String[] {
		"<<< Menu programm >>>",
		"1. Create new task",
		"2. Edit task",
		"3. Look for by Id",
		"4. Look for by Name",
		"5. Add comment to task",
		"6. Delete task",
		"7. Show all task",
		"8. Press q for exit"
	};
	
	public StartUI(Input input){
		this.input = input;
	}
	
	Tracker tracker = new Tracker();
	
	/**
	* Method initialization StartUI
	*/
	public void init(){
		System.out.println("***Hello!!!***");
		boolean  position = true;
	/**
	* Loop show Menu programm
	*/
		while(position) {
			this.printStartMenu();			
			
			String question = input.ask("Please select what you want to do: ");	
			
			if(question.equals("1")){
				this.createTask();
			}
			if(question.equals("2")){
				this.editeTask();
			}
			if(question.equals("3")){
				this.searchTaskById();
			}
			if(question.equals("4")){
				this.searchTaskByName();
			}
			if(question.equals("5")){
				this.addCommentToTask();
			}
			if(question.equals("6")){
				this.deleteTask();
			}
			if(question.equals("7")){
				tracker.printTask();
			}
			
			if(question.equals("q")){
				break;
			}
		}
	}
	
	/**
	* Method print Menu programm
	*/
	private void printStartMenu(){
		for(String menu : this.startMenu) {
			System.out.println(menu);
		}
	}
	
	/**
	* Method create new Task
	*/
	private void createTask(){
		String name = input.ask("Plese enter name task: ");
		String description = input.ask("Please enter description task: ");
		String comment = input.ask("Please enter comment to task (optional):");
		System.out.println("You task create:");
		tracker.printOneTask(tracker.add(new Task(name, description, comment)));
	}
	
	/**
	* Method edit Task
	*/
	private void editeTask(){
		String id = input.ask("Please enter id task for edit: ");
		Task task = new Task("Temp name", "Temp description");
		
		// validation id
		if(tracker.findById(id) != null){
			task = (Task) tracker.findById(id);
			tracker.printOneTask(task);
		}else{
			System.out.println("This id not found");
			}
			
		String description = input.ask("Please enter description for edit task: ");
		String comment = input.ask("Please enter comment for edit task (optional): ");
		
		// validation description and comment
		if(description.equals("")){
			task.setDescription(task.getDescription());
		}else{
			task.setDescription(description);
			}
		if(comment.equals("")){
			task.setComment(task.getComment());
		}else{
			task.setComment(comment);
			}
			
		tracker.editItem(task);
		tracker.printOneTask(task);
	}
	
	/**
	* Method saerch Task by Id
	*/
	private void searchTaskById(){
		String id = input.ask("Please enter id: ");
		Task task = new Task("Temp name", "Temp description");
		
		// validation id
		if(tracker.findById(id) != null){
			task = (Task) tracker.findById(id);
			tracker.printOneTask(task);
		}else{
			System.out.println("This id not found");
			}
	}
	/**
	* Method saerch Task by Name
	*/
	private void searchTaskByName(){
		String name = input.ask("Please enter name task: ");
		Task task = new Task("Temp name", "Temp description");
		
		// validation name
		if(tracker.findByName(name) != null){
			task = (Task) tracker.findByName(name);
			tracker.printOneTask(task);
		}else{
			System.out.println("This name not found");
			}
	}
	
	/**
	* Method add comment to Task
	*/
	private void addCommentToTask(){
		String id = input.ask("Please enter id task for add comment: ");
		Task task = new Task("Temp name", "Temp description");
		
		// validation id
		if(tracker.findById(id) != null){
			task = (Task) tracker.findById(id);
			tracker.printOneTask(task);
		}else{
			System.out.println("This id not found");
			}
		String comment = input.ask("Please enter comment: ");
		task.setComment(comment);
		tracker.printOneTask(task);
	}
	
	/**
	* Method delete Task
	*/
	private void deleteTask(){
		String id = input.ask("Please enter id for delete task: ");
		Task task = new Task("Temp name", "Temp description");
		
		// validation id
		if(tracker.findById(id) != null){
			task = (Task) tracker.findById(id);
			tracker.printOneTask(task);
		}else{
			System.out.println("This id not found");
			}
			
		String question = input.ask("Are you sure what want remove task: Yes (y)/ No (n): ");
		if(question.equals("y")){
			tracker.removeItem(task);
		}
	}
			
	public static void main(String[] args){
		
		Input input = new ConsoleInput();
		new StartUI(input).init();		
	}
}