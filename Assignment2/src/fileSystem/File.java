package fileSystem;

/**
 * Contains information about a file
 * and its contents.
 * 
 * @author Gary Xie
 */
public class File extends FileSystemNode { 

  /**
   * Text contents of the File
   */
  private String contents;
  
  /**
   * Constructor for File, with no content inside.
   * 
   * @param name    the name of the file
   */
  public File(String name) {
    super(name);
    this.contents = "";
  }
  
  /**
   * Constructor for File, with the given contents.
   * 
   * @param name        the name of the file
   * @param contents    the contents of the file
   */
  public File(String name, String contents) {
    super(name);
    this.contents = contents;
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
  

}
