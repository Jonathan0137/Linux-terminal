package fileSystem;

public class FileSystem {
  // Tracks information about the entire file system via the root Directory
  private Directory root;
  
  /**
   * Constructor for create a new FileSystem.
   */
  public FileSystem() {
    root = new Directory("");
  }

  /**
   * Returns the root directory of the FileSystem.
   * 
   * @return the FileSystem's root directory
   */
  public Directory getRootDirectory() {
    return root;
  }
}
