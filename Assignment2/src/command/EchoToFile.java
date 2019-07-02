package command;

import java.util.ArrayList;
import driver.JShell;
import fileSystem.Directory;
import fileSystem.File;

public class EchoToFile extends Command {
	
	/**
	 * The constructor
	 */
	public EchoToFile() {
		doc = "Allows user to print onto shell, overwrite, add onto and create"
				+ " new text files using an inputed string";
	}
	
	/**
	 * Creates or modifies text files that will contain the user input string
	 */
	@Override
	public void execute(JShell shell, String path) {
		int inputCase = EchoToFile.echoToFileCheck(shell, path); 
		if (inputCase != -1) {
			String[] extractString = path.split("\"");
			String[] optionalInput = extractString[2].split(" ");
			String[] outfileFullPath = optionalInput[2].split("/");
			String fullPath = findFullPath(shell, optionalInput, 
					outfileFullPath);
			if (inputCase == 1 || inputCase == 3) {
				EchoToFile.overwriteFile(shell, fullPath, optionalInput, 
						outfileFullPath, extractString, inputCase); 
			}
			else if (inputCase == 2 || inputCase == 4) {
				EchoToFile.createNewFile(shell, fullPath, optionalInput, 
						outfileFullPath, extractString, inputCase);
			}
			else if (inputCase == 5 || inputCase == 6) {
				EchoToFile.concatFile(shell, fullPath, optionalInput, 
						outfileFullPath, extractString, inputCase);
			}
		}
	}

	/**
	 * Returns the Echo command documentation
	 * @return this.doc The documentation for the Echo
	 */
	protected String getDoc() {
		// TODO Auto-generated method stub
		return this.doc;
	}
	
	/**
	 * Verifies that command call is valid, determines which valid case is 
	 * related to the user input and returns an integer representation of that
	 * case
	 * @param shell An instance of the JShell 
	 * @param input A string representation of a user input
	 * @return The input case for which execute must account for
	 */
	private static int echoToFileCheck(JShell shell, String input) {
		if (input.split("\"").length != 3) {
			System.out.println("echo: incorrect number of input strings");
			return -1;
		}
		String[] extractString = input.split("\"");
		String[] echoInput = extractString[0].split(" ");
		String[] optionalInput = extractString[2].split(" ");
		if (echoInput.length != 1) {
			System.out.println("bash: echo: wrong order of arguments");
			return -1;
		}
		if (optionalInput[1].equals(">")) { 
			return EchoToFile.checkOverwriteCase(shell, optionalInput); 
		}
		if (optionalInput[1].equals(">>")) {
			return EchoToFile.checkAppendingCase(shell, optionalInput);
		}
		System.out.println("bash: echo: wrong order of arguments");
		return -1;
	}

	/**
	 * Adds a new file into a specified directory
	 * @param target The target directory in which we want to add a new file
	 * @param newFile The new file that will be added into the target directory
	 */
	private static void addFile(Directory target, File newFile) {
		if (EchoToFile.fileCheck(newFile.getName(), target)) {  
			target.getListOfFiles().add(newFile);
			newFile.setParentDirectory(target);
		}
		else {
			System.out.println("echo: invalid file name");	
		}
	}
	
