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
import fileSystem.*;
import inputCleaner.InputCleaner;
import inputHistory.InputHistory;
import output.Output;
import redirection.Redirection;
import command.Command;
import commandParameter.CommandParameter;
import verifier.Verifier;

/**
 * The JShell object allows any user to manipulate or create files, directories
 * and access user input history and directory stacks as well as terminating
 * itself through user inputs into the console.
 * 
 * @author Tom Daudelin
 *
 */
public class JShell {
	/**
	 * A directory stack for JShell to keep track of
	 */
	private DirectoryStack directoryHistory;

	/**
	 * A lever that dictates when JShell must terminate
	 */
	private boolean exitStatus;

	/**
	 * The constructor of JShell
	 */
	public JShell() {
		directoryHistory = new DirectoryStack();
		exitStatus = false;
	}

	/**
	 * Main method creates object JShell and continuously accepts and executes user
	 * inputs until user inputs "exit"
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		JShell newJShell = new JShell();
		Scanner input = new Scanner(System.in);
		while (!newJShell.exitStatus) {
			System.out.print(FileSystem.getFileSystem().getCurrentDirectory().getFullPathName() 
					+ "# ");
			String userInput = input.nextLine();
			InputHistory.getInputHistory().addToHistory(userInput);
			userInput = InputCleaner.cleanInput(userInput);
			Verifier correct = new Verifier();
			Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
			if (toBeExecuted != null) {
				if (correct.checkUserInput(userInput) == true) {
					CommandParameter param = new CommandParameter(toBeExecuted, newJShell, 
							userInput);
					toBeExecuted.execute(param.getParameters());
				}
			}
			Redirection.redirectionSetUp(userInput);
			Output.getOutputInstance().printOutput();
			Output.getOutputInstance().resetOutput();
		}
		input.close();
	}

	/**
	 * Accesses and returns a JShell object's directory stack
	 * 
	 * @return this.directoryHistory DirectoryStack instance variable in JShell
	 */
	public DirectoryStack getDirectoryStack() {
		return this.directoryHistory;
	}

	/**
	 * Sets the JShell's exit status to true in order to terminate JShell
	 */
	public void exitShell() {
		this.exitStatus = true;
	}
	
	// Used for loading a DirectoryStack
	public void setDirectoryStack(DirectoryStack newDirStack) {
	  directoryHistory = newDirStack;
	}
}
