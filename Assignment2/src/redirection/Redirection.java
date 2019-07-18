package redirection;
import java.util.ArrayList;
import java.util.Hashtable;

import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import output.AbstractOutput;
import output.Output;
import output.UserOutput;
import command.Cd;
import command.Command;
import driver.JShell;

public final class Redirection {
	
	private static FileSystem fs = FileSystem.getFileSystem();
	
	private static Output outputList = Output.getOutputInstance();
	
	private Redirection() {
		
	}
	
	//NOTE IF REDIRECTION FAILS YOU MUST CLEAR ALL OUTPUTS IN OUTPUT!
	
	private static boolean checkRedirection(String input) {
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
			String potentialCall = Redirection.getRedirectCall(input);
			if (potentialCall.split(" ")[0].contentEquals(">") ||
					potentialCall.split(" ")[0].contentEquals(">>")) {
				return true;
			}
			outputList.addErrorOutput("Redirection failed; wrong order of parameters");
			//throw Exception; //UNFINISHED DONT KNOW HOW TO FULLY CALL
		}
		return false;
	}
	
	public static void redirection(String userInput) {
		if (Redirection.checkRedirection(userInput)) {
			String potentialCall = Redirection.getRedirectCall(userInput);
			String fullPath = "";
			String fileName = "";
			if (potentialCall.contains("/")) {
				String path = potentialCall.split(" ")[1];
				fileName = path.split("/")[path.split("/").length-1];
				fullPath = Redirection.findFullPath(path);
			}
			else {
				fileName = potentialCall.split(" ")[1];
				fullPath = Redirection.fs.getCurrentDirectory().getFullPathName();
			}
			Redirection.performRedirection(potentialCall.split(" ")[0], fileName, fullPath);
		}
	}
		
	private static String getRedirectCall(String userInput) {
		String[] splitInput = userInput.split(" ");
		String call = splitInput[splitInput.length-1]
				.concat(" "+splitInput[splitInput.length-2]);
		return call;
	}
	
	
	private static void performRedirection(String situation, String fileName, String fullPath) {
		File target = null;
		if (FileSystemManipulation.findFileSystemNode(fullPath) instanceof 
				Directory) {
			Directory parent = (Directory) FileSystemManipulation.findFileSystemNode(fullPath);
			if (FileSystemManipulation.findFileSystemNode(fullPath + "/" +
				fileName) instanceof File) {
				target = (File) FileSystemManipulation.findFileSystemNode(fullPath + "/" +
				fileName);
				String text = "";
				for (int i = 0; i<outputList.getOutputList().size(); i++) {
					if (outputList.getOutputList().get(i) instanceof UserOutput) {
						String toAdd = (String) outputList.getOutputList().get(i).getOutput();
						text = text.concat("\n" + toAdd);
					}
				}
				if (situation.contentEquals(">")) {
					target.setContents(text);
				}
				else {
					target.setContents(target.getContents().concat("\n" + text));
				}
			}
			if (target == null) {
				Redirection.createAndAddFile(fullPath, fileName, parent);
			}
		}
		//ERROR: DIRECTORY PATH DNE:
		//RESET ALL OUTPUTS
		//ADD THE ERROR STATEMENT TO OUTPUT
	}
	
	private static void createAndAddFile(String fullPath, String fileName, Directory parent) {
		if (Redirection.fileNameCheck(fileName, parent)) {
			String text = "";
			for () {
				text = text.concat
			}
			File toAdd = new File(fileName, text);
			Directory location = Command.findDirectory(fileSystem, fullPath);
			toAdd.setParentDirectory(location); //ASK IF THAT IS THE CORRECT PARENT DIRECTORY
			location.getListOfFiles().add(toAdd);
		}
		else {
			Ouput.addErrorOutput("Invalid file name for redirection.");
		}
	}
	
	private static boolean fileNameCheck(String fileName, Directory target) {
		if (FileSystemManipulation.findSubNode(target, fileName) != null) {
			return false;
		}
		String badChars = "/.@!#$%^&*() {}|<>?~";
		for (int i=0; i<badChars.length();i++) {
			if (fileName.contains(Character.toString(badChars.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	
	private static String findFullPath(String path) {
		String fullPath = "";
		if (path.charAt(0) == '/') {
			fullPath = fullPath.concat("/");
		}
		String[] outfileFullPath = path.split("/"); 
		for (int i=0; i<outfileFullPath.length-1; i++) {
			if (!outfileFullPath[i].equals("")) {
				fullPath = fullPath.concat(outfileFullPath[i]);
				fullPath = fullPath.concat("/");
			}
		}
		//TODO: ADD THE CORRECT METHOD CALL TO RETRIEVE FULL PATH
		if (fullPath.length()>0) {
			if (fullPath.charAt(0) == '/') {
				fullPath = Cd.getAbsolutePath(fullPath, 
						shell.getDirectoryTree().getRootDirectory());
			}
			if (fullPath.charAt(0) != '/') {	
			fullPath = Cd.getAbsolutePath(fullPath, 
					shell.getCurrentDirectory());
			}
		}
		return fullPath;
	}
}
