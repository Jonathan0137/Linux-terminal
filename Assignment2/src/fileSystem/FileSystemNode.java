package fileSystem;

import java.io.Serializable;

/**
 * Contains information about a node 
 * in the file system.
 *
 * @author Gary Xie
 */
public class FileSystemNode implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Absolute path name of the FileSystemNode
   */
  protected String absolutePath;
  
  /**
   * Name of the FileSystemNode
   */
  protected String name;
  
  /**
   * The FileSystemNode's parent directory
   */
  protected Directory parentDirectory;
  
  /**
   * Constructor for FileSystemNode
   * 
   * @param name the name of the FileSystemNode
   */
  public FileSystemNode(String name) {
    this.name = name;
    this.setAbsolutePath(name);
    this.parentDirectory = null;
  }
  
  /**
   * Sets the absolute path of the FileSystemNode to pathName.
   * 
   * @param pathName the absolute path of the FileSystemNode
   */
  protected void setAbsolutePath(String pathName) {

    this.absolutePath = pathName;
  }
  
  /**
   * Sets the name of the FileSystemNode.
   * 
   * @param name the FileSystemNode's new name
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the FileSystemNode's name.
   * 
   * @return the name of the FileSystemNode
   */
  public String getName() {
    return name;
  }
  
  /**
   * Returns the absolute path name of the FileSystemNode.
   * 
   * @return the FileSystemNode's absolute path
   */
  public String getFullPathName() {
    return absolutePath;
  }
  
  /**
   * Sets the FileSystemNode's parent directory, and updates
   * its absolute path name based on the parent directory.
   * 
   * @param parentDirectory the FileSystemNode's parent directory
   */
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the FileSystemNode's absolute path using its parent directory
    this.setAbsolutePath(parentDirectory.getFullPathName() + name);
  }
  
  /**
   * Returns the FileSystemNode's parent directory.
   * 
   * @return the parent directory of the FileSystemNode
   */
  public Directory getParentDirectory() {
    return parentDirectory;
  }
}
