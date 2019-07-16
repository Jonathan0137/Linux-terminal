package command;

import java.util.ArrayList;

import fileSystem.Directory;
import fileSystem.FileSystem;
import redirection.Redirection;

/**
 * Pwd allows any user to display the current working direectory 
 * 
 * @author Adil Shah
 *
 */
public class Pwd extends Command{
	
	
	/**
	  * Prints the absolute path of the current working directory
	  * 
	  * @param shell   an instance of the JShell that interacts with user
	  * @param input	Unused
	  */
	@Override
	public void execute(ArrayList<Object> param)
	{
		String input = (String) param.get(0);
		Directory currentDirectory = FileSystem.getFileSystem().
										getCurrentDirectory();
		String text = currentDirectory.getFullPathName();
		
		Redirection.redirection(FileSystem.getFileSystem(), input, text);
		
		//Add to output
		
	}
	
	
	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'pwd' command.
	  * 
	  * @return the documentation of the 'pwd' command
	  */
	@Override
	protected String getDoc() {
		String documentation = "pwd: pwd\n"
                			 + "\tprint the absolute path of the current "
                			 + "working directory\n";
		return documentation; 
	}

}
