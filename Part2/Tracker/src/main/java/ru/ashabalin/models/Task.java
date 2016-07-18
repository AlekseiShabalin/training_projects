package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */

public class Task extends Item {
	public Task(String name, String description){
		this.setName(name);
		this.setDescription(description);
	}
}