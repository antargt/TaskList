/*  
 * Class to handle the List of task objects
 * 
 */

package com.anthonyaragon.finalproject;

import java.util.ArrayList;

public class TaskList extends Task{
	static ArrayList<Task> taskList = new ArrayList<Task>();  // Creates an ArrayList for Task objects
	static int taskTotal;
	static int pageNumber = 1;
	final static int TASKPERPAGE = 5;  //  Limits number of tasks per screen
	static int numberOfMaxTask = Math.min(pageNumber * TASKPERPAGE, taskTotal);  //
	static int numberOfInitialTask = numberOfMaxTask - (TASKPERPAGE - 1);

	
	
	//  Adds tasks to list
		public static void addTaskToList(String taskText) {
		taskList.add(new Task(taskText));
		taskTotal++;
		}
	
	// Removes task from list
	public static void removeTask(int taskToRemove) {
		taskList.remove(taskToRemove-1);
		taskTotal--;
		}
	
	//  Toggles tasks as completed or not
	public static void toggleComplete(int taskNumber) {
Boolean complete = Task.getComplete(taskList.get(taskNumber-1));
		if (complete == false) {
			taskList.get(taskNumber-1).setComplete(true);
		} else {
			taskList.get(taskNumber-1).setComplete(false);
		}
	}
	
	//  Displays List of Tasks
	public static void showTaskList() {
		int numberOfMaxTask = Math.min(pageNumber * TASKPERPAGE, taskTotal);  //
		int numberOfInitialTask = pageNumber*TASKPERPAGE-(TASKPERPAGE-1);
		
		if (taskTotal == 0) {
			System.out.println("Task List is Empty");
		} else {
			for (int i = numberOfInitialTask; i <= numberOfMaxTask; i++) {
				if (Task.getComplete(taskList.get(i-1))) {
					System.out.println(i + ".  " + Task.getTask(taskList.get(i-1)) + "\t (COMPLETED)");
				} else {
					System.out.println(i + ".  " + Task.getTask(taskList.get(i-1)));
				}
			}
		}
		System.out.println();
		System.out.println("[" + numberOfInitialTask + "-" + numberOfMaxTask + " of " + taskTotal +"]  Enter b to go back, f to go forward");
		System.out.println();
		
	}
	
	public static void goNextPage() {
		if (taskTotal % TASKPERPAGE == 0) {
			if (pageNumber < (taskTotal / TASKPERPAGE) ) {
				pageNumber++;
			} else {
				System.out.println("can't go forward one page");
			}
		} else {
			if (pageNumber < (taskTotal / TASKPERPAGE + 1) ) {
				pageNumber++;
			} else {		
				System.out.println("can't go forward one page");
			}
		}
	}
	
	public static void goPreviousPage() {
		if (pageNumber > 1) {
			pageNumber--;
		} else {
			System.out.println("can't go back one page");
		}
	}
}
