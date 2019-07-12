package fileSystem;

import java.util.ArrayList;

/**
 * Contains information about a directory
 * and the subdirectories and files it contains.
 * 
 * @author Gary Xie
 */
public class Directory extends FileSystemNode {
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
   * @param name the name of the directory
   */
  public Directory(String name) {
    super(name);
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  /**
   * Sets the absolute path of the directory to pathName,
   * with an additional '/' character at the end.
   * 
   * @param pathName the absolute path of the directory
   */
  @Override
  protected void setAbsolutePath(String pathName) {
    this.absolutePath = pathName + "/";
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
