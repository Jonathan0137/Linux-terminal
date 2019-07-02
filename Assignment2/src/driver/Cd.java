package driver;

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
  public void execute(JShell shell, String input) {
    String[] inputSplit = input.split(" ", 2);
    // Ignore the 'cd' part of the input
    input = inputSplit[1].trim();
    if (input.length() == 0) {
      System.out.println("Cd command is missing a path name.");
      return;
    }
    Directory workingDirectory = shell.getCurrentDirectory();
    FileSystem fs = shell.getDirectoryTree();
    Directory root = fs.getRootDirectory();
    Directory newWorkingDirectory = null;
    String absolutePathName;
    // Input is an absolute path
    if (input.charAt(0) == '/') {
      // Convert '..' and '.' to absolute path
      absolutePathName = Command.getAbsolutePath(input, root);
    }
    // Input is a relative path
    else {
      absolutePathName = Command.getAbsolutePath(input, workingDirectory);
    }
    newWorkingDirectory = Command.findDirectory(fs, absolutePathName);

    if (newWorkingDirectory != null) {
      shell.setCurrentDirectory(newWorkingDirectory);
    } else {
      System.out.println("Specified path not found.");
    }
  }
}
