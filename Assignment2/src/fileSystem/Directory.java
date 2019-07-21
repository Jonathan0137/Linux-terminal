package fileSystem;

import java.util.HashMap;
import java.io.Serializable;

/**
 * Contains information about a directory
 * and the subdirectories and files it contains.
 * 
 * @author Gary Xie
 */
public class Directory extends FileSystemNode implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * HashMap of subdirectories and files in the Directory.
   * Key: name of the subdirectory or file
   * Value: the actual File or Directory
   */
  private HashMap<String, FileSystemNode> listOfFileSystemNodes;

  /**
   * Constructor for Directory.
   * 
   * @param name the name of the directory
   */
  public Directory(String name) {
    super(name);
    listOfFileSystemNodes = new HashMap<String, FileSystemNode>();
  }
  
  /**
   * Sets the absolute path of the directory to pathName,
   * with an additional '/' character at the end.
   * 
   * @param pathName the absolute path of the directory
   */
  @Override
  protected void setAbsolutePath(String pathName) {
    this.absolutePath = pathName + "/";
  }
  
  /**
   * Returns a HashMap containing the 
   * subdirectories and files in the directory.
   * 
   * @return a list of the directory's subdirectories
   */
  public HashMap<String, FileSystemNode> getListOfFileSystemNodes() {
    return listOfFileSystemNodes;
  }
}
