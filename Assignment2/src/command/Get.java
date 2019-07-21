package command;

import driver.JShell;
import output.Output;
import redirection.Redirection;

import java.net.*;
import java.util.ArrayList;
import java.io.*;


public class Get extends Command {

	@Override
	public void execute(ArrayList<Object> params) {
		String input = (String) params.get(0);
		if (Get.getChecker(input)) {
			String userParam = Get.cleanInput(input);
			try { 
				String contents = Get.getURLContents(userParam);
				Output.getOutputInstance().addUserOutput(contents);
				Redirection.redirectionSetUp(input);
			}
			catch (Exception e) {
				Output.getOutputInstance().addErrorOutput("Get: URL does not exist");
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
			return "i";
		}
	}
}
