package driver;

public class File {
  private String name; // Name of file
  private String contents; // Text contents of the file
  
  public File(String name) {
    this.name = name;
    this.contents = "";
  }
  
  public File(String name, String contents) {
    this.name = name;
    this.contents = contents;
  }
}
