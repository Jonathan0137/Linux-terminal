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
	 * @param params The list of required parameters for the history command
	 */
	public void execute(ArrayList<Object> params) {
		String input = (String) params.get(0);
		String[] splitInput = input.split(" ");
		int size = InputHistory.getInputHistory().getInputList().size();
		if (splitInput.length == 1) {
			for (int i = 0; i < size; i++) {
				String elementAtI = InputHistory.getInputHistory().getInputList().get(i);
				Output.getOutputInstance().addUserOutput(i + 1 + ". " + elementAtI);
			}
		} else {
			try {
				int cap = Integer.parseInt(splitInput[1]);
				for (int i = size - cap; i < size; i++) {
					String elementAtI = InputHistory.getInputHistory().getInputList().get(i);
					Output.getOutputInstance().addUserOutput(i + 1 + ". " + elementAtI);
				}
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
				+ "Otherwise;" + "\n\t\t" + "print out the last n user inputs " + "where n is" + 
				" NUMBER >= 0";
		return doc;
	}
}
