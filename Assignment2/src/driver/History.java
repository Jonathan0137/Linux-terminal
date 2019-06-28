package driver;

import java.util.ArrayList;

public class History extends Command {
	
	public History() { 
		doc = "Displays user inputs, or given an extra integer parameter n,"
				+ " will display the last n inputs";
	}
	
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
				System.out.print(i+1);
				System.out.print(". ");
				System.out.println(shell.
						getInputHistory().getInputList().get(i));
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
						System.out.print(i+1);
						System.out.print(". ");
						System.out.println(inputAtI);
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
	 * @return boolean True if argument valid, False otherwise
	 */
	public static boolean historyCheck(String argument,
			ArrayList<String> list) {
		try {
			int cap = Integer.parseInt(argument);
			if (cap>list.size()) {
				return true;
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("The second parameter; '"+ argument+
					"' is not an integer");
			return false;
		}
	}
	
	public String getDoc() {
		return this.doc;
	}
}
