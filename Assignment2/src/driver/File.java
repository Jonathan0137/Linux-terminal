package driver;

public class File {
  private String name; // Name of file
  private String contents; // Text contents of the file
  private Directory parentDirectory; // Is this necessary? To know which directory this file is in?
  
  public File(String name) {
    this.name = name;
    this.contents = "";
  }
  
  public File(String name, String contents) {
    this.name = name;
    this.contents = contents;
  }
  
  // TODO:
  // Method to get/set name
  // Method to get/set contents
  // Method to get/set parentDirectory
  
  // Do I need functions for set/get name, set/get/append contents? Yes
  // What about distinction between set and append contents? Or should this distinction be in EchoToFile?
}
