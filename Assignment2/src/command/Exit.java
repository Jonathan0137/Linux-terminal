package command;

import driver.JShell;

/**
 * Exit class is in charge of terminating JShell 
 * @author Tom Daudelin
 *
 */
public class Exit extends Command {
	
	/**
	 * Terminates the JShell
	 */
	public void execute(JShell shell, String input) {
		shell.exitShell();
	}
	
	/**
	 * Returns the documentation associated with the exit command
	 * @return the documentation of the exit command
	 */
	public String getDoc() {
		String doc = "exit: exit" + "\n\t" + "Terminates shell and deletes" +
				" all memory of directory" + "\n\t\t" + "tree, user input" +
				", directory stack and files.";
		return doc;
	}
}
