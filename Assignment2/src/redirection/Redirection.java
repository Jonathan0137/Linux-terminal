package redirection;

import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import output.Output;
import output.UserOutput;

/**
 * The Redirection class allows users to redirect a commands outputs onto files
 * by appending or overwriting as well as create files in the case that the
 * requested file does not yet exist.
 * 
 * @author Tom Daudelin
 *
 */
public final class Redirection {

	/**
	 * A variable that holds the only instance of FileSystem
	 */
	private static FileSystem fs = FileSystem.getFileSystem();

	/**
	 * A variable that holds the only instance of to be printed JShell outputs
	 */
	private static Output outputList = Output.getOutputInstance();

	/**
	 * Verifies that a users input requests a redirection, returns true if the
	 * command call is a valid candidate to be possibly redirected.
	 * 
	 * @param input The entire user command input
	 * @return True if the command respects redirection call structure
	 */
	private static boolean checkRedirection(String input) {
		int numOfOutputs = 0;
		for (int i = 0; i < Output.getOutputInstance().getOutputList().size(); i++) {
			if (Output.getOutputInstance().getOutputList().get(i) instanceof UserOutput) {
				numOfOutputs++;
			}
		}
		if (numOfOutputs == 0) {
			return false;
		}
		int situation = 0;
		String[] splitInput = input.split(" ");
		for (int i = 0; i < splitInput.length; i++) {
			if (splitInput[i].contentEquals(">") || splitInput[i].contentEquals(">>")) {
				situation = 1;
				break;
			}
		}
		if (situation == 1) {
			String potentialCall = Redirection.getRedirectCall(input);
			if (potentialCall.split(" ")[0].contentEquals(">") || potentialCall.split(" ")[0]
					.contentEquals(">>")) {
				return true;
			}
			outputList.resetOutput();
			outputList.addErrorOutput("Redirection failed; wrong order of parameters");
		}
		return false;
	}

	/**
	 * redirectionSetUp is in charge of extracting all the required data in order to
	 * redirect outputs contained in static variable outputList into a requested
	 * directory and file. And calls for the redirection of all command outputs
	 * within the output list.
	 * 
	 * @param userInput The entire user command input
	 */
	public static void redirectionSetUp(String userInput) {
		if (Redirection.checkRedirection(userInput)) {
			String potentialCall = Redirection.getRedirectCall(userInput);
			String fullPath = "";
			String fileName = "";
			if (potentialCall.contains("/") && potentialCall.split("/").length > 1) {
				String path = potentialCall.split(" ")[1];
				fileName = path.split("/")[path.split("/").length - 1];
				fullPath = Redirection.findFullPath(path);
			} else {
				fileName = potentialCall.split(" ")[1];
				fullPath = Redirection.fs.getCurrentDirectory().getFullPathName();
			}
			Redirection.performRedirection(potentialCall.split(" ")[0], fileName, fullPath);
		}
	}

	/**
	 * Extracts the redirection call within a users command input.
	 * 
	 * @param userInput The entire user input
	 * @return The section of userInput that represents a redirection call
	 */
	private static String getRedirectCall(String userInput) {
		String[] splitInput = userInput.split(" ");
		String call = splitInput[splitInput.length - 2]
				.concat(" " + splitInput[splitInput.length - 1]);
		return call;
	}

	/**
	 * Performs the actual redirection of all command outputs to the requested
	 * directory and file or deletes all command outputs if requested path is
	 * invalid.
	 * 
	 * @param situation Overwriting or appending case
	 * @param fileName  The requested file name from user input
	 * @param fullPath  The requested full path of redirection (not including
	 *                  fileName)
	 */
	private static void performRedirection(String situation, String fileName, String fullPath) {
		File target = null;
		if (FileSystemManipulation.findFileSystemNode(fullPath) instanceof Directory) {
			Directory parent = (Directory) FileSystemManipulation.findFileSystemNode(fullPath);
			String text = Redirection.extractOutputsFromList();
			if (FileSystemManipulation
					.findFileSystemNode(fullPath + "/" + fileName) instanceof File) {
				target = (File) FileSystemManipulation
						.findFileSystemNode(fullPath + "/" + fileName);
				if (situation.contentEquals(">")) {
					target.setContents(text);
				} else {
					target.setContents(target.getContents().concat("\n" + text));
				}
			}
			if (target == null) {
				Redirection.createAndAddFile(fullPath, fileName, parent, text);
			}
		} else {
			outputList.resetOutput();
			outputList.addErrorOutput("Given directory does not exist for redirection");
		}
	}

