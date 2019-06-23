package driver;

import java.util.ArrayList;

public class Mkdir extends Command{
	//NOTE: code assumes "mkdir" isn't part of the string
	Directory currentDirectory;
	FileSystem fs;
	public void execute(JShell shell, String newDirectories) 
	{
		currentDirectory = shell.getCurrentDirectory();
		if (!mkdirError(newDirectories)) {
			//split newDirectory into array of individual names of each new directory, and get length of the array
			String[] arguments = newDirectories.split(" ");
			int numArguments = arguments.length;
			
			for (int i = 0; i < numArguments; i++) 
			{
				// For each argument:
				// 1. Convert to absolute path (if necessary) and move to parent directory (use Cd method)
				// 2. Use FileSystem.getDirectory(abs_path) to go to the parent directory
				// 3. Try to add the directory to the directory
				
				//add each directory name into the list of the subdirectories of currentDirectories
				Directory newDirectory = new Directory(arguments[i]);
				String abs_path;
				if (getAbsolutePath(newDirectory.getFullPathName(), newDirectory) == arguments[i])
				{
					abs_path = arguments[i];
				}
				else
				{
					abs_path = getAbsolutePath(newDirectory.getFullPathName(), newDirectory);
				}
				Directory parentDirectory = fs.getDirectory(abs_path);// or should newDirectory.getParentDirectory();?
				addSubdirectory(newDirectory);
				ArrayList<Directory> subdirectoriesList = parentDirectory.getListOfSubdirectories();
				subdirectoriesList.add(newDirectory);	
			}
		}
		else 
		{
			System.out.println("That is not a valid arguement");
		}
	}
	private static boolean mkdirError(String newDirectories) {
		if (newDirectories == "") 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	private static String getAbsolutePath(String input, Directory workingDir) {
		// Helper function for when input is a relative path name;
		// Converts relative path name to absolute path name
		String[] pathList = input.split("/");  
		String fullPathName = workingDir.getFullPathName();
		  
		for (int i=0; i<pathList.length; i++) {
			if (pathList[i].equals(".") || pathList[i].equals("")) {
				continue;
			}
			else if (pathList[i].equals("..")) {
				fullPathName = moveToParentDirectory(fullPathName);
			}
			else {
				fullPathName = fullPathName + pathList[i] + "/";
			}
		}
		  
		return fullPathName;
	}
	
	private static String moveToParentDirectory(String pathName) {
		// Moves the pathName to the path name of the parent directory
				    
		if (pathName.equals("/")) {
			return pathName;
		}
				    
		String newPathName = pathName;
				    
		if (newPathName.charAt(newPathName.length() - 1) == '/') {
			newPathName = newPathName.substring(0, newPathName.length() - 1);
		}
				    
		for (int i = newPathName.length() - 1; i>=0; i--) {
			if (newPathName.charAt(i) == '/') {
					break;
			}      
			newPathName = newPathName.substring(0, i);
		} 
		return newPathName;
	}
	private void addSubdirectory(Directory subDirectory) {
	//Add helper function to scan list for names
		ArrayList<Directory> listOfSubdirectories = currentDirectory.getListOfSubdirectories();
		if (listOfSubdirectories.contains(subDirectory)/*listOfSubdirectories.contains(subDirectory) */) { // Maybe use subDirectory.getName() if that's what is differentiating them, and also check listOfFiles since files and directories cannot have same name
	      // Not sure if Directory class is responsible for printing this error?
	      System.out.println("Error: Directory '" + subDirectory.getName() + "' already exists.");
	      return;
	    }
	    subDirectory.setParentDirectory(currentDirectory);
	    listOfSubdirectories.add(subDirectory);
	}


	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
