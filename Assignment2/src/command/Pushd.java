package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.DirectoryStack;
import fileSystem.FileSystemManipulation;

/**
 * Provides functionality for the 'pushd' command,
 * allowing the user to add the current working directory
 * to the directory stack, and changing to a new working directory.
 * 
 * @author Gary Xie
 */
public class Pushd extends Command {
  /**
   * Returns a String containing the documentation for the 
   * functionalities of the 'pushd' command.
   * 
   * @return the documentation of the 'pushd' command
   */
  @Override
  public String getDoc() {
    String documentation =
        "pushd: pushd DIR\n" + "\tSaves the current directory by adding it "
            + "to the end of the\n\tdirectory stack. Then, it changes the "
            + "current directory to DIR.\n\n"
            + "\tDIR must be a valid absolute or relative path name.";
    return documentation;
  }

  /**
   * Saves the current working directory by adding it to the end of 
   * the JShell's directory stack and changes the working directory 
   * to the directory specified by the user input, if this specified
   * directory exists.
   * 
   * @param dirStack an instance of the Directory Stack
   * @param input    a relative or absolute path name
   */
  @Override
  public void execute(ArrayList<Object> param) {
    String input = (String) param.get(0);
    DirectoryStack dirStack = (DirectoryStack) param.get(1);
    Directory currentDir = fs.getCurrentDirectory();
    String[] inputSplit = input.split(" ", 2);
    String path = inputSplit[1].trim();
    if (path.length() == 0) {
      System.out.println("Pushd command is missing a path name.");
      return;
    }
    Directory startDir;
    if (path.charAt(0) == '/') {
      startDir = fs.getRootDirectory();
    } 
    else { startDir = currentDir; }
    String absolutePath = FileSystemManipulation.getAbsolutePath(path, startDir);
    // Adds the current directory to the stack, in the case that the given
    // new working directory path is the same as the current working directory.
    if (FileSystemManipulation.findFileSystemNode(absolutePath) == currentDir) {
      dirStack.getStack().add(currentDir);
      return;
    }
    Command changeDir = new Cd();
    changeDir.execute(param);
    // pushes the currentDir to stack if Cd is successful
    if (currentDir != fs.getCurrentDirectory()) {
      dirStack.getStack().add(currentDir);
    } else {
      System.out.println("Pushd command failed due to invalid path.");
    }
  }
}
