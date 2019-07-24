package command;

import java.util.ArrayList;
import java.util.HashMap;

import fileSystem.Directory;
import fileSystem.*;

public class Cp extends Command{

	/**
	  * Copies an item
	  * 
	  * @param param	ArrayList containing all parameters required by cp
	  */
	@Override
	public void execute(ArrayList<Object> param) {
		String input = (String) param.get(0);
		String[] splitInput = input.split(" ");
		String oldPath = splitInput[1];
		String newPath = splitInput[2];
		copyItem(oldPath, newPath);	
	}
	
	/**
	 * Copies the item from the provided old path to the given new path
	 * 
	 * @param oldPath	the path of the item being copied
	 * @param newPath	the path where the item is copied to
	 */
	public void copyItem(String oldPath, String newPath) {
		Directory workingDir = FileSystem.getFileSystem().getCurrentDirectory();
		//get absolute paths of the old and new path
		String absOldPath = FileSystemManipulation.getAbsolutePath(oldPath, workingDir);
		String absNewPath = FileSystemManipulation.getAbsolutePath(newPath, workingDir);
		//find the item to be copied in the filesystem
		FileSystemNode item = FileSystemManipulation.findFileSystemNode(absOldPath);
		//find name of item
		String name = item.getName();
		//find the path of the new parent directory
		Directory newParent = (Directory) FileSystemManipulation.findFileSystemNode(absNewPath);
		
		if(item instanceof File) {
			File copiedFile = new File(name);
			FileSystemManipulation.addFileSystemNode(newParent, copiedFile);
			copiedFile.setContents(((File) item).getContents());
		}
		else {
			Directory copiedDir = new Directory(name);
			FileSystemManipulation.addFileSystemNode(newParent, copiedDir);
		}
	}

	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'cp' command.
	  * 
	  * @return the documentation of the 'cp' command
	  */
	@Override
	protected String getDoc() {
		String documentation = "cp: cp OLDPATH NEWPATH\n"
	   			 + "\tCopy item OLDPATH to NEWPATH. Both OLDPATH\n"
	   			 + "\tand NEWPATH may be relative to the current\n "
	   			 + "\tdirectory or may be full paths. If NEWPATH is a\n"
	   			 + "\tdirectory, copy the item into the directory.\n"
	   			 + "\tDoes not remove item OLDPATH";
		return documentation; 
	}

}
