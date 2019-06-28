package driver;

public class Popd extends Command {
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'popd' command.
   * 
   * @return the documentation of the 'popd' command
   */
 @Override
 public String getDoc() {
   String documentation = "popd: popd\n"
                        + "\tRemoves the top directory from the directory stack and\n"
                        + "\tchanges the working directory to it.\n\n"
                        + "\tReturns an error message if directory stack is empty.";
   return documentation;
 }

 /**   
  * Removes the top directory from the JShell's directory stack
  * and changes the working directory to it.
  * 
  * If the directory stack is empty, outputs an error message to the user.
  * 
  * @param shell an instance of the JShell that is interacting with the user
  * @param input (unused, only here to override Command execute())
  */
 @Override
 public void execute(JShell shell, String input) {

   Cd changeDir = new Cd();
   DirectoryStack directoryStack = shell.getDirectoryStack();
   
   // The directory stack is empty, so outputs an error message
   if (directoryStack.getStack().size() == 0) {
     System.out.println("Popd unsuccessful: directory stack is empty.");
   }
   else {
     // Remove the last entry in the directory stack
     Directory newWorkingDirectory = directoryStack.getStack().pollLast();
     // Change the working directory using Cd
     changeDir.execute(shell, newWorkingDirectory.getFullPathName());
   }
 }
}
