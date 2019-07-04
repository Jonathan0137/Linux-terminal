package command;

import driver.JShell;
import fileSystem.Directory;
import fileSystem.DirectoryStack;

/**
 * Provides functionality for the 'pushd' command.
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
   * @param shell an instance of the JShell that is interacting with the user
   * @param input a relative or absolute path name
   */
  @Override
  public void execute(JShell shell, String input) {
    Directory currentDir = shell.getCurrentDirectory();
    DirectoryStack directoryStack = shell.getDirectoryStack();
    String[] inputSplit = input.split(" ", 2);
    String path = inputSplit[1].trim();
    if (path.length() == 0) {
      System.out.println("Pushd command is missing a path name.");
      return;
    }
    Directory workingDir;
    if (path.charAt(0) == '/') {
      workingDir = shell.getDirectoryTree().getRootDirectory();
    } 
    else { workingDir = shell.getCurrentDirectory(); }
    String absolutePath = Command.getAbsolutePath(path, workingDir);
    // Adds the current directory to the stack, in the case that the given
    // new working directory path is the same as the current working directory.
    if (Command.findDirectory(shell.getDirectoryTree(), 
        absolutePath) == currentDir) {
      directoryStack.getStack().add(currentDir);
      return;
    }
    Command changeDir = new Cd();
    changeDir.execute(shell, input);
    // pushes the currentDir to stack if Cd is successful
    if (currentDir != shell.getCurrentDirectory()) {
      directoryStack.getStack().add(currentDir);
    } else {
      System.out.println("Pushd command failed due to invalid path.");
    }
  }
}
