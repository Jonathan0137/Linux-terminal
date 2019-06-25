package driver;

import java.util.ArrayList;

public class Mkdir extends Command{
	//NOTE: code assumes "mkdir" isn't part of the string newDirectories
	Directory currentDirectory;
	
	@Override
	public void execute(JShell shell, String newDirectories) 
	{
		currentDirectory = shell.getCurrentDirectory();
		FileSystem fs = shell.getDirectoryTree();
			//split newDirectory into array of individual names of each new directory, and get length of the array
			String[] arguments = newDirectories.split(" ");
			int numArguments = arguments.length;
			
			for (int i = 0; i < numArguments; i++) 
			{
				// For each argument:
				// 1. Convert to absolute path (if necessary) and move to parent directory (use Cd method)
				// 2. Use FileSystem.getDirectory(abs_path) to go to the parent directory
				// 3. Try to add the directory to the parent directory
				
				//add each directory name into the list of the subdirectories of currentDirectories
				String abs_path;
				Directory newDirectory;
				if (arguments[i].indexOf("/") > 0) 
				{
					abs_path = arguments[i];
					String path[] = arguments[i].split("/");
					newDirectory = new Directory(path[path.length - 1]);
				}
				else 
				{
					newDirectory = new Directory(arguments[i]);
					addSubdirectory(currentDirectory, newDirectory);
					currentDirectory.getListOfSubdirectories().add(newDirectory);
				}
				
				/*if (getAbsolutePath(newDirectory.getFullPathName(), newDirectory) == arguments[i])
				{
					abs_path = arguments[i];
				}
				else
				{
					abs_path = getAbsolutePath(newDirectory.getFullPathName(), newDirectory);
				}
				Directory parentDirectory = fs.getDirectory(abs_path);
				addSubdirectory(newDirectory);
				ArrayList<Directory> subdirectoriesList = parentDirectory.getListOfSubdirectories();
				subdirectoriesList.add(newDirectory);	*/
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
	public void addSubdirectory(Directory parentDirectory, Directory subDirectory) {
		ArrayList<Directory> listOfSubdirectories = parentDirectory.getListOfSubdirectories();
		if (containsName(listOfSubdirectories, subDirectory)) {
			System.out.println("The name '" + subDirectory.getName() + "' already exists in this directory.");
			return;
		}
		subDirectory.setParentDirectory(parentDirectory);
		listOfSubdirectories.add(subDirectory);
	}
	 
	private static boolean containsName(ArrayList<Directory> listOfDirectories, Directory subDirectory) {   
		String subDirName = subDirectory.getName();
		for (int i=0; i<listOfDirectories.size(); i++) {
			if (listOfDirectories.get(i).getName().equals(subDirName)) {
				return false;
			}
		}
		return true;
	}


	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
