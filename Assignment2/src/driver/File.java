package driver;

public class File {
  private String fullPathName;
  private String name;
  private String contents; // Text contents of the file
  private Directory parentDirectory; // Is this necessary? To know which directory this file is in?
  
  public File(String name) {
    this.name = name;
    this.contents = "";
    this.fullPathName = name;
    this.parentDirectory = null;
  }
  
  public File(String name, String contents) {
    this.name = name;
    this.contents = contents;
    this.fullPathName = name;
    this.parentDirectory = null;
  }
  
  // Method to get/set name
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  // Method to get/set contents
  public void setContents(String contents) {
    this.contents = contents;
  }
  
  public String getContents() {
    return contents;
  }
  // Method to get/set parentDirectory
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the file's full path name using its parent directory
    this.fullPathName = parentDirectory.getFullPathName() + name;
  }
  
  public Directory getParentDirectory() {
    return parentDirectory;
  }
  
  // Do I need functions for set/get name, set/get/append contents? Yes
  // What about distinction between set and append contents? Or should this distinction be in EchoToFile?
}
