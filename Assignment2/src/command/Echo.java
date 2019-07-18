package command;

import java.util.ArrayList;

import driver.JShell;

public class Echo extends Command {

	@Override
	public void execute(ArrayList<Object> params) {
		
		//make string output into output class.
		//redirect call: try redirect on call.split[2] (exception print output onto JShell)
		//Done
		
	}

	@Override
	protected String getDoc() {
		String doc = "echo: echo STRING [(>or>>) OUTFILE]\n\tIf no optional"
				+ " arguments are given, print STRING onto shell.\n\t" +
				"Otherwise;" + "\n\t\t" + "If OUTFILE file does not exist," + 
				" create a new file in" + "\n\t\t\t" + "OUTFILE path with" + 
				" STRING as its contents." + "\n\t\t" + "If OUTFILE file "
				+ "and path exists, and user inputs" + "\n\t\t\t" + 
				"argument \">\", then overwrite OUTFILE file" + "\n\t\t\t" + 
				"with STRING." + "\n\t\t" + "If OUTFILE file and path exists," 
				+ " and user inputs" + "\n\t\t\t" + "argument \">>\", then " + 
				"append STRING onto" + "\n\t\t\t" + "the end of OUTFILE file.";
		return doc;
	}

}
