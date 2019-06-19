
public class Pwd extends Command{
	currentDirectory = JShell.getCurrentDirectory();
	
	public execute()
	{
		String absPath = getAbsolutePath(currentDirectory.fullPathName, currentDirectory);
		System.out.println(absPath);
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
