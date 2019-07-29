package fileSystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Stores a stack of absolute directory paths.
 * 
 * @author Gary Xie
 */
public class DirectoryStack implements Serializable {  

  private static final long serialVersionUID = 1L;
  
  /**
   * A stack of directories, following LIFO order.
   */
  private LinkedList<Directory> directoryStack;
  
  /**
   * Constructor to create a new DirectoryStack object.
   */
  public DirectoryStack() {
    directoryStack = new LinkedList<Directory>();
  }
  
  /**
   * Returns the directory stack.
   * 
   * @return the directory stack.
   */
  public LinkedList<Directory> getStack() {
    return directoryStack;
  }
}
