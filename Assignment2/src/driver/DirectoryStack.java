package driver;

import java.util.LinkedList;

public class DirectoryStack {
  private LinkedList<Directory> directoryStack;
  
  public DirectoryStack() {
    directoryStack = new LinkedList<Directory>();
  }
  
  public LinkedList<Directory> getStack() {
    return directoryStack;
  }
}
