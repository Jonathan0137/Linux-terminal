package command;

public class Exit extends Command {
	/**
	 * The constructor
	 */
	public Exit() {
		doc = "Terminates JShell and deletes all directories and files";
	}
	
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
		return this.doc;
	}
}
