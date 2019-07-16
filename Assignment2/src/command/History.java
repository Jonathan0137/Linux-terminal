package command;

import java.util.ArrayList;
import output.Output;
import inputHistory.InputHistory;

/**
 * History class allows user access to JShells memory of all user inputs.
 * 
 * @author Tom Daudelin
 *
 */
public class History extends Command {

	/**
	 * Executes the users input by printing out users total history or optionally
	 * prints the last nth user inputs where n is an integer
	 * 
	 * @param shell An instance of the JShell class
	 * @param input The users input
	 */
	public void execute(ArrayList<Object> params) {
		String input = (String) params.get(0);
		String[] splitInput = input.split(" ");
		String output = "";
		if (splitInput.length == 1) {
			for (int i = 0; i < InputHistory.getInputHistory().getInputList().size(); i++) {
				output = output.concat(i + 1 + ". " + InputHistory.getInputHistory().getInputList()
						.get(i) + "\n");
			}
			Output.addUserOutput(output);
		} else {
			try {
				for (int i = InputHistory.getInputHistory().getInputList().size()
						- Integer.parseInt(splitInput[1]); i < InputHistory.getInputHistory()
						.getInputList()
								.size(); i++) {
					output = output.concat(i + 1 + ". " + InputHistory.getInputHistory()
					.getInputList().get(i) + "\n");
				}
				Output.addUserOutput(output);
			} catch (Exception e) {
				params.remove(0);
				params.add("history");
				this.execute(params);
			}
		}
	}

	/**
	 * Returns the history commands documentation
	 */
	public String getDoc() {
		String doc = "history: history [NUMBER]" + "\n\t" + "If no NUMBER"
				+ " is given, print out all user inputs since" + "\n\t\t"
				+ "activating JShell, ordered from least recent input to most" + "\n\t\t" +
				"recent input." + "\n\t"
				+ "Otherwise;" + "\n\t\t" + "print out the last n user inputs " + "where n is"
						+ " NUMBER >= 0";
		return doc;
	}
}
