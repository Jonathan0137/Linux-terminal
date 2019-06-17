package driver;

public class FileSystem {
  private String pathName;
  private String type; // Indicates if current place is File or Directory? Maybe unnecessary, i.e. have a parent class for file/directory?
  private Directory head;
  
  public FileSystem() {
    pathName = "/";
    head = new Directory();
  }
  
  // Do I need methods for changing directories and accessing subdirectories/files here?
  // That conflicts with responsibilities for Cd and other commands, but how else
  // do the other commands access the private variables?
}
