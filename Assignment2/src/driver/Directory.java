package driver;

import java.util.ArrayList;

public class Directory {
  private String name;
  private ArrayList<Directory> listOfSubdirectories; // Use ArrayList
  private ArrayList<File> listOfFiles;
  
  public Directory(String name) {
    this.name = name;
    listOfSubdirectories = new ArrayList<Directory>();
    listOfFiles = new ArrayList<File>();
  }
}
