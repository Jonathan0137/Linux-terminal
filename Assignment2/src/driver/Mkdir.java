package driver;

import java.nio.file.FileSystem;
import java.util.ArrayList;

public class Mkdir extends Command{
	//currentDirectory = JShell.getCurrentDirectory();
	//NOTE: code assumes "mkdir" isn't part of the string
	public void execute(String newDirectories) 
	{
		//split newDirectory into array of individual names of each new directory, and get length of the array
		String[] arguements = newDirectories.split(" ");
		int numArguements = arguements.length;
		
		for (int i = 0; i < numArguements; i++) 
		{
			// For each argument:
			// 1. Convert to absolute path (if necessary) and move to parent directory (use Cd method)
			// 2. Use FileSystem.getDirectory(abs_path) to go to the parent directory
			// 3. Try to add the directory to the directory
			
			//add each directory name into the list of the subdirectories of currentDirectories
			Directory newDirectory = new Directory(arguements[i]);
			String abs_path;
			if (getAbsolutePath(newDirectory.getFullPathName(), newDirectory) == arguements[i])
			{
				abs_path = arguements[i];
			}
			else
			{
				abs_path = getAbsolutePath(newDirectory.getFullPathName(), newDirectory);
			}
			Directory parentDirectory = FileSystem.getDirectory(abs_path);// or should newDirectory.getParentDirectory();?
			parentDirectory.addSubdirectory(newDirectory);
			ArrayList<Directory> subdirectoriesList = parentDirectory.getListOfSubdirectories();
			subdirectoriesList.add(newDirectory);	
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

	@Override
	public void execute(JShell shell, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
