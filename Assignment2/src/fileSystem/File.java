package fileSystem;

public class File { 
  // Absolute path name of the File
  private String absolutePath;
  // Name of the File
  private String name;
  // Text contents of the File
  private String contents;
  // Parent directory of the File
  private Directory parentDirectory;
  
  /**
   * Constructor for File, with no content inside.
   * 
   * @param name    the name of the file
   */
  public File(String name) {
    this.name = name;
    this.contents = "";
    this.absolutePath = name;
    this.parentDirectory = null;
  }
  
  /**
   * Constructor for File, with the given contents.
   * 
   * @param name        the name of the file
   * @param contents    the contents of the file
   */
  public File(String name, String contents) {
    this.name = name;
    this.contents = contents;
    this.absolutePath = name;
    this.parentDirectory = null;
  }
  
  /**
   * Returns the absolute path name of the file.
   * 
   * @return the file's absolute path
   */
  public String getFullPathName() {
    return absolutePath;
  }
  
  
  /**
   * Sets the name of the file.
   * 
   * @param name the file's new name
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /** 
   * Returns the file's name.
   * 
   * @return the name of the file
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets the contents of the file.
   * 
   * @param contents the file's new contents
   */
  public void setContents(String contents) {
    this.contents = contents;
  }
  
  /**
   * Returns the file's contents.
   * 
   * @return the contents of the file
   */
  public String getContents() {
    return contents;
  }
  
  /**
   * Sets the file's parent directory, and updates
   * its absolute path name based on the parent directory.
   * 
   * @param parentDirectory the file's parent directory
   */
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the file's full path name using its parent directory
    this.absolutePath = parentDirectory.getFullPathName() + name;
  }
  
  /**
   * Returns the file's parent directory.
   * 
   * @return the parent directory of the file.
   */
  public Directory getParentDirectory() {
    return parentDirectory;
  }
}
