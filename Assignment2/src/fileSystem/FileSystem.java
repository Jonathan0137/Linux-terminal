package fileSystem;

/**
 * Contains information about a file system
 * and its root directory.
 * 
 * @author Gary Xie
 */
public class FileSystem {
  /**
   * The file system's root directory, which is used 
   * to track information about the entire file system.
   */
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
