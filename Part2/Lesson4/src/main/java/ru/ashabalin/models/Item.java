package ru.ashabalin.models;

/**
 * Created by Aleksei Shabalin.
 */

public class Item{
	private String id;
	private String name;
	private String description;
	private long create;
	private String comment;
	
	public Item(){
		
	}
	
	public Item(String name, String description, long create){
		this.name = name;
		this.description = description;
		this.create = create;
	}
	
		public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}
	public long getCreate(){
		return this.create;
	}
	public String getComment(){
		return this.comment;
	}

	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
}