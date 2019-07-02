package command;


public class Pwd extends Command{
	
	
	/**
	  * Prints the absolute path of the current working directory
	  * 
	  * @param shell   an instance of the JShell that is interacting with the user
	  * @param input	Unused
	  */
	@Override
	public void execute(JShell shell, String input)
	{
		Directory currentDirectory = shell.getCurrentDirectory();
		System.out.println(currentDirectory.getFullPathName());
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
                			 + "\tprint the absolute path of the current working directory\n";
		return documentation; 
	}

}
