package command;

import java.util.ArrayList;
import java.util.HashMap;

import fileSystem.*;


/**
 * Mv allows any user to move an item(file or directory) from the old path to
 * a new path that is given by the user
 * 
 * @author Adil Shah
 *
 */
public class Mv extends Command{

	/**
	  * Execute mv command
	  * 
	  * @param param	ArrayList containing all parameters required by mv
	  */
	@Override
	public void execute(ArrayList<Object> param) {
		String input = (String) param.get(0);
		String[] splitInput = input.split(" ");
		String oldPath = splitInput[1];
		String newPath = splitInput[2];
		moveItem(oldPath, newPath);
	}
	
	/**
	 * Moves an item from the provided old path to the given new path
	 * 
	 * @param oldPath	the path of the item to be moved
	 * @param newPath	the path where the item is moved to
	 */
	public void moveItem(String oldPath, String newPath) {
		Directory workingDir = FileSystem.getFileSystem().
													getCurrentDirectory();
		//get absolute paths of the old and new path
		String absOldPath = FileSystemManipulation.getAbsolutePath(oldPath,
																workingDir);
		String absNewPath = FileSystemManipulation.getAbsolutePath(newPath,
																workingDir);
		//find the item to be moved in the filesystem
		FileSystemNode item = FileSystemManipulation.findFileSystemNode(
																absOldPath);
		
		//remove node from old location
		Directory oldDir = item.getParentDirectory();
		String itemName = item.getName(); 
		HashMap<String, FileSystemNode> oldDirNodes = oldDir.
												getListOfFileSystemNodes();
		oldDirNodes.remove(itemName);
		
		//find the path of the new parent directory
		Directory newParent = (Directory) FileSystemManipulation.
											findFileSystemNode(absNewPath);
		
		//add the node into the parent directory
		FileSystemManipulation.addFileSystemNode(newParent, item);
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
   			 + "\tdirectory, move the item into the directory";
		return documentation; 
	}

}
