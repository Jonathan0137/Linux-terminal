package command;

import java.util.ArrayList;
import fileSystem.*;
import output.Output;

public class Find extends Command {

	/**
	 * Execute find command
	 * 
	 * @param param		ArrayList containing all parameters required by find
	 */
	@Override
	public void execute(ArrayList<Object> param) {
		String arguments = (String) param.get(0);
		String name = "";
		for (int i = arguments.indexOf("\"") + 1; i < 
									arguments.lastIndexOf("\""); i++) {
			name = name.concat(String.valueOf(arguments.charAt(i)));
		}
		String[] argList = arguments.split(" ");
		ArrayList<String> paths = new ArrayList<>();
		String type = "";
		for (int i = 1; i < argList.length; i++) {
			if (argList[i].contains("/")) {
				paths.add(argList[i]);
			}
			if (argList[i] == "d") {
				type = "d";
			}
			else if (argList[i] == "f") {
				type = "f";
			}
		}
		findNode(name, type, paths);
	}
	/**
	 * Find the node the user is looking for
	 * 
	 * @param name	name of the node the user is finding
	 * @param type 	type of the node (f/d)
	 * @param paths	list of the paths to the directories being searched
	 */
	public void findNode(String name, String type, ArrayList<String> paths) {
		Directory workingDir = FileSystem.getFileSystem().
													getCurrentDirectory();
		for (String path: paths) {
			String absPath = FileSystemManipulation.getAbsolutePath(path,
																workingDir);
			Directory searchDir = (Directory) FileSystemManipulation.
												findFileSystemNode(absPath);
			String absolutePath = "";
			Output out = Output.getOutputInstance();
			if (type == "d") {
				Directory foundDir = (Directory) FileSystemManipulation.
												findSubNode(searchDir, name);
				if (foundDir != null) {
					absolutePath = foundDir.getFullPathName();
					out.addUserOutput(absolutePath);
				}
				else {
					out.addErrorOutput(name + "is not in the directory " +
																	absPath);
				}
			}
			else if (type == "f") {
				File foundFile = (File) FileSystemManipulation.findSubNode(
															searchDir, name);
				if (foundFile != null) {
					absolutePath = foundFile.getFullPathName();
					out.addUserOutput(absolutePath);
				}
				else {
					out.addErrorOutput(name + "is not in the directory " +
																	absPath);
				}
			}
		}
	}

	/**
	  * Returns a String containing the documentation 
	  * for the functionalities of the 'find' command.
	  * 
	  * @return the documentation of the 'find' command
	  */
	@Override
	protected String getDoc() {
		String documentation = "find: find path... -type [f|d] -name expression\n"
	   			 + "\tfind the node named 'expression' in the directories\n"
	   			 + "\tgiven by path. There can be multiple paths given.\n "
	   			 + "\tIf the type is 'f' then find a file with name expression,\n"
	   			 + "\tand if type is 'd' then find a directory with name expression";
		return documentation; 
	}

}
