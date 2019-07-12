package fileSystem;

import java.util.LinkedList;

/**
 * Stores a stack of absolute directory paths.
 * 
 * @author Gary Xie
 */
public class DirectoryStack {
  /**
   * A static instance of the DirectoryStack, to 
   * follow Singleton design pattern.
   */
  private static DirectoryStack dirStack=null;
  
  /**
   * A stack of directories, following LIFO order.
   */
  private LinkedList<Directory> directoryStack;
  
  /**
   * Constructor to create a new DirectoryStack object.
   */
  private DirectoryStack() {
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
  
  /**
   * Returns the sole instance of the DirectoryStack 
   * (following Singleton design pattern). The first time
   * this method is called, it will create a new 
   * DirectoryStack object.
   * 
   * @return the instance of the DirectoryStack
   */
  public static DirectoryStack getDirectoryStack() {
    if (dirStack==null) {
      dirStack = new DirectoryStack();
    }
    return dirStack;
  }
}
