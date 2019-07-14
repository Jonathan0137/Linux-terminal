package command;

import driver.JShell;

public class Echo extends Command {

	@Override
	public void execute(JShell shell, String input) {
		String inputString = input.split(" ", 2)[1].split("\"")[1];
		//make string output into output class.
		//redirect call: try redirect on call.split[2] (exception print output onto JShell)
		//Done
		
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

}
