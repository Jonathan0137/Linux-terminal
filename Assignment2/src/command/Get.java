package command;

import driver.JShell;
import redirection.Redirect;

import java.net.*;
import java.io.*;


public class Get extends Command {

	@Override
	public void execute(JShell shell, String input) {
		if (Get.getChecker(input)) {
			String userParam = Get.cleanInput(input);
			try { 
				String contents = Get.getURLContents(userParam); //MIGHT NEED TO CHANGE userParam variable
				Redirect.redirection(shell.getDirectoryTree(), 
						input, contents);
			}
			catch (Exception e) {
				//APPEND ERROR STRING URL DNE TO OUTPUT
			}
		}
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean getChecker(String input) {
		int inputSize = input.split(" ").length;
		if (inputSize != 2 && inputSize != 4) {
			//MAKE OUTPUT CLASS HOLD ERROR STRING!
			return false;
		}
		try {
			String specialChar = input.split(" ")[2];
			if (!specialChar.contentEquals(">") || 
					!specialChar.contentEquals(">>")) {
				//MAKE OUTPUTCLASS HOLD ERROR STRING
				return false;
			}
		}
		catch (Exception e) {
			return true;
		}
		return true;
	}
	
	private static String cleanInput(String input) {
		/*String[] components = input.split(" ");
		String cleanInput = "";
		for (int i=1 ; i<components.length; i++) {
			cleanInput = cleanInput.concat(components[i]);
		}
		return cleanInput;*/
		String cleanedInput = input.split(" ")[1];
		return cleanedInput;
	}
	
	private static String getURLContents(String url) {
		String contents = "";
		String line;
		try {
			URL webAddress = new URL(url);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(webAddress.openStream()));
			while ((line = in.readLine()) != null) {
				contents = contents.concat(line);
			}
			in.close();
			return contents;
		}
		catch (Exception e) {
			//RETURN ERROR MOST DEFINETLY NEED TO CHANGE IN THE FUTURE
			int i= 1/0;
			return "";
		}
	}
}
