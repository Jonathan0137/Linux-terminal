package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.DirectoryStack;

/**
 * Provides functionality for the 'popd' command,
 * allowing the user to remove a directory from
 * the directory stack and changing the working directory
 * to this directory.
 * 
 * @author Gary Xie
 */
public class Popd extends Command {
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'popd' command.
   * 
   * @return the documentation of the 'popd' command
   */
  @Override
  public String getDoc() {
    String documentation =
        "popd: popd\n\tRemoves the top directory from the directory "
        + "stack and\n\tchanges the working directory to it.\n\n"
        + "\tReturns an error message if directory stack is empty.";
    return documentation;
  }

  /**
   * Removes the top directory from the JShell's directory 
   * stack and changes the working directory to it.
   * 
   * If the directory stack is empty, outputs an error message to the user.
   * 
   * @param dirStack an instance of the Directory Stack
   * @param input (unused, only here to override Command execute())
   */
  @Override
  public void execute(ArrayList<Object> param) {
    
    DirectoryStack dirStack = (DirectoryStack) param.get(0);
    Cd changeDir = new Cd();

    // The directory stack is empty, so outputs an error message
    if (dirStack.getStack().size() == 0) {
      System.out.println("Popd unsuccessful: directory stack is empty.");
    } else {
      // Remove the last entry in the directory stack
      Directory newWorkingDirectory = dirStack.getStack().pollLast();
      // Change the working directory using Cd
      ArrayList<Object> parameters = new ArrayList<Object>();
      parameters.add("cd " + newWorkingDirectory.getFullPathName());
      changeDir.execute(parameters);
    }
  }
}
