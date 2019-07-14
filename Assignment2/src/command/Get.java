package command;

import driver.JShell;
import java.net.*;
import java.io.*;

public class Get extends Command {

	@Override
	public void execute(JShell shell, String input) {
		if (Get.getChecker(input)) {
			String userParam = Get.cleanInput(input);
			try {
				//REDIRECT CALL
			}
			catch (Exception e) {
				//case where its called as get URL
				Get.printURLContents(userParam);
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
		String[] components = input.split(" ");
		String cleanInput = "";
		for (int i=1 ; i<components.length; i++) {
			cleanInput = cleanInput.concat(components[i]);
		}
		return cleanInput;
	}
	
	private static void printURLContents(String url) {
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
			//MAKE CONTENTS INTO OUTPUT
		}
		catch (Exception e) {
			//ADD ERROR STATEMENT TO OUTPUT CLASS //WEBSITE DOES NOT EXIST
		}
	}
}
