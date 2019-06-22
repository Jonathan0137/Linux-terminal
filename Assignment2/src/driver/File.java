package driver;

public class File {
  //TODO: Complete JavaDocs and add comments
  
  private String absolutePath;
  private String name;
  private String contents; // Text contents of the file
  private Directory parentDirectory;
  
  public File(String name) {
    this.name = name;
    this.contents = "";
    this.absolutePath = name;
    this.parentDirectory = null;
  }
  
  public File(String name, String contents) {
    this.name = name;
    this.contents = contents;
    this.absolutePath = name;
    this.parentDirectory = null;
  }
  
  public String getFullPathName() {
    return absolutePath;
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
    this.absolutePath = parentDirectory.getFullPathName() + name;
  }
  
  public Directory getParentDirectory() {
    return parentDirectory;
  }
}
