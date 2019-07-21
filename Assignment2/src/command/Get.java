package command;

import output.Output;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Get command extracts all the contents of a website given a URL and adds the contents to a file
 * inside the FileSystem
 * @author Tom Daudelin
 *
 */
public class Get extends Command {
	
	/**
	 * Extracts all the contents of a website with URL given by the user and add them to a File 
	 * within the current directory or send the to Output list for future redirection depending
	 * on users get call input.
	 * @param params The list of required parameters to successfully execute the get command.
	 */
	@Override
	public void execute(ArrayList<Object> params) {
		String input = (String) params.get(0);
		String userParam = Get.cleanInput(input);
		boolean success = Get.getURLContents(userParam);
		if (success && input.split(" ").length == 2) {
			String fileName = userParam.split("/")[userParam.split("/").length-1];
			
		}
	}
	
	/**
	 * Returns the pre-written documentation for the get command.
	 * @return The string representation of the documentation for the get command
	 */
	@Override
	protected String getDoc() {
		String doc = "get: get URL [(>or>>) OUTFILE]" + "\n\t" + "If URL is valid, extract "
				+ "all contents on the associated web page and store it onto a File"
				+ " with the same name as the URLs file name. Otherwise utilizing redirection,"
				+ " add the contents to a new or pre-existing file in the FileSystem.";
		// TODO Auto-generated method stub
		return doc;
	}
	
	/**
	 * Extracts a string representation of a URL from input. 
	 * @param input the complete user command input when calling get command
	 * @return a string representation of a URL
	 */
	private static String cleanInput(String input) {
		String cleanedInput = input.split(" ")[1];
		return cleanedInput;
	}
	
	/**
	 * Tries to extract all contents of website with URL url and adds each line as a UserOutput 
	 * into the Output list, returns true if the attempt has been a success and false otherwise.
	 * @param url A url pointing to a website (can be real or fake)
	 * @return True if the url given is valid
	 */
	private static boolean getURLContents(String url) {
		String line;
		try {
			URL webAddress = new URL(url);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(webAddress.openStream()));
			while ((line = in.readLine()) != null) {
				Output.getOutputInstance().addUserOutput(line);
			}
			in.close();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
