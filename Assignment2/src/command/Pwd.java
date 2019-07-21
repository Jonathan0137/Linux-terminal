package command;

import java.util.ArrayList;

import fileSystem.Directory;
import fileSystem.FileSystem;
import output.Output;

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
	  * @param param	ArrayList containing all parameters required by pwd
	  */
	@Override
	public void execute(ArrayList<Object> param)
	{
		String input = (String) param.get(0);
		Directory currentDirectory = FileSystem.getFileSystem().
										getCurrentDirectory();
		String text = currentDirectory.getFullPathName();
		
		Output out = Output.getOutputInstance();
		out.addUserOutput(text);
		
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
