package driver;

public class Cd extends ManipulationCommand {
  // Required Parent Class: ManipulationCommand
  
  public Directory execute(String input, Directory workingDir, FileSystem fs) {
    // Implementation design:
    // 1. Treat input as a relative path, attempt to Cd (i.e. update workingDir)
    // 2. If fails, convert input into absolute path using workingDir.getFullPathName() and try again
    // 3. Otherwise, send an appropriate error, saying that the path does not exist.
    
    // Interpret input as a relative path
    String fullPathName = workingDir.getFullPathName() + input;
    Directory newWorkingDirectory = fs.getDirectory(fullPathName);
    
    if (newWorkingDirectory != null) {
      return newWorkingDirectory;
    }
    
    // Interpret input as an absolute path
    fullPathName = input;
    newWorkingDirectory = fs.getDirectory(fullPathName);
    
    if (newWorkingDirectory != null) {
      return newWorkingDirectory;
    }
    
    // Print an appropriate error message to user and does not change working directory
    System.out.println("Specified path not found.");
    return workingDir;
    
  }
  
}
