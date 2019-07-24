package command;

import output.Output;
import redirection.Redirection;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

// The code in getURLContents() method is inspired by the code here; 
// https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html

/**
 * Get command extracts all the contents of a website given a URL and adds the
 * contents to a file inside the FileSystem
 * 
 * @author Tom Daudelin
 *
 */
public class Get extends Command {

	/**
	 * Extracts all the contents of a website with URL given by the user and add
	 * them to a File within the current directory or send the to Output list for
	 * future redirection depending on users get call input.
	 * 
	 * @param params The list of required parameters to successfully execute get
	 *               command
	 * 
	 */
	@Override
	public void execute(ArrayList<Object> params) {
		String input = (String) params.get(0);
		String userParam = Get.cleanInput(input);
		boolean success = Get.getURLContents(userParam);
		if (success && input.split(" ").length == 2) {
			String fileName = userParam.split("/")[userParam.split("/").length - 1];
			fileName = Get.cleanFileName(fileName);
			Redirection.redirectionSetUp("> " + fileName);
			Output.getOutputInstance().resetOutput();
		} else if (success) {
			Redirection.redirectionSetUp(input);
			Output.getOutputInstance().resetOutput();
		}
	}

	/**
	 * Returns the pre-written documentation for the get command.
	 * 
	 * @return The string representation of the documentation for the get command
	 */
	@Override
	protected String getDoc() {
		String doc = "get: get URL [(>or>>) OUTFILE]" + "\n\t" + "If URL is valid, extract "
				+ "all contents on the associated web" + "\n\t\t" + "page and store it onto a File"
				+ " with the same name as" + "\n\t\t" + "the URLs file name. Otherwise utilizing" 
				+ " redirection," + "\n\t\t" + "add the contents to a new or pre-existing file in" 
				+ "\n\t\t" + "the FileSystem.";
		return doc;
	}

	/**
	 * Extracts a string representation of a URL from input.
	 * 
	 * @param input the complete user command input when calling get command
	 * @return a string representation of a URL
	 */
	private static String cleanInput(String input) {
		String cleanedInput = input.split(" ")[1];
		return cleanedInput;
	}

	/**
	 * Tries to extract all contents of website with URL url and adds each line as a
	 * UserOutput into the Output list, returns true if the attempt has been a
	 * success and false otherwise.
	 * 
	 * @param url A url pointing to a website (can be real or fake)
	 * @return True if the url given is valid
	 */
	private static boolean getURLContents(String url) {
		String line;
		try {
			URL webAddress = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(webAddress.openStream()));
			while ((line = in.readLine()) != null) {
				Output.getOutputInstance().addUserOutput(line);
			}
			in.close();
			return true;
		} catch (Exception e) {
			Output.getOutputInstance().addErrorOutput("Get: invalid URL");
			return false;
		}
	}

	private static String cleanFileName(String fileName) {
		String realFileName = "";
		String illegalChars = "/.@!#$%^&*() {}|<>?~";
		for (int i = 0; i < fileName.length(); i++) {
			if (illegalChars.contains(String.valueOf(fileName.charAt(i)))) {
				return realFileName;
			}
			realFileName = realFileName.concat(String.valueOf(fileName.charAt(i)));
		}

		return realFileName;
	}
}
