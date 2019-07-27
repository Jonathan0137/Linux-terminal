package command;

import java.util.ArrayList;
import java.util.HashMap;

import fileSystem.*;
import output.Output;


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
		String absOldPath = FileSystemManipulation.getAbsolutePath(oldPath,
																workingDir);
		String absNewPath = FileSystemManipulation.getAbsolutePath(newPath,
																workingDir);
		FileSystemNode item = FileSystemManipulation.findFileSystemNode(
																absOldPath);
		String itemName = item.getName(); 
		
		Directory newParent = (Directory) FileSystemManipulation.
											findFileSystemNode(absNewPath);
		HashMap<String, FileSystemNode> newDirNodes = newParent.
												getListOfFileSystemNodes();
		if (newDirNodes.containsKey(itemName)) {
			Output out = Output.getOutputInstance();
			out.addErrorOutput("The node '" + itemName + "' already exists"
													+ " in " + absNewPath);
		}
		else {
			Directory oldDir = item.getParentDirectory();
			HashMap<String, FileSystemNode> oldDirNodes = oldDir.
												getListOfFileSystemNodes();
			oldDirNodes.remove(itemName);
			FileSystemManipulation.addFileSystemNode(newParent, item);
		}
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
