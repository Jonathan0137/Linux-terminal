package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import output.Output;

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
	  * @param param	ArrayList containing all parameters required by cat
	  */
	@Override
	public void execute(ArrayList<Object> param)
	{
		String fileNames = (String) param.get(0);
		String[] arguments = fileNames.split(" ");
		int num_arguments = arguments.length;
		Directory currentDir = FileSystem.getFileSystem().getCurrentDirectory();
		Output out = Output.getOutputInstance();
		for (int i = 1; i < num_arguments; i++)
		{
			if(FileSystemManipulation.findSubNode(currentDir, arguments[i])
															instanceof File)
			{
				if (arguments[i] != "") {
					File f = 
					    (File) FileSystemManipulation.findSubNode(currentDir,
					    										arguments[i]);
					String contents = f.getContents();
					//put contents into output
					out.addUserOutput(contents);
					if (num_arguments > 2 && i < num_arguments - 1) {
					  //add line breaks to output
					  out.addUserOutput("\n\n\n"); 
					}
				}
			}
			else 
			{
				//put into error output
				String error = "The file '" + arguments[i] + "' does not exist"
								+ " in " + currentDir.getFullPathName();
				out.addErrorOutput(error);
				if (num_arguments > 2 && i < num_arguments - 1) {
					//add line breaks to output
					out.addUserOutput("\n\n\n"); 
				}
			}
		}
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
