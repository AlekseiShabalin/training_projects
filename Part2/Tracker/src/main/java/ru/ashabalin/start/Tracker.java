package ru.ashabalin.start;

import ru.ashabalin.models.*;
import java.util.*;

/**
 * Created by Aleksei Shabalin.
 */
 
public class Tracker {
	private Item[] items = new Item[20];
	private int position = 0;
	private static final Random RN = new Random();
	
	/**
	* Method add aplication
	*/
	public Item add(Item item){
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}	
	
	/**
	* Method search item by id
	*/
	public Item findById(String id){
		Item result = null;
		for (Item item : items){
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
	/**
	* Method search item by name
	*/
	public Item findByName(String name){
		Item result = null;
		for (Item item : items){
			if (item != null && item.getName().contains(name)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
	/**
	* Method generation id
	*/
	String generateId(){
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
	
	/**
	* Method get all items in tracker
	*/
	public Item[] getAll(){
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++){
			result[index] = this.items[index];
		}
		return result;
	}
	
	/**
	* Method print task in tracker
	*/
	public void printTask(){
		for (Item item : this.getAll()){
			if(item != null){
				System.out.printf("%s, %s, %s%n", item.getName(), item.getDescription(), item.getId());
			}
		}
		System.out.println();
	}
	
	/**
	* Method delete item in tracker
	*/
	public void removeItem(Item itemRemove){
		for (int index = 0; index < items.length; index++){
			if (this.items[index].getId().equals(itemRemove.getId())){
				this.items[index] = null;
				break;
			}
		}	
	}
	
	/**
	* Method edit item
	*/
	public void editItem(Item item){
		for (int index = 0; index < this.position; index++){
			if (this.items[index].getId().equals(item.getId())){
				this.items[index] = item;
				break;
			}
		}	
	}
}