	/**
	 * Finds a file by name in a specific directory
	 * @param location The target directory
	 * @param fileName The name of the sought out file
	 * @return The file with same name as fileName
	 */
	private static File findFileByName(Directory location, String fileName) {
		ArrayList<File> fileList = location.getListOfFiles();
		for (int i=0; i<fileList.size();i++) {
			if (fileList.get(i).getName().equals(fileName)) {
				return fileList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Returns true if the file a user is attempting to create has a valid name
	 * and returns false if the file a user is attempting to create contains
	 * invalid characters or is an invalid name
	 * @param fileName A file name a user is attempting to create
	 * @return True if file passes all conditions to be created
	 */
	private static boolean fileCheck(String fileName, Directory target) {
		ArrayList<Directory> subDirectories = target.getListOfSubdirectories();
		for (int i=0; i<subDirectories.size(); i++) {
			if (subDirectories.get(i).getName().equals(fileName)) {
				return false;
			}
		}
		String badChars = "/.@!#$%^&*() {}|<>?~";
		for (int i=0; i<badChars.length();i++) {
			if (fileName.contains(Character.toString(badChars.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Dissects the users input in echo command in order to extract and return
	 * the full requested path 
	 * @param shell The instance of the JShell
	 * @param optionalInput the portion of user input that are not mandatory
	 * @param outfileFullPath the portion of user input that refers to a path
	 * @return The string version of the full requested path
	 */
	private static String findFullPath(JShell shell, String[] optionalInput, 
			String[] outfileFullPath) {
		String fullPath = "";
		if (optionalInput[2].charAt(0) == '/') {
			fullPath = fullPath.concat("/");
		}
		for (int i=0; i<outfileFullPath.length-1; i++) {
			if (!outfileFullPath[i].equals("")) {
				fullPath = fullPath.concat(outfileFullPath[i]);
				fullPath = fullPath.concat("/");
			}
		}
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
	/**
	 * Returns the integer representation of the echo call case containing 
	 * '>' indicating overwriting
	 * @param shell an instance of the JShell
	 * @param optionalInput The section from user input that is not mandatory
	 * @return The case of call for echo in the overwriting case
	 */
	private static int checkOverwriteCase(JShell shell, 
			String[] optionalInput) {
		if (optionalInput[2].split("/").length > 2 || 
				optionalInput[2].startsWith("/")) {
			String[] outfileFullPath = optionalInput[2].split("/");
			String path = findFullPath(shell, optionalInput, 
					outfileFullPath);
			if (Command.findDirectory(shell.getDirectoryTree(), path)
					!= null) {
				if (EchoToFile.findFileByName(
				    Command.findDirectory(shell.getDirectoryTree(), path), 
						outfileFullPath[outfileFullPath.length-1]) != null) {
					return 1;
				}
				return 2; //i.e file dne
			}
			System.out.println("echo: input path does not exist");
			return -1;
		}
		else if (EchoToFile.findFileByName(shell.getCurrentDirectory(), 
				optionalInput[2]) != null) {
			return 3; //i.e file exists
		}
		return 4; //i.e file dne
	}
	
	/**
	 * Returns the integer representation of the echo call case containing 
	 * '>>' indicating appending
	 * @param shell an instance of the JShell
	 * @param optionalInput The section from user input that is not mandatory
	 * @return The case of call for echo in the appending case
	 */
	private static int checkAppendingCase(JShell shell, 
			String[] optionalInput) {
		if (optionalInput[2].split("/").length > 2 || 
				optionalInput[2].startsWith("/")) {
			String[] outfileFullPath = optionalInput[2].split("/");
			String path = findFullPath(shell, optionalInput, 
					outfileFullPath);
			if (Command.findDirectory(shell.getDirectoryTree(), path)
					!= null) {
				if (EchoToFile.findFileByName(
				    Command.findDirectory(shell.getDirectoryTree(), path), 
						outfileFullPath[outfileFullPath.length-1]) != null) {
					return 5;
				}
				return 2; //i.e file dne
			} 
			System.out.println("echo: input path does not exist");
			return -1;
		}
		else if (EchoToFile.findFileByName(shell.getCurrentDirectory(), 
				optionalInput[2]) != null) {
			return 6; //i.e file exists
		}
		return 4; //i.e file dne
	}
	
	/**
	 * Concatenates a string to the end of any existing file by request of
	 * user
	 * @param shell an instance of JShell
	 * @param fullPath the target directory containing the called file
	 * @param optionalInput the section of user input containing file name
	 * @param outfileFullPath optional input containing called directory
	 * @param extractString the string user wants to add to file
	 * @param inputCase whether there is a path given or not
	 */
	private static void concatFile(JShell shell, String fullPath, String[] 
			optionalInput, String[] outfileFullPath, String[] extractString, 
			int inputCase) {
		if (inputCase == 5) {
			File txtFile = EchoToFile.findFileByName
					(Command.findDirectory(shell.getDirectoryTree(), fullPath), 
							outfileFullPath[outfileFullPath.length-1]);
			txtFile.setContents(txtFile.getContents()
					.concat("\n" + extractString[1])); 
		}
		else if (inputCase == 6) {
			EchoToFile.findFileByName(shell.getCurrentDirectory(), 
					optionalInput[2]).setContents(EchoToFile.
							findFileByName(shell.getCurrentDirectory(), 
					optionalInput[2]).getContents()
							.concat("\n" + extractString[1]));
		}
	}
	
	/**
	 * Create a new file in a requested directory in the case that requested
	 * file does not exist
	 * @param shell an instance of JShell
	 * @param fullPath the target directory containing the called file
	 * @param optionalInput the section of user input containing file name
	 * @param outfileFullPath optional input containing called directory
	 * @param extractString the string user wants to add to file
	 * @param inputCase whether there is a path given or not
	 */
	private static void createNewFile(JShell shell, String fullPath, String[] 
			optionalInput, String[] outfileFullPath, String[] extractString, 
			int inputCase) {
		if (inputCase == 2) {
			Directory destination = Command.findDirectory(
					shell.getDirectoryTree(), fullPath);
			File txtFile = new File(outfileFullPath
					[outfileFullPath.length-1], extractString[1]);
			EchoToFile.addFile(destination, txtFile);
		}
		else if (inputCase == 4) {
			File txtFile = new File(optionalInput[2], extractString[1]);
			EchoToFile.addFile(shell.getCurrentDirectory(), txtFile);
		}
	}
	
	/**
	 * Overwrites files with users input string
	 * @param shell an instance of JShell
	 * @param fullPath the target directory containing the called file
	 * @param optionalInput the section of user input containing file name
	 * @param outfileFullPath optional input containing called directory
	 * @param extractString the string user wants to add to file
	 * @param inputCase whether there is a path given or not
	 */
	private static void overwriteFile(JShell shell, String fullPath, String[] 
			optionalInput, String[] outfileFullPath, String[] extractString, 
			int inputCase) {
		if (inputCase == 1) {
			File txtFile = EchoToFile.findFileByName
					(Command.findDirectory(shell.getDirectoryTree(), fullPath),
							outfileFullPath[outfileFullPath.length-1]);
			txtFile.setContents(extractString[1]);
		}
		else if (inputCase == 3) {
			EchoToFile.findFileByName(shell.getCurrentDirectory(), 
					optionalInput[2]).setContents(extractString[1]);
		}
	}
}