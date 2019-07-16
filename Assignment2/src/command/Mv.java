package command;

import java.util.ArrayList;

public class Mv extends Command{
	
	/**
	  * Moves an item from the oldpath to the newpath
	  * 
	  * @param param	ArrayList containing all parameters required by mv
	  */
	@Override
	public void execute(ArrayList<Object> param) {
		String input = (String) param.get(0);
		String[] splitInput = input.split(" ");
		String oldpath = splitInput[0];
		String newpath = splitInput[1];
		
		
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
