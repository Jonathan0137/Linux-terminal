package command;

import java.util.ArrayList;

import fileSystem.*;


/**
 * Mv allows any user to move an item(file or directory) from the old path to
 * a new path that is given by the user
 * 
 * @author Adil Shah
 *
 */
public class Mv extends Command{
	Directory workingDir = FileSystem.getFileSystem().getCurrentDirectory();
	/**
	  * Moves an item
	  * 
	  * @param param	ArrayList containing all parameters required by mv
	  */
	@Override
	public void execute(ArrayList<Object> param) {
		String input = (String) param.get(0);
		String[] splitInput = input.split(" ");
		for (int i = 0; i < splitInput.length; i++) 
		{
			ArrayList<String> itemName = new ArrayList<String>();
			if (splitInput[i] != "") {
				itemName.add(splitInput[i]);
			}
			String oldPath = itemName.get(0);
			String newPath = itemName.get(1);
			moveItem(oldPath, newPath);
		}
	}
	
	/**
	 * Moves an item from the provided old path to the given new path
	 * 
	 * @param oldPath	the path of the item to be moved
	 * @param newPath	the path where the item is moved to
	 */
	public void moveItem(String oldPath, String newPath) {
		//get absolute paths of the old and new path
		String absOldPath = FileSystemManipulation.getAbsolutePath(oldPath, workingDir);
		String absNewPath = FileSystemManipulation.getAbsolutePath(newPath, workingDir);
		//find the item to be moved in the filesystem
		FileSystemNode item = FileSystemManipulation.findFileSystemNode(absOldPath);
		//find the path of the new parent directory
		String[] path = absNewPath.split("/");
		String pathParentDir = "";
		for (int i = 0; i < path.length - 1; i++) {
			pathParentDir = pathParentDir + path[i]; 
		}
		//find the new parent Directory in the filesystem
		Directory parentDir = (Directory) FileSystemManipulation.findFileSystemNode(pathParentDir);
		//set the parent of the item as the new parent directory
		item.setParentDirectory(parentDir);
	}
	
	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'mv' command.
	  * 
	  * @return the documentation of the 'mv' command
	  */
	@Override
	protected String getDoc() {
		String documentation = "mv: mv OLDPATH NEWPATH\n"
   			 + "\tMove item OLDPATH to NEWPATH. Both OLDPATH\n"
   			 + "\tand NEWPATH may be relative to the current\n "
   			 + "\tdirectory or may be full paths. If NEWPATH is a\n"
   			 + "\tdirectory, move the item into the directory ";
		return documentation; 
	}

}
