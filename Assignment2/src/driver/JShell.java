// **********************************************************
// Assignment2:
// Student1: Chongmin Bai
// UTORID user_name: baichon1
// UT Student #: 1004986599
// Author: Jonathan Bai
//
// Student2: Adil Shah
// UTORID user_name: shahadi6
// UT Student #: 1004847151 
// Author: Adil Shah
//
// Student3: Tom Daudelin
// UTORID user_name: daudeli3
// UT Student #: 1005041367
// Author: Tom Daudelin
//
// Student4: Gary Xie
// UTORID user_name: xiegary
// UT Student #: 1004721401
// Author: Gary Xie
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import java.util.Scanner;

public class JShell 
{
	private FileSystem directoryTree;
	private DirectoryStack directoryHistory;
	private InputHistory userInputHistory;
	private boolean exitStatus;
	private Directory currentDirectory;
	
	public JShell() {
		directoryTree = new FileSystem();
		directoryHistory = new DirectoryStack();
		userInputHistory = new InputHistory();
		exitStatus = false;
		currentDirectory = directoryTree.getRootDirectory();
	}
	
	/**
	 * Main method creates object JShell and continuously accepts and executes 
	 * user inputs until user inputs "exit"
	 * @param args Unused
	 */
	public static void main(String[] args) {
		JShell newJShell = new JShell();
		Scanner input = new Scanner(System.in);
		while (!newJShell.exitStatus) {
			System.out.print(newJShell.currentDirectory.getFullPathName()+"# ");
			String userInput = input.nextLine();
			newJShell.userInputHistory.addToHistory(userInput);
			Verifier correct = new Verifier();
			Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
			if (toBeExecuted != null) {
				if(correct.checkUserInput(userInput)==true) {
					toBeExecuted.execute(newJShell,userInput);
					}
			}
		}
		input.close();
	}
	
	/**
	 * Accesses and returns a JShell object's directory tree
	 * @return this.directoryTree The FileSystem instance variable in JShell
	 */
	public FileSystem getDirectoryTree() {
		return this.directoryTree;
	}
	
	/**
	 * Accesses and returns a JShell object's directory stack
	 * @return this.directoryHistory DirectoryStack instance variable in JShell
	 */
	public DirectoryStack getDirectoryStack() {
		return this.directoryHistory;
	}
	
	/**
	 * Accesses and returns a JShell object's input history
	 * @return this.userInputHistory InputHistory instance variable in JShell
	 */
	public InputHistory getInputHistory() {
		return this.userInputHistory;
	}
	
	/**
	 * Accesses and returns a JShell object's current directory
	 * @return this.currentDirectory The Directory instance variable in JShell
	 */
	public Directory getCurrentDirectory() {
		return this.currentDirectory;
	}
	
	/**
	 * Sets the JShell object's current directory to newCurrent
	 * @param newCurrent The new current directory of the JShell
	 */
	public void setCurrentDirectory(Directory newCurrent) {
		this.currentDirectory = newCurrent;
	}
	
	/**
	 * Sets the JShell's exit status to true in order to terminate JShell
	 */
	public void exitShell() {
		this.exitStatus = true;
	}
}
