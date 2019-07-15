package redirect;
import java.util.ArrayList;
import java.util.Hashtable;

import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;
import command.Command;

public class Redirect {
	
	public static boolean checkRedirection(String input) {
		int situation = 0;
		String[] splitInput = input.split(" ");
		for (int i=0; i<splitInput.length; i++) {
			if (splitInput[i].contentEquals(">") || 
					splitInput[i].contentEquals(">>")) {
				situation = 1;
				break;
			}
		}
		if (situation == 1) {
			String potentialCall = Redirect.getRedirectCall(input);
			if (potentialCall.split(" ")[0].contentEquals(">") ||
					potentialCall.split(" ")[0].contentEquals(">>")) {
				return true;
			}
			//RAISE ERROR AND APPEND ERROR MESSAGE TO OUTPUT CLASS
			//throw Exception; //UNFINISHED DONT KNOW HOW TO FULLY CALL
		}
		return false;
	}
	
	public static void redirection(FileSystem fileSystem, 
			String userInput, String text) {
		if (Redirect.checkRedirection(userInput)) {
			String potentialCall = Redirect.getRedirectCall(userInput);
			String fullPath = "";
			String fileName = "";
			if (potentialCall.contains("/")) {
				//USE FIND FULL PATH METHOD FROM ECHOTOFILE
			}
			else {
				fileName = potentialCall.split(" ")[1];
				fullPath = fileSystem.getCurrentDirectory().getFullPathName();
			}
			Redirect.performRedirection(fileSystem, 
					potentialCall.split(" ")[0], fileName, fullPath, text);
		}
		else {
			//PUT TEXT INTO OUTPUT CLASS
		}
	}
		
	private static String getRedirectCall(String userInput) {
		String[] splitInput = userInput.split(" ");
		String call = splitInput[splitInput.length-1]
				.concat(" "+splitInput[splitInput.length-2]);
		return call;
	}
	
	private static File findFileByName(FileSystem fileSystem, 
			String fullPath, String fileName) {
		//FIND A SPECIFIC DIRECTORY GIVEN A PATH
		Directory location = Command.findDirectory(fileSystem, fullPath);
		ArrayList<File> fileList = location.getListOfFiles();
		for (int i=0; i<fileList.size();i++) {
			if (fileList.get(i).getName().equals(fileName)) {
				return fileList.get(i);
			}
		}
		return null;
	}
	
	private static void performRedirection(FileSystem fileSystem, 
			String situation, String fileName, String fullPath, String text) {
		File target = Redirect.findFileByName(fileSystem, fullPath, fileName);
		if (target == null) {
			Redirect.createAndAddFile(fileSystem, fullPath, fileName, text);
		}
		else {
			if (situation.contentEquals(">")) {
				target.setContents(text);
			}
			else {
				target.setContents(target.getContents().concat("\n" + text));
			}
		}
	}
	
	private static void createAndAddFile(FileSystem fileSystem,
			String fullPath, String fileName, String text) {
		if (Redirect.fileNameCheck(fileName)) {
			File toAdd = new File(fileName, text);
			Directory location = Command.findDirectory(fileSystem, fullPath);
			toAdd.setParentDirectory(location); //ASK IF THAT IS THE CORRECT PARENT DIRECTORY
			location.getListOfFiles().add(toAdd);
		}
		else {
			//ADD ERROR MESSAGE TO OUTPUT THAT SAYS FILE NAME IS INVALID
		}
	}
	
	//ADD CHECK TO MAKE SURE NO SUBDIRECTORY = FILE NAME
	private static boolean fileNameCheck(String fileName) {
		String badChars = "/.@!#$%^&*() {}|<>?~";
		for (int i=0; i<badChars.length();i++) {
			if (fileName.contains(Character.toString(badChars.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
}