	/**
	 * Creates a new file with name fileName with parent as its parent directory
	 * with at respective fullPath containing the contents of all the command
	 * outputs.
	 * 
	 * @param fullPath The requested full path of redirection (not including
	 *                 fileName)
	 * @param fileName The requested file name from user input
	 * @param parent   The parent directory of the file
	 * @param text     The String of all command outputs concatenated together
	 *                 separated by new lines
	 */
	private static void createAndAddFile(String fullPath, String fileName, Directory parent, 
			String text) {
		if (Redirection.fileNameCheck(fileName, parent)) {
			File toAdd = new File(fileName, text);
			toAdd.setParentDirectory(parent);
			FileSystemManipulation.addFileSystemNode(parent, toAdd);
		} else {
			outputList.resetOutput();
			outputList.addErrorOutput("Invalid file name for redirection.");
		}
	}

	/**
	 * Verifies that a file to be created has a valid name.
	 * 
	 * @param fileName The name of the file to be added
	 * @param target   The parent directory of the file to be added
	 * @return True id the files name is valid and can be successfully added into
	 *         target directory
	 */
	private static boolean fileNameCheck(String fileName, Directory target) {
		if (FileSystemManipulation.findSubNode(target, fileName) != null) {
			return false;
		}
		String badChars = "/.@!#$%^&*() {}|<>?~";
		for (int i = 0; i < badChars.length(); i++) {
			if (fileName.contains(Character.toString(badChars.charAt(i)))) {
				return false;
			}
		}
		if (fileName.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * Converts any given path into an absolute path.
	 * 
	 * @param path A path (relative or absolute)
	 * @return The absolute path version of path passed in
	 */
	private static String findFullPath(String path) {
		String fullPath = "";
		if (path.charAt(0) == '/') {
			fullPath = fullPath.concat("/");
		}
		String[] outfileFullPath = path.split("/");
		for (int i = 0; i < outfileFullPath.length - 1; i++) {
			if (!outfileFullPath[i].equals("")) {
				fullPath = fullPath.concat(outfileFullPath[i]);
				fullPath = fullPath.concat("/");
			}
		}
		if (fullPath.length() > 0) {
			if (fullPath.charAt(0) == '/') {
				fullPath = FileSystemManipulation.getAbsolutePath(fullPath, fs.getRootDirectory());
			}
			if (fullPath.charAt(0) != '/') {
				fullPath = 
						FileSystemManipulation.getAbsolutePath(fullPath, fs.getCurrentDirectory());
			}
		}
		return fullPath;
	}

	/**
	 * Extracts all command outputs contained in Output classes output list and
	 * appends them all together separated by new lines into a single string.
	 * 
	 * @return A string rendition of all strings to be printed onto console
	 *         separated by new lines
	 */
	private static String extractOutputsFromList() {
		String text = "";
		int numOfOutputs = 0;
		for (int i = 0; i < outputList.getOutputList().size(); i++) {
			if (outputList.getOutputList().get(i) instanceof UserOutput) {
				numOfOutputs++;
			}
		}
		for (int i = 0; i < outputList.getOutputList().size(); i++) {
			if (outputList.getOutputList().get(i) instanceof UserOutput) {
				String toAdd = (String) outputList.getOutputList().get(i).getOutput();
				text = text.concat(toAdd);
				if (numOfOutputs != 1) {
					text = text.concat("\n");
				}
				outputList.getOutputList().remove(i);
				numOfOutputs--;
			}
		}
		return text;
	}
}
