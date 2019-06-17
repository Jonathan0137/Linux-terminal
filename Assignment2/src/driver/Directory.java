package driver;

import java.util.ArrayList;

public class Directory {
  private String name;
  private Directory parentDirectory; // This is necessary to access parent directory using commands such as Cd, right?
  private ArrayList<Directory> listOfSubdirectories;
  private ArrayList<File> listOfFiles;
  
  public Directory() {
    // Only used for creating a head directory
    this.name = "";
    this.parentDirectory = null; // Has no parent directory
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  
  public Directory(String name, Directory parentDirectory) {
    this.name = name;
    this.parentDirectory = parentDirectory;
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  // Do I need functions for finding files/directories (does that conflict with responsibilities for Commands?), or is Cd just calling this method
}
