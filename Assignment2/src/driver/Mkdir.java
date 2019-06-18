
public class Mkdir extends Command{
	currentDirectory = JShell.getCurrentDirectory();
	
	public Mkdir(String newDirectories) 
	{
		//split newDirectory into array of individual names of each new directory, and get length of the array
		String[] directoryNames = newDirectories.split(" ");
		int numArguements = arguements.length;
		
		for (int i = 0; i < numArguements; i++) 
		{
			// For each argument:
			// 1. Convert to absolute path (if necessary) and move to parent directory (use Cd method)
			// 2. Use FileSystem.getDirectory(abs_path) to go to the parent directory
			// 3. Try to add the directory to the directory
			
			//add each directory name into the list of the subdirectories of currentDirectories
			currentDirectory.listOfSubdirectories.add(arguements[i]);	
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
	
	
}
