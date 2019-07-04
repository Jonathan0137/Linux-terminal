package command;

import java.util.ArrayList;
import driver.JShell;

public class History extends Command {
	/**
	 * Executes the users input by printing out users total history or
	 * optionally prints the last nth user inputs where n is an integer
	 * @param shell An instance of the JShell class
	 * @param input The users input
	 */
	public void execute(JShell shell, String input) {
		String[] splitInput = input.split(" ");
		if (splitInput.length == 1) {
			for (int i=0; 
					i<shell.getInputHistory().getInputList().size(); i++) {
				System.out.print(i+1 + ". " + shell.getInputHistory()
				.getInputList().get(i) + "\n");
			}
		}
		else {
			if (History.historyCheck(splitInput[1],
					shell.getInputHistory().getInputList())) {
				try {
					for (int i=shell.getInputHistory().getInputList().size()
							-Integer.parseInt(splitInput[1]); i<
							shell.getInputHistory()
							.getInputList().size(); i++) {
						String inputAtI = shell.getInputHistory()
								.getInputList().get(i);
						System.out.print(i+1 + ". " + inputAtI + "\n");
					}
				}
				catch (Exception e) {
					this.execute(shell, "history");
				}
			}
		}
	}
	
	/**
	 * Verifies that a users optional parameter is valid for the history 
	 * command
	 * @param argument User inputs optional parameter
	 * @param list The list of all user inputs
	 * @return True if argument valid, False otherwise
	 */
	private static boolean historyCheck(String argument,
			ArrayList<String> list) {
		try {
			int cap = Integer.parseInt(argument);
			if (cap<0) {
				System.out.println("bash: history: The second parameter; '" +
						cap + "' is negative");
				return false;
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("bash: history: The second parameter; '"+ 
					argument + "' is not an integer");
			return false;
		}
	}
	
	/**
	 * Returns the history commands documentation
	 */
	public String getDoc() {
		String doc = "history: history [NUMBER]" + "\n\t" + "If no NUMBER" +
				" is given, print out all user inputs since" + "\n\t\t" + 
				"activating JShell, ordered from least recent input to most" +
				"\n\t\t" + "recent input." + "\n\t" + "Otherwise;" + "\n\t\t" +
				"print out the last n user inputs where n is NUMBER >= 0";
		return doc;
	}
}
