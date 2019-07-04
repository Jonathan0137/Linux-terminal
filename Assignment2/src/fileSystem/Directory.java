package fileSystem;

import java.util.ArrayList;

/**
 * Contains information about a directory
 * and the subdirectories and files it contains.
 * 
 * @author Gary Xie
 */
public class Directory {
  /**
   * Absolute path name of the Directory
   */
  private String absolutePath;
  /**
   * Name of the Directory
   */
  private String name;
  /**
   * The Directory's parent directory
   */
  private Directory parentDirectory;
  /**
   * List of subdirectories in the Directory
   */
  private ArrayList<Directory> listOfSubdirectories;
  /**
   * List of files in the Directory
   */
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
   * Sets the name of the directory.
   * 
   * @param name the directory's new name
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the directory's name.
   * 
   * @return the name of the directory
   */
  public String getName() {
    return name;
  }
  
  /**
   * Returns the absolute path name of the directory.
   * 
   * @return the directory's absolute path
   */
  public String getFullPathName() {
    return absolutePath;
  }
  
  /**
   * Sets the directory's parent directory, and updates
   * its absolute path name based on the parent directory.
   * 
   * @param parentDirectory the directory's parent directory
   */
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the directory's absolute path name using its parent directory
    this.absolutePath = parentDirectory.getFullPathName() + name + "/";
  }
  
  /**
   * Returns the directory's parent directory.
   * 
   * @return the parent directory of the directory
   */
  public Directory getParentDirectory() {
    return parentDirectory;
  }
  
  /**
   * Returns a list containing the 
   * subdirectories in the directory.
   * 
   * @return a list of the directory's subdirectories
   */
  public ArrayList<Directory> getListOfSubdirectories() {
    return listOfSubdirectories;
  }
  
  /**
   * Returns a list containing the files 
   * in the directory.
   * 
   * @return a list of the directory's files
   */
  public ArrayList<File> getListOfFiles() {
    return listOfFiles;
  }  
}
