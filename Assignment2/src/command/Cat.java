package command;

import java.util.ArrayList;
import driver.JShell;
import fileSystem.Directory;
import fileSystem.File;

public class Cat extends Command {
	
	/**
	  * Prints out the contents of any files the user inputs
	  * 
	  * @param shell   an instance of the JShell that is interacting with the user
	  * @param fileNames   a list of the file names
	  */
	@Override
	public void execute(JShell shell, String fileNames) 
	{
		String[] arguments = fileNames.split(" ");
		int num_arguments = arguments.length;
		Directory currentDirectory = shell.getCurrentDirectory();
		for (int i = 1; i < num_arguments; i++)
		{
			if(findFileByName(currentDirectory, arguments[i]) != null) 
			{
				File file = findFileByName(currentDirectory, arguments[i]);
				String contents = file.getContents();
				System.out.println(contents);
				if (num_arguments > 2 && i < num_arguments - 1) 
				{
					System.out.print("\n\n\n");
				}
			}
			else 
			{
				System.out.println("The file '" + arguments[i] + "' does not exist in " + currentDirectory.getFullPathName());
			}
		}
	}

	
	/**
	 * Finds a file by name in a specific directory
	 * @param directory The target directory
	 * @param fileName The name of the sought out file
	 * @return fileList.get(i) The file with same name as fileName
	 */
	public static File findFileByName(Directory directory, String fileName) 
	{
		ArrayList<File> fileList = directory.getListOfFiles();
		for (int i = 0; i < fileList.size(); i++) 
		{
			if (fileList.get(i).getName().equals(fileName)) 
			{
				return fileList.get(i);
			}
		}
		return null;
	}	
		
	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'cat' command.
	  * 
	  * @return the documentation of the 'cat' command
	  */
	@Override
	protected String getDoc() {
		String documentation = "cat: cat FILE1 [FILE2...]\n"
	 				 		 + "\tPrint out the contents of the files inputted\n"
	 				 		 + "\tFILE1 [FILE2...] must be the names of a file.\n\n"
	 				 		 + "\t3 line breaks seperate the contents if more than 1 file name is inputted.\n\n";
		return documentation; 
	}
}
