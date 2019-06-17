package driver;

import java.util.ArrayList;

public class Directory {
  private String name;
  private Directory parentDirectory; // This is necessary to access parent directory using commands such as Cd, right?
  private ArrayList<Directory> listOfSubdirectories;
  private ArrayList<File> listOfFiles;
  
  public Directory() {
    // Constructor used for creating a head directory
    this.name = "";
    this.parentDirectory = null; // Has no parent directory
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  // Constructor for creating directories that are not the head of the File System
  public Directory(String name, Directory parentDirectory) {
    this.name = name;
    this.parentDirectory = parentDirectory;
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  // Method to add a subdirectory to the list of subdirectories
  public void addSubdirectory(Directory subDirectory) {
    if (listOfSubdirectories.contains(subDirectory) ) { // Maybe use subDirectory.getName() if that's what is differentiating them
      // Not sure if Directory class is responsible for printing this error?
      System.out.println("Error: Directory '" + subDirectory.name + "' already exists.") // May need to change subDirectory.name to subDirectory.getName()
      return;
    }
    
    listOfSubdirectories.add(subDirectory);
  }
  
//Method to remove a subdirectory to the list of subdirectories
 public void removeSubdirectory(Directory subDirectory) {
   if (!listOfSubdirectories.contains(subDirectory) ) {
     // Not sure if Directory class is responsible for printing this error?
     System.out.println("Error: Cannot remove '" + subDirectory.name + "': No such directory exists.") // May need to change subDirectory.name to subDirectory.getName()
     return;
   }
   
   listOfSubdirectories.remove(subDirectory);
 }
  
  //Method to add a file to the list of files
  public void addFile(File file) {
    if (listOfFiles.contains(file) ) {
      System.out.println("Error: File '" + file.name + "' already exists."); // May need to change file.name to file.getName()
      return;
    }
    
    listOfFiles.add(file);
  }
  
  public void removeFile(File file) {
    if (!listOfFiles.contains(file) ) {
      // Not sure if Directory class is responsible for printing this error?
      System.out.println("Error: Cannot remove '" + file.name + "': No such file exists."); // May need to change subDirectory.name to subDirectory.getName()
      return;
    }
    
    listOfFiles.remove(file);
  }
  
  //TODO:
  // Methods to remove files and directories -- DONE
  // Methods to find and return files and directories in here
  // Methods to get and set name and parentDirectory
  // Methods to get listOfSubdirectories and listOfFiles
  
  public Directory findDirectory(String directoryName) {
    for (int i=0; i<listOfSubdirectories.size(); i++) {
      if (directoryName == listOfSubdirectories.get(i).getName()) {
        return listOfSubdirectories.get(i);
      }
    }
    // Do I need to print an error message saying DIRECTORY NOT FOUND?
    return null;
  }
  
  public File findFile(String fileName) {
    for (int i=0; i<listOfFiles.size(); i++) {
      if (directoryName == listOfFiles.get(i).getName()) {
        return listOfSubdirectories.get(i);
      }
    }
    // Do I need to print an error message saying DIRECTORY NOT FOUND?
    return null;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setParentDirectory() {
    
  }
  
  public Directory getParentDirectory() {
    
  }
  
  public ArrayList<Directory> getListOfSubdirectories() {
    
  }
  
  public ArrayList<Files> getListOfFiles() {
    
  }
  
  
  
  
  // Do I need functions for finding files/directories (does that conflict with responsibilities for Commands?), or is Cd just calling this method
}
