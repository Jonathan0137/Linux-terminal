package driver;

import java.util.ArrayList;

public class Directory {
  // Absolute path name of the Directory
  private String absolutePath;
  // Name of the Directory
  private String name;
  // The Directory's parent directory
  private Directory parentDirectory;
  // List of subdirectories in the Directory
  private ArrayList<Directory> listOfSubdirectories;
  // List of files in the Directory
  private ArrayList<File> listOfFiles;
  
  /**
   * Constructor for Directory.
   * 
   * @param name    the name of the directory
   */
  public Directory(String name) {
    this.name = name;
    this.absolutePath = name + "/";
    this.parentDirectory = null;
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  /**
   * Returns the subdirectory with the given name if it exists, otherwise returns null.
   * 
   * @param directoryName the name of the wanted subdirectory
   * @return the subdirectory with the name of directoryName
   */
  // TODO: Move this to Command later
  public Directory findDirectory(String directoryName) {
    for (int i=0; i<listOfSubdirectories.size(); i++) {
      if (directoryName.equals(listOfSubdirectories.get(i).getName())) {
        return listOfSubdirectories.get(i);
      }
    }
    return null;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public String getFullPathName() {
    return absolutePath;
  }
  
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the directory's absolute path name using its parent directory
    this.absolutePath = parentDirectory.getFullPathName() + name + "/";
  }
  
  public Directory getParentDirectory() {
    return parentDirectory;
  }
  
  public ArrayList<Directory> getListOfSubdirectories() {
    return listOfSubdirectories;
  }
  
  public ArrayList<File> getListOfFiles() {
    return listOfFiles;
  }  
  
}
