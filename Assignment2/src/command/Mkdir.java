package command;

import java.util.ArrayList;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import fileSystem.Directory;
import output.Output;

/**
 * Mkdir allows any user to create directories, given either a directory name,
 * which will create a directory with that name in the current directory, or
 * given a path, in which case it will create a directory with the path 
 * 
 * @author Adil Shah
 *
 */
public class Mkdir extends Command{//need to fix errors in mkdir from 2a
	
	/**
	  * Execute mkdir command
	  * 
	  * @param param	ArrayList of all parameters required by mkdir
	  */
	@Override
	public void execute(ArrayList<Object> param) 
	{
		String newDirectories = (String) param.get(0);
		Directory currentDirectory = FileSystem.getFileSystem().getCurrentDirectory();
		FileSystem fs = FileSystem.getFileSystem();
		createDirectory(currentDirectory, fs, newDirectories);
	}
	
	
	/**
	  * Creates a new directory in either the current directory if a path
	  * is not given, or creates the directory in the path if it is given
	  * 
	  * @param currentDirectory	The current working directory
	  * @param fs   The file system that the directory will be created in
	  * @param newDirectories   a user inputed list of absolute path names
	  * 						or directory names
	  */
	public void createDirectory(Directory currentDirectory, FileSystem fs,
													String newDirectories) {
		//split newDirectory, and get length of the array
		String[] arguments = newDirectories.split(" ");
		//loop through array names, make and add directory if valid name
		for (int i = 1; i < arguments.length; i++) {
			if (directoryCheck(arguments[i])){
				Directory newDirectory;
				//check if creating in current directory or given path
				if (arguments[i].indexOf("/") >= 0) {
					String splitArg[] = arguments[i].split("/");
					String pathNewDir = splitArg[splitArg.length - 1];
					newDirectory = new Directory(pathNewDir);
					String pathParentDir = arguments[i].replace("/" + 
														pathNewDir, "");
		
					Directory parentDirectory = (Directory) 
					FileSystemManipulation.findFileSystemNode(pathParentDir);
					FileSystemManipulation.addFileSystemNode(parentDirectory, newDirectory);
				}
				else {
					newDirectory = new Directory(arguments[i]);
					FileSystemManipulation.addFileSystemNode(currentDirectory, newDirectory);
				}
			}
			else {
				String error = arguments[i] + " is not a valid directory name";
				Output errorOutput = Output.getOutputInstance();
				errorOutput.addErrorOutput(error);
			}
		}
	}
	
	
	/**
	 * Returns true if the directory a user is attempting to create has
	 * a valid name and returns false if it contains invalid characters
	 * 
	 * @param directoryName		The name of the directory the user is 
	 * 							attempting to create
	 * @return boolean that is true if directory name is valid
	 */
	public static boolean directoryCheck(String directoryName) {
		if (directoryName.contains("@") || directoryName.contains("!") ||
			directoryName.contains("#") || directoryName.contains("$") ||
			directoryName.contains("%") || directoryName.contains("^") ||
			directoryName.contains("&") || directoryName.contains("*") ||
			directoryName.contains("(") || directoryName.contains(")") ||
			directoryName.contains("{") || directoryName.contains("}") ||
			directoryName.contains("~") || directoryName.contains("|") ||
			directoryName.contains("<") || directoryName.contains(">") ||
			directoryName.contains("?"))
		{
			return false;
		}
		return true;
	}

	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'mkdir' command.
	  * 
	  * @return the documentation of the 'mkdir' command
	  */
	@Override
	protected String getDoc() {
		String doc = "mkdir: mkdir DIR...\n"
   			 	   + "\tCreate new directories\n"
   			 	   + "\tDIR must be a valid absolute path name or the name of"
   			 	   + " the new directory.\n\n\tIf DIR begins with a slash (/)"
   			 	   + ", then it is interpreted\n\tas an absolute path, "
   			 	   + "starting from the root directory.\n\tOtherwise, it is "
   			 	   + "interpreted as a relative path to the\n\tcurrent "
   			 	   + "directory.\n\n";
		return doc; 
	}

	
	
}
