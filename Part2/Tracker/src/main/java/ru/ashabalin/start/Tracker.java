package ru.ashabalin.start;

import ru.ashabalin.models.*;
import java.util.*;

/**
 * Created by Aleksei Shabalin.
 */
 
public class Tracker {
	private Item[] items = new Item[3];
	private int position = 0;
	private static final Random RN = new Random();
	
	/**
	* Method generation id
	*/
	private String generateId(){
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
		
	/**
	* Method up size array
	*/
	private Item[] upSizeItems(){
		int resultPosition = items.length + 1;
		Item[] result = new Item[resultPosition];
		position = 0;
			for(int index = 0; index < items.length; index++){
				result[index] = items[index];
				position++;
			}
		return result;
	}
		
	/**
	* Method down size array
	*/
	private Item[] downSizeItems(){
		int resultPosition = this.position - 1;
		Item[] result = new Item[resultPosition];
		position = 0;
		for(int index = 0; index < items.length - 1; index++){
			result[index] = items[index];
			position++;
		}
		return result;
	}
	
	/**
	* Method add aplication
	*/
	public Item add(Item item){
		if(this.position >= this.items.length){
			this.items = this.upSizeItems();
			item.setId(this.generateId());
			items[position++] = item;
		}else {
			item.setId(this.generateId());
			this.items[position++] = item;
			}
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
	* Method print all task from tracker
	*/
	public void printTask(){
		for (Item item : this.getAll()){
			if(item != null){
				System.out.printf("%s, %s, %s", item.getName(), item.getDescription(), item.getId());
			}
			if(item.getComment() != null){
				System.out.printf(", %s", item.getComment());
			}
			System.out.printf("%n");
		}
	}
	
	/**
	* Method print one task from tracker
	*/
	public void printOneTask(Item item){
		if(item != null){
			System.out.printf("%s, %s, %s", item.getName(), item.getDescription(), item.getId());
		}
		if(item.getComment() != null){
			System.out.printf(", %s", item.getComment());
		}
		System.out.printf("%n");
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
		if (this.position > 1) {
			for(int indexOne = 0; indexOne < items.length; indexOne++){
				if(items[indexOne] == null){
					Item itemTemp = items[indexOne];
					for(int indexTwo = indexOne; indexTwo < items.length - 1; indexTwo++){
						items[indexTwo] = items[indexTwo + 1];
					}
					items[items.length - 1] = itemTemp;					
				}			
			}	
			this.items = this.downSizeItems();	
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