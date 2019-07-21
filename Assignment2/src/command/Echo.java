package command;

import java.util.ArrayList;

import output.Output;

/**
 * Echo class extracts a string within a user input and prints it onto shell or onto a file.
 * 
 * @author Tom Daudelin
 *
 */
public class Echo extends Command {

	/**
	 * The execute method extracts a string the user wants to either print onto
	 * shell or into a file.
	 * 
	 * @param params The list of required parameters to successfully execute command
	 *               requested command.
	 */
	@Override
	public void execute(ArrayList<Object> params) {
		String userInput = (String) params.get(0);
		String textContents = userInput.split("\"")[1];
		Output.getOutputInstance().addUserOutput(textContents);
	}
	
	@Override
	protected String getDoc() {
		String doc = "echo: echo STRING [(>or>>) OUTFILE]\n\tIf no optional"
				+ " arguments are given, print STRING onto shell.\n\t" + "Otherwise;" + "\n\t\t"
				+ "If OUTFILE file does not exist," + " create a new file in" + "\n\t\t\t" 
				+ "OUTFILE path with" + " STRING as its contents." + "\n\t\t" + "If OUTFILE file "
				+ "and path exists, and user inputs" + "\n\t\t\t" 
				+ "argument \">\", then overwrite OUTFILE file" + "\n\t\t\t" + "with STRING." 
				+ "\n\t\t" + "If OUTFILE file and path exists," + " and user inputs" + "\n\t\t\t" 
				+ "argument \">>\", then " + "append STRING onto" + "\n\t\t\t" 
				+ "the end of OUTFILE file.";
		return doc;
	}
}
