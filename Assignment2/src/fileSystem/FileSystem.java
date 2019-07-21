package fileSystem;

import java.io.Serializable;
import test.interfaces.FileSystemInterface;


/**
 * Contains information about a file system
 * and its root directory.
 * 
 * @author Gary Xie
 */
public class FileSystem implements Serializable {
  
  private static final long serialVersionUID = 1L;

  /**
   * A static instance of the FileSystem, to 
   * follow Singleton design pattern.
   */
  private static FileSystem fs=null;
  
  /**
   * The file system's root directory, which is used 
   * to track information about the entire file system.
   */
  private Directory root;
  
  /**
   * The user's current working directory.
   */
  private Directory workingDir;
  
  /**
   * Constructor for create a new FileSystem.
   */
  private FileSystem() {
    root = new Directory("");
    workingDir = root;
  }

  /**
   * Returns the sole instance of the FileSystem
   * (following Singleton design pattern). The first time
   * this method is called, it will create a new 
   * FileSystem object.
   * 
   * @return the instance of the FileSystem
   */
  public static FileSystem getFileSystem() {
    if (fs==null) {
      fs = new FileSystem();
    }
    return fs;
  }
  
  // Used for loading a FileSystem
  public void setFileSystem(FileSystem newFileSystem) {
    fs = newFileSystem; 
  }
  
  /**
   * Returns the root directory of the FileSystem.
   * 
   * @return the FileSystem's root directory
   */
  public Directory getRootDirectory() {
    return root;
  }
  
  /**
   * Updates the current working directory to newCurrent.
   * 
   * @param newCurrent the new working directory
   */
  public void setCurrentDirectory(Directory newCurrent) {
      workingDir = newCurrent;
  }
  
  /**
   * Returns the current working directory.
   * 
   * @return the current working directory
   */
  public Directory getCurrentDirectory() {
    return workingDir;
  }
  
}
