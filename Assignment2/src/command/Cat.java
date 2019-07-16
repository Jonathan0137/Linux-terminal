package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;


/**
 * Cat allows any user to display the contents of one or more files, given 
 * file names that are relative to the current directory. 
 * 
 * @author Adil Shah
 *
 */
public class Cat extends Command {
	
	/**
	  * Prints out the contents of any files the user inputs
	  * 
	  * @param shell   an instance of the JShell that interacts with user
	  * @param fileNames   a list of the file names
	  */
	@Override
	public void execute(ArrayList<Object> param) 
	{
		String fileNames = (String) param.get(0);
		String[] arguments = fileNames.split(" ");
		int num_arguments = arguments.length;
		Directory currentDirectory = FileSystem.getFileSystem().
														getCurrentDirectory();
		for (int i = 1; i < num_arguments; i++)
		{
			if(findFileByName(currentDirectory, arguments[i]) != null) 
			{
				if (arguments[i] != "") {
					File f = findFileByName(currentDirectory, arguments[i]);
					String contents = f.getContents();
					//put contents into output if not redirected
					System.out.println(contents);
					if (num_arguments > 2 && i < num_arguments - 1) 
					{
						//add line breaks to output
						System.out.print("\n\n\n");
					}
				}
			}
			else 
			{
				//put into error output
				System.out.println("The file '" + arguments[i] + "' does not"
						+ " exist in " + currentDirectory.getFullPathName());
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
		String doc = "cat: cat FILE1 [FILE2...]\n"
	 			   + "\tPrint out contents of the files inputted\n"
	 	   		   + "\tFILE1 [FILE2...] must be the names of a file.\n\n"
	 			   + "\t3 line breaks seperate the contents if more than"
	 			   + " 1 file name is inputted.\n\n";
		return doc; 
	}
}
