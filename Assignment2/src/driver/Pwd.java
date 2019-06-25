package driver;


public class Pwd extends Command{
	
	@Override
	public void execute(JShell shell, String path)
	{
		Directory currentDirectory = shell.getCurrentDirectory();
		String absPath = getAbsolutePath(currentDirectory.getFullPathName(), currentDirectory);
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
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}
}
