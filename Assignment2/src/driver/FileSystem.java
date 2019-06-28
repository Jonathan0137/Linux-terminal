package driver;

public class FileSystem {
  // Tracks information about the entire file system via the root Directory
  private Directory root;
  
  /**
   * Constructor for create a new FileSystem.
   */
  public FileSystem() {
    root = new Directory("");
  }

  /**
   * Returns the root directory of the FileSystem.
   * 
   * @return the FileSystem's root directory
   */
  public Directory getRootDirectory() {
    return root;
  }
  
  // For TESTING PURPOSES ONLY
  public static void main(String[] args) {
//    FileSystem fs = new FileSystem();
//    Directory root = fs.getRootDirectory();
//    
//    Directory subDir = new Directory("hello");
//    
//    root.addSubdirectory(subDir);
//    root = root.findDirectory("hello");
//    System.out.println(root.getFullPathName());
//    
//    Directory subSubDir = new Directory("world");
//    
//    root.addSubdirectory(subSubDir);
//    System.out.println(subSubDir.getFullPathName());
//    
//    Directory dirSearch = fs.getDirectory("/hello/world/");
//    
//    if (dirSearch != null) {
//      System.out.println(dirSearch.getName());
//    }
//    else {
//      System.out.println("Error, directory not found");
//    }

  }
  
  // Maybe need a FileSystemNode that is a parent class to Directory and File,
  // SO that I don't need to create class for finding each type 
}
