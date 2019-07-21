package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.FileSystemManipulation;

/**
 * Provides functionality for the 'cd' command,
 * allowing the user to change their current working directory.
 * 
 * @author Gary Xie
 */
public class Cd extends Command {
  /**
   * Returns a String containing the documentation for 
   * the functionalities of the 'cd' command.
   * 
   * @return the documentation of the 'cd' command
   */
  @Override
  public String getDoc() {
    String documentation = "cd: cd DIR\n\tChange the shell's current "
        + "directory to DIR.\n\tDIR must be a valid absolute or "
        + "relative path name.\n\n\tIf DIR begins with a slash (/), "
        + "then it is interpreted\n\tas an absolute path, starting "
        + "from the root directory.\n\tOtherwise, it is interpreted "
        + "as a relative path to the\n" + "\tcurrent directory.\n\n"
        + "\tThe root of the file system is a single slash (/).\n\n"
        + "\t'..' represents the parent directory.\n" 
        + "\t'.' represents the current directory.\n";
    return documentation;
  }

  /**
   * Changes the working directory to the directory 
   * specified by the user's input, if it exists.
   * 
   * @param shell an instance of the JShell that is interacting with the user
   * @param input a relative or absolute path name
   */
  @Override
  public void execute(ArrayList<Object> param) {
    String input = (String) param.get(0);
    String[] inputSplit = input.split(" ", 2);
    // Ignore the 'cd' part of the input
    input = inputSplit[1].trim();
    Directory workingDirectory = fs.getCurrentDirectory();
    Directory root = fs.getRootDirectory();
    Directory newWorkingDirectory = null;
    String absolutePathName;
    // Input is an absolute path
    if (input.charAt(0) == '/') {
      // Convert '..' and '.' to absolute path
      absolutePathName = FileSystemManipulation.getAbsolutePath(input, root);
    }
    // Input is a relative path
    else {
      absolutePathName = FileSystemManipulation.getAbsolutePath(input, workingDirectory);
    }
    newWorkingDirectory = (Directory) FileSystemManipulation.findFileSystemNode(absolutePathName);

    if (newWorkingDirectory != null) {
      fs.setCurrentDirectory(newWorkingDirectory);
    } else {
      output.addErrorOutput("Specified path not found.");
    }
  }
}
