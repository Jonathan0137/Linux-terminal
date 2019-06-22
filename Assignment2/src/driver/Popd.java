package driver;

public class Popd extends Command {
  //TODO: Add Javadocs
  
 public String getDoc() {
   String documentation = "popd: popd\n"
                        + "\tRemoves the top directory from the directory stack and\n"
                        + "\tchanges the working directory to it.\n\n"
                        + "\tReturns an error message if directory stack is empty.";
   return documentation;
 }
 
 public void execute(JShell shell, String input) {
   // Implementation design:
   // 1. Access the DirectoryStack
   // 2. If DirectoryStack is empty, then output an error message and return
   // 3. Else, remove the first entry in it, and Cd into it
   
   Cd changeDir = new Cd();
   DirectoryStack directoryStack = shell.getDirectoryStack();
   
   // The directory stack is empty, so outputs an error message
   if (directoryStack.getStack().size() == 0) {
     System.out.println("Popd unsuccessful: directory stack is empty.");
   }
   else {
     // Remove the first entry in the directory stack
     Directory newWorkingDirectory = directoryStack.getStack().poll();
     // Change the working directory using Cd
     changeDir.execute(shell, newWorkingDirectory.getFullPathName());
   }
 }
}
