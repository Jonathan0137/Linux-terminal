package driver;

public class Pushd extends Command {
  // TODO: Add Javadocs
  
  @Override
  public String getDoc() {
    String documentation = "pushd: pushd DIR\n"
                         + "\tSaves the current directory by adding it to the end of the\n"
                         + "\tdirectory stack. Then, it changes the current directory to DIR.\n\n"
                         + "\tDIR must be a valid absolute or relative path name.";
    return documentation;
  }
  
  @Override
  public void execute(JShell shell, String input) {
        
    Cd changeDir = new Cd();
    Directory currentDir = shell.getCurrentDirectory();
    DirectoryStack directoryStack = shell.getDirectoryStack();
    
    // Change the working directory using Cd
    changeDir.execute(shell, input);
    
    // Only pushes the currentDir to stack if the input successfully changed the working directory
    if (currentDir != shell.getCurrentDirectory()) {
      directoryStack.getStack().add(currentDir);
    }
    else {
      System.out.println("Pushd command was unsuccessful due to invalid path.");
    }
  }
}