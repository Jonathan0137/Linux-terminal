package driver;

public class FileSystem {
  // TODO: Complete JavaDocs and add comments
  
  
  // Tracks information about the entire file system via the root Directory
  private Directory root;
  
  public FileSystem() {
    root = new Directory("");
  }
  
  // Not sure if there will ever be this case: it is unsafe since if root is changed, then we lose FileSystem
  public FileSystem(Directory root) {
    this.root = root;
  }
  
  public Directory getDirectory(String fullPathName) //find direc
  {
    Directory traversalDirectory = root;
    String[] nameList = fullPathName.split("/");
    
    for (int i=0; i<nameList.length; i++) {
      // Bug with String.split that includes an empty string if you start path name with "/"
      if (nameList[i].equals("")) {
        continue;
      }
      traversalDirectory = traversalDirectory.findDirectory(nameList[i]);
      if (traversalDirectory == null) {
        return null;
      }
    }
    return traversalDirectory;
  }

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
