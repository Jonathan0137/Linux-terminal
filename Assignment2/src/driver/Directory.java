package driver;

import java.util.ArrayList;

public class Directory {
  //TODO: Complete JavaDocs and add comments
  
  private String fullPathName; // Need to implement this
  private String name;
  private Directory parentDirectory; // This is necessary to access parent directory using commands such as Cd, right?
  private ArrayList<Directory> listOfSubdirectories;
  private ArrayList<File> listOfFiles;
  
  public Directory(String name) {
    this.name = name;
    this.fullPathName = name + "/";
    this.parentDirectory = null;
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
  
  // Method to add a subdirectory to the list of subdirectories
  public void addSubdirectory(Directory subDirectory) {
    // Add helper function to scan list for names
    if (listOfSubdirectories.contains(subDirectory) ) { // Maybe use subDirectory.getName() if that's what is differentiating them, and also check listOfFiles since files and directories cannot have same name
      // Not sure if Directory class is responsible for printing this error?
      System.out.println("Error: Directory '" + subDirectory.getName() + "' already exists.");
      return;
    }
    subDirectory.setParentDirectory(this);
    listOfSubdirectories.add(subDirectory);
  }
  
//Method to remove a subdirectory to the list of subdirectories
 public void removeSubdirectory(Directory subDirectory) {
   if (!listOfSubdirectories.contains(subDirectory) ) {
     // Not sure if Directory class is responsible for printing this error?
     System.out.println("Error: Cannot remove '" + subDirectory.getName() + "': No such directory exists."); 
     return;
   }
   
   listOfSubdirectories.remove(subDirectory);
 }
  
  //Method to add a file to the list of files
  public void addFile(File file) {
    if (listOfFiles.contains(file) ) {
      System.out.println("Error: File '" + file.getName() + "' already exists.");
      return;
    }
    
    listOfFiles.add(file);
  }
  
  public void removeFile(File file) {
    if (!listOfFiles.contains(file) ) {
      // Not sure if Directory class is responsible for printing this error?
      System.out.println("Error: Cannot remove '" + file.getName() + "': No such file exists.");
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
      if (directoryName.equals(listOfSubdirectories.get(i).getName())) {
        return listOfSubdirectories.get(i);
      }
    }
    // Do I need to print an error message saying DIRECTORY NOT FOUND?
    return null;
  }
  
  public File findFile(String fileName) {
    for (int i=0; i<listOfFiles.size(); i++) {
      if (fileName.equals(listOfFiles.get(i).getName())) {
        return listOfFiles.get(i);
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
  
  public String getFullPathName() {
    return fullPathName;
  }
  
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
    // Update the directory's full path name using its parent directory
    this.fullPathName = parentDirectory.getFullPathName() + name + "/";
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
