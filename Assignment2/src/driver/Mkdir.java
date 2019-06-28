package driver;

import java.util.ArrayList;

public class Mkdir extends Command{
	//NOTE: code assumes "mkdir" is part of the string newDirectories
	
	/**
	  * Creates a new directory in either the current directory if a path is not given,
	  * or creates the directory in the path if it is given
	  * 
	  * @param shell   an instance of the JShell that is interacting with the user
	  * @param newDirectories   a list of absolute path names or directory names
	  */
	@Override
	public void execute(JShell shell, String newDirectories) 
	{
		Directory currentDirectory = shell.getCurrentDirectory();
		FileSystem fs = shell.getDirectoryTree();
		//split newDirectory into array of individual names of each new directory, and get length of the array
		String[] arguments = newDirectories.split(" ");
		int numArguments = arguments.length;
			
		for (int i = 1; i < numArguments; i++) 
		{
			if (directoryCheck(arguments[i])) 
			{
				Directory newDirectory;
				if (arguments[i].indexOf("/") >= 0) 
				{
					String splitArguments[] = arguments[i].split("/");
					String pathNewDir = splitArguments[splitArguments.length - 1];
					newDirectory = new Directory(pathNewDir);
					String pathParentDir = arguments[i].replace("/" + pathNewDir, "");
						
					Directory parentDirectory = Command.findDirectory(fs, pathParentDir);
					addSubdirectory(parentDirectory, newDirectory);
				}
				else 
				{
					newDirectory = new Directory(arguments[i]);
					addSubdirectory(currentDirectory, newDirectory);
				}
			}
			else 
			{
				System.out.println(arguments[i] + " is not a valid directory name");
			}
		}
	}
	
	/**
	  * Adds the subDirectory into the parent directory
	  * 
	  * @param parentDirectory   the directory the user is adding into
	  * @param subDirectory   the directory that is being added by the user
	  */
	public void addSubdirectory(Directory parentDirectory, Directory subDirectory) {
		ArrayList<Directory> listOfSubdirectories = parentDirectory.getListOfSubdirectories();
		ArrayList<File> listOfFiles = parentDirectory.getListOfFiles();
		if (containsDirectory(listOfSubdirectories, subDirectory)||
		    containsFile(listOfFiles, subDirectory)) {
			System.out.println("The name '" + subDirectory.getName() + "' already exists in this directory.");
			return;
		}
		subDirectory.setParentDirectory(parentDirectory);
		listOfSubdirectories.add(subDirectory);
	}
	 
	
	/**
	  * Checks if the name of the directory the user is attempting to create is already a directory
	  * name in the parent Directory.
	  * 
	  * @param listOfDirectories   the list of subdirectories that already exist in the parent
	  * @param subDirectory   the directory that the user is attempting to add
	  */
	private static boolean containsDirectory(ArrayList<Directory> listOfDirectories, Directory subDirectory) {   
		String subDirName = subDirectory.getName();
		for (int i=0; i<listOfDirectories.size(); i++) {
			if (listOfDirectories.get(i).getName().equals(subDirName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
     * Checks if the name of the  directory the user is attempting to create is 
     * already a file name in the parent Directory.
     * 
     * @param listOfFiles   the list of files that already exist in the parent
     * @param subDirectory   the directory that the user is attempting to add
     */
   private static boolean containsFile(ArrayList<File> listOfFiles, Directory subDirectory) {   
       String subDirName = subDirectory.getName();
       for (int i=0; i<listOfFiles.size(); i++) {
           if (listOfFiles.get(i).getName().equals(subDirName)) {
               return true;
           }
       }
       return false;
   }
	
	/**
	 * Returns true if the directory a user is attempting to create has a valid name
	 * and returns false if it contains invalid characters
	 * 
	 * @param directoryName		The name of the directory the user is attempting to create
	 * @return 		boolean that is true if directory name is valid
	 */
	public static boolean directoryCheck(String directoryName) {
		if (directoryName.contains("/")) {
			return false;
		}
		if (directoryName.contains(".")) {
			return false;
		}
		if (directoryName.contains("@")) {
			return false;
		}
		if (directoryName.contains("!")) {
			return false;
		}
		if (directoryName.contains("#")) {
			return false;
		}
		if (directoryName.contains("$")) {
			return false;
		}
		if (directoryName.contains("%")) {
			return false;
		}
		if (directoryName.contains("^")) {
			return false;
		}
		if (directoryName.contains("&")) {
			return false;
		}
		if (directoryName.contains("*")) {
			return false;
		}
		if (directoryName.contains("(")) {
			return false;
		}
		if (directoryName.contains(")")) {
			return false;
		}
		if (directoryName.contains("{")) {
			return false;
		}
		if (directoryName.contains("}")) {
			return false;
		}
		if (directoryName.contains("~")) {
			return false;
		}
		if (directoryName.contains("|")) {
			return false;
		}
		if (directoryName.contains("<")) {
			return false;
		}
		if (directoryName.contains(">")) {
			return false;
		}
		if (directoryName.contains("?")) {
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
		String documentation = "mkdir: mkdir DIR...\n"
   			 				 + "\tCreate new directories\n"
   			 				 + "\tDIR must be a valid absolute path name or the name of the new directory.\n\n"
   			 				 + "\tIf DIR begins with a slash (/), then it is interpreted\n"
   			 				 + "\tas an absolute path, starting from the root directory.\n"
   			 				 + "\tOtherwise, it is interpreted as a relative path to the\n"
   			 				 + "\tcurrent directory.\n\n";
		return documentation; 
	}

	
	
}
