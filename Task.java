/*  
 * Main object class since program focuses on Tasks
 * Future Mods:
 * 		1) add functionality for more than one list of tasks.
 * 		2) Save to a file.
 */

package com.anthonyaragon.finalproject;

public class Task {
	String task;
	Boolean complete;
			
	public Task () {
		this.task = "empty";
		this.complete = false;
	}
	
	// overloaded constructor
	public Task (String task) {
		this.task = task;
		this.complete = false;
	}
	
	
	//  Getters
	public static String getTask(Task name) {
		return name.task;
	}
	
	public static Boolean getComplete(Task name) {
		return name.complete;
	}
	
	//  Setters
	public void setTask(String name) {
		this.task = name;
	}
	
	public void setComplete(Boolean value) {
			this.complete = value;
	}
}
