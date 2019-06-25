package driver;

import java.util.LinkedList;

public class DirectoryStack {
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
