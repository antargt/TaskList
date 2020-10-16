/* 
 * 
 * ---Main Menu
 * ------Add a Task Menu
 * ------Remove a Task Menu
 * ------Task Completion Menu
 * ------Show Task List Menu
 * 
 */

package com.anthonyaragon.finalproject;

public class Validator extends TaskList{
	
	
	// -------------  MENUS (gets input for menus) ------------------
	
	// MENU:  Main
	public static void mainMenu() {
		int selection = -1;  //
		while (selection != 0) {
			displayMainMenu();  // all menus are grouped at the bottom of Validator class
			selection = tryInt();
			switch(selection) {
			case 1:
				addTaskMenu();
				selection = -1;
				break;
			case 2:
				removeTaskMenu();
				selection = -1;
				break;
			case 3:
				taskCompleteMenu();
				selection = -1;
				break;
			case 4:  //  shows List Menu
				showTaskListMenu();
				selection = -1;
				break;
			case 0:  //  Exit
				return;
			default:
				System.out.println("Invalid Input:  Try again");
			}	
		}
	}
	
	//  MENU:  Add a Task 
	public static void addTaskMenu() {
		String taskText = "";
	
		while (taskText.equals("")) {
			displayAddTaskMenu();  // all menus are grouped at the bottom of Validator class
			taskText = tryString();
		
			if (taskText.equals("0")) {
				return;
			} else {
				addTaskToList(taskText);
			}
		}
	}
	
	//  MENU:  Remove a Task
	public static void removeTaskMenu() {
		String taskText = "";
		int taskTextToInteger;
		while (taskText.equals("")) {
			displayRemoveTaskMenu(); // all menus are grouped at the bottom of Validator class
			taskText = tryString();
			switch (taskText) {
				case "0":
					return;
				case "b":
					goPreviousPage();
					taskText = "";
					break;
				
				case "B":
					goPreviousPage();
					taskText = "";
					break;
				case "f":
					goNextPage();
					taskText = "";
					break;
				case "F":
					goNextPage();
					taskText = "";
					break;
				default:
					try {
						taskTextToInteger = Integer.parseInt(taskText);
					} catch (Exception e) {
						System.out.println("Invalid Entry: Try Again");
						break;
					}
					if (taskTextToInteger > 0 && taskTextToInteger <= taskTotal) {
						int selection = taskTextToInteger;
						removeTask(selection);
						selection = 0;
						taskText = "";
					} else {
						System.out.println("Invalid Entry:  Try Again.");
						taskText = "";
					}
			}	
		}
	}
	
	//  MENU:  Task Completion Menu
	public static void taskCompleteMenu() {
		String taskText = "";
		int taskTextToInteger;
		while (taskText.equals("")) {
			displayTaskCompletionMenu(); // all menus are grouped at the bottom of Validator class
			taskText = tryString();
			switch (taskText) {
				case "0":
					return;
				case "b":
					goPreviousPage();
					taskText = "";
					break;
				
				case "B":
					goPreviousPage();
					taskText = "";
					break;
				case "f":
					goNextPage();
					taskText = "";
					break;
				case "F":
					goNextPage();
					taskText = "";
					break;
				default:
					try {
						taskTextToInteger = Integer.parseInt(taskText);
					} catch (Exception e) {
						System.out.println("Invalid Entry: returning to Main Menu");
						break;
					}
					if (taskTextToInteger > 0 && taskTextToInteger <= taskTotal) {
						int selection = taskTextToInteger;
						toggleComplete(selection);
						selection = 0;
						taskText = "";
					} else {
						System.out.println("Invalid Entry - Try Again.");
						taskText = "";
					}
			}	
		}
	}
	
	//  MENU:  Task List Menu	
	public static void showTaskListMenu() {
		String taskText = "";
		
		while (taskText.equals("")) {
			displayTaskListMenu();
			taskText = tryString();
			switch (taskText) {
				case "0":
					return;
				case "b":
					goPreviousPage();
					taskText = "";
					break;
				
				case "B":
					goPreviousPage();
					taskText = "";
					break;
				case "f":
					goNextPage();
					taskText = "";
					break;
				case "F":
					goNextPage();
					taskText = "";
					break;
				default:
					System.out.println("Invalid Entry - Try again");
					taskText = "";
			}
		}
	}

	// -------------  DISPLAY MENUS  ------------------
		
	// Display Main Menu
	public static void displayMainMenu() {
		System.out.println("\n\n\n\n\n");
		System.out.println("Welcome to Task List");
		System.out.println();
		System.out.println("-----  Main Menu  -----");
		System.out.println();
		System.out.println("1.  Add a task (" + taskTotal + " tasks)");
		System.out.println("2.  Remove a task");
		System.out.println("3.  Mark a task complete");
		System.out.println("4.  List the tasks");
		System.out.println("0.  Exit the program");
		System.out.println();
		System.out.println("What would you like to do? Type menu number and press Enter to submit   ");
	}
	
	// Display Add Task Menu
	public static void displayAddTaskMenu() {
		System.out.println("\n\n\n\n\n");  //  Quasi - "clear screen"
		System.out.println("-----  Add a Task Menu  -----");
		System.out.println();
		System.out.println("0.  Exits to Main Menu");
		System.out.println();
		System.out.println("What would you like to do? Type new task and press Enter   ");
	}
	
	// Display Remove Task Menu
	public static void displayRemoveTaskMenu() {
		System.out.println("\n\n\n\n\n");  //  Quasi - "clear screen"
		System.out.println("-----  Remove Task Menu  -----");
		System.out.println();
		showTaskList();
		System.out.println("0.  Exits to Main Menu");
		System.out.println();
		System.out.println("What would you like to do? Type menu number to remove task and press Enter to submit   ");
	}
	
	public static void displayTaskCompletionMenu() {
		System.out.println("\n\n\n\n\n");  //  Quasi - "clear screen"
		System.out.println("-----  Task Completion Menu  -----");
		System.out.println();
		showTaskList();
		System.out.println();
		System.out.println("0.  Exits to Main Menu");
		System.out.println();
		System.out.println("What would you like to do? Type menu number to toggle task completed and press Enter to submit   ");
	}
	
	public static void displayTaskListMenu() {
		System.out.println("\n\n\n\n\n");  //  Quasi - "clear screen"
		System.out.println("---List of Tasks---");
		System.out.println();
		showTaskList();
		System.out.println("0.  Exits to Main Menu");
		System.out.println();
		System.out.println("What would you like to do? Type 0 to and press Enter to return to Main Menu   ");
		
	}
	
	//  Misc formatting Methods
	
	public static String tryString() {
		String text = "";
		try {
			text = GetInput.ReadInputString();
		} catch (Exception e) {
			System.out.print("ERROR:   ");
			return "0";
		}
		return text;
	}
	
	public static int tryInt() {
		int number = -1;
		try {
			number = GetInput.ReadInputInt();
		} catch (Exception e) {
			System.out.print("ERROR:   ");
			return -1;
		}
		return number;
	}
}	

