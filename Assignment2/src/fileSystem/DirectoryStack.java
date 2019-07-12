package fileSystem;

import java.util.LinkedList;

/**
 * Stores a stack of absolute directory paths.
 * 
 * @author Gary Xie
 */
public class DirectoryStack {  
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
