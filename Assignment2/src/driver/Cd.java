package driver;

public class Cd extends Command {
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'cd' command.
   * 
   * @return the documentation of the 'cd' command
   */
  @Override
  public String getDoc() {
    String documentation = "cd: cd DIR\n"
                         + "\tChange the shell's current directory to DIR.\n"
                         + "\tDIR must be a valid absolute or relative path name.\n\n"
                         + "\tIf DIR begins with a slash (/), then it is interpreted\n"
                         + "\tas an absolute path, starting from the root directory.\n"
                         + "\tOtherwise, it is interpreted as a relative path to the\n"
                         + "\tcurrent directory.\n\n"
                         + "\tThe root of the file system is a single slash (/).\n\n"
                         + "\t'..' represents the parent directory.\n"
                         + "\t'.' represents the current directory.\n";
    return documentation;
  }
  
  /**
   * Changes the working directory to the directory specified 
   * by the user's input, if it exists.
   * 
   * @param shell   an instance of the JShell that is interacting with the user
   * @param input   a relative or absolute path name
   */
  @Override
  public void execute(JShell shell, String input) {
    String[] inputSplit = input.split(" ", 2);
    if (inputSplit.length < 2) {
      System.out.println("Cd is missing an argument: requires a relative or absolute path.");
      return;
    }
    // Ignore the 'cd' part of the input
    input = inputSplit[1];
    
    Directory workingDirectory = shell.getCurrentDirectory();
    FileSystem fs = shell.getDirectoryTree();
    Directory root = fs.getRootDirectory();
    
    Directory newWorkingDirectory = null;
    String absolutePathName;
    
    // Input is an absolute path
    if (input.charAt(0) == '/') {
      // Even though it is an absolute path, there may still be a need to convert '..' and '.'
      absolutePathName = Command.getAbsolutePath(input, root);
    }
    // Input is a relative path
    else {
      absolutePathName = Command.getAbsolutePath(input, workingDirectory);    
    }
    
    newWorkingDirectory = Command.findDirectory(fs, absolutePathName);
    
    if (newWorkingDirectory != null) {
      shell.setCurrentDirectory(newWorkingDirectory);
    }
    else {
    // Print an appropriate error message to user and does not change working directory
    System.out.println("Specified path not found."); 
    }
  }
  
  // FOR TESTING PURPOSES ONLY
  public static void main(String[] args) {
//    FileSystem fs = new FileSystem();
//    Directory root = fs.getRootDirectory();
//    
//  Directory subDir = new Directory("hello");
//  root.addSubdirectory(subDir);
//  Directory subSubdir = new Directory("world1");
//  subDir.addSubdirectory(subSubdir);
//  subSubdir = new Directory("world2");
//  subDir.addSubdirectory(subSubdir);
//  
//  if (fs.getDirectory("/hello/world2") != null) {
//    System.out.println("Successfully found");
//  }
//  else {
//    System.out.println("Directory not found");
//  }
//  
//  Cd command = new Cd();
//  Directory newWorkingDir = command.execute("hello/world1/../world2/././././..");
//  System.out.println(newWorkingDir.getFullPathName());
//    

    Command cd = new Cd();
    String doc = cd.getDoc();
    System.out.println(doc);
    
    
    
  }
}
