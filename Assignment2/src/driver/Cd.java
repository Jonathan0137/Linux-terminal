package driver;

public class Cd extends Command {
  // TODO: Add Javadocs

  public String getDoc() {
    String documentation = "cd :cd DIR\n"
                         + "\tChange the shell's current directory to DIR.\n\n"
                         + "\tIf DIR begins with a slash (/), then it is interpreted\n"
                         + "\tas an absolute path, starting from the root directory.\n"
                         + "\tOtherwise, it is interpreted as a relative path to the\n"
                         + "\tcurrent directory.\n\n"
                         + "\tThe root of the file system is a single slash (/).\n\n"
                         + "\t'..' represents the parent directory.\n"
                         + "\t'.' represents the current directory.\n";
    return documentation;
  }
  
  public void execute(JShell shell, String input) {
    // Should return true or false based on whether or not workingDir was changed
    // Change parameters to have 1 JShell parameter, which I can use to call workingDir and fs
    // NOTE: my code currently assumes that 'input' doesn't contain "cd" as part of the string, only what comes after
    
    // Implementation design:
    // 1. Determine if input is a relative path or an absolute path
    // 2. If relative, convert to absolute path
    // 3. Find the directory in the File System. If nonexistent, output a descriptive error

    
    Directory workingDirectory = shell.getCurrentDirectory();
    FileSystem fs = shell.getDirectoryTree();
    Directory root = fs.getRootDirectory();
    
    Directory newWorkingDirectory = null;
    String absolutePathName;
    
    // Input is an absolute path
    if (input.charAt(0) == '/') {
      // Even though it is an absolute path, there may still be a need to convert '..' and '.'
      absolutePathName = getAbsolutePath(input, root);
    }
    // Input is a relative path
    else {
      absolutePathName = getAbsolutePath(input, workingDirectory);    
    }
    
    newWorkingDirectory = fs.getDirectory(absolutePathName);
    
    if (newWorkingDirectory != null) {
      shell.setCurrentDirectory(newWorkingDirectory);
    }
    else {
    // Print an appropriate error message to user and does not change working directory
    System.out.println("Specified path not found."); 
    }
  }
  
  private static String getAbsolutePath(String input, Directory workingDir) {
      // Helper function for when input is a relative path name;
      // Converts relative path name to absolute path name
      String[] pathList = input.split("/");
      
      String fullPathName = workingDir.getFullPathName();
      
      for (int i=0; i<pathList.length; i++) {
        if (pathList[i].equals(".") || pathList[i].equals("")) {
          continue;
        }
        else if (pathList[i].equals("..")) {
          fullPathName = moveToParentDirectory(fullPathName);
        }
        else {
          fullPathName = fullPathName + pathList[i] + "/";
        }
      }
      
      return fullPathName;
  }
    
  private static String moveToParentDirectory(String pathName) {
    // Moves the pathName to the path name of the parent directory
    
    if (pathName.equals("/")) {
      return pathName;
    }
    
    String newPathName = pathName;
    
    if (newPathName.charAt(newPathName.length() - 1) == '/') {
      newPathName = newPathName.substring(0, newPathName.length() - 1);
    }
    
    for (int i = newPathName.length() - 1; i>=0; i--) {
      if (newPathName.charAt(i) == '/') {
        break;
      }      
      newPathName = newPathName.substring(0, i);
    } 
    return newPathName;
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
