package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */

public class Task extends Item {
	public Task(String name, String description){
		this.setName(name);
		this.setDescription(description);
	}
	
	public Task(String name, String description, String comment){
		this.setName(name);
		this.setDescription(description);
		this.setComment(comment);
	}
}