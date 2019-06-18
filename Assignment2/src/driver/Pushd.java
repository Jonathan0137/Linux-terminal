package driver;

import java.util.LinkedList;

public class Pushd extends Command {

  public void execute(String input, JShell shell) {
        
    Cd changeDir = new Cd();
    Directory currentDir = shell.getCurrentDirectory();
    DirectoryStack directoryStack = shell.getDirectoryStack();
    
    // Only pushes the currentDir to stack if the input was valid
    if (changeDir.execute(input, shell)) {
      directoryStack.getStack().add(currentDir);
    }
  }
}