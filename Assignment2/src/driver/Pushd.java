package driver;

public class Pushd extends Command {  
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'pushd' command.
   * 
   * @return the documentation of the 'pushd' command
   */
  @Override
  public String getDoc() {
    String documentation = "pushd: pushd DIR\n"
                         + "\tSaves the current directory by adding it to the end of the\n"
                         + "\tdirectory stack. Then, it changes the current directory to DIR.\n\n"
                         + "\tDIR must be a valid absolute or relative path name.";
    return documentation;
  }
  
  /**
   * Saves the current working directory by adding it to the end of the JShell's directory stack
   * and changes the working directory to the directory specified by the user input,
   * if this specified directory exists.
   * 
   * @param shell   an instance of the JShell that is interacting with the user
   * @param input   a relative or absolute path name
   */
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