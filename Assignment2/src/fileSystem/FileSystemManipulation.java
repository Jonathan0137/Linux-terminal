package fileSystem;

import java.util.HashMap;

// TODO: UPDATE Javadocs (for all my classes)

/**
 * A static class containing methods related to manipulating and using 
 * the File System.
 *  
 * @author Gary Xie
 */
public final class FileSystemManipulation {
  
  private static FileSystem fs = FileSystem.getFileSystem();
  
  private FileSystemManipulation() {};
  
  /**
   * Returns the directory in the file system with the given absolute path name
   * if it exists, otherwise returns null.
   * 
   * @param fs the file system in which the directory is being searched for
   * @param absolutePathName the absolute path name of a directory
   * @return the directory with the given absolute path name
   */
  public static FileSystemNode findFileSystemNode(String absolutePathName) {
    Directory traversalDirectory = fs.getRootDirectory();
    String[] nameList = absolutePathName.split("/");
    
    for (int i=0; i<nameList.length - 1; i++) {
      if (nameList[i].equals("")) {
        continue;
      }
      FileSystemNode node = findSubNode(traversalDirectory, nameList[i]);
      if (! (node instanceof Directory)) {
        return null;
      }
      traversalDirectory = (Directory) node;
    }
    
    FileSystemNode targetNode = findSubNode(traversalDirectory,
        nameList[nameList.length-1]);
    return targetNode;
  }
  
  /**
   * Returns the subdirectory with the given name if it exists, 
   * otherwise returns null.
   * 
   * @param parentDir  the directory to look in for the subdirectory
   * @param subDirName the name of the wanted subdirectory
   * @return the subdirectory in parentDir with the name of subDirName
   */
  public static FileSystemNode findSubNode(Directory parentDir, 
      String nodeName) {
    HashMap<String, FileSystemNode> listOfFileSystemNodes = parentDir.
        getListOfFileSystemNodes();
    
    for (String name : listOfFileSystemNodes.keySet()) {
      if (name == nodeName) {
        return listOfFileSystemNodes.get(name);
      }
    }   
    return null;
  }
  
  /**
   * Returns a String that is the absolute path version of the input, which
   * could be an absolute or a relative path to the workingDir.
   * 
   * @param input       a relative or absolute path name
   * @param workingDir  the current working directory
   * @return            the absolute path version of the given input path name
   */
  public static String getAbsolutePath(String input, Directory workingDir) {
      String[] pathList = input.split("/");
      
      String fullPathName = workingDir.getFullPathName();
      
      for (int i=0; i<pathList.length; i++) {
        if (pathList[i].equals(".") || pathList[i].equals("")) {
          continue;
        }
        else if (pathList[i].equals("..")) {
          fullPathName = moveToParentDirectory(fullPathName);
        }
        else {
          fullPathName = fullPathName + pathList[i] + "/";
        }
      }
      
      return fullPathName;
  }
  
  /**
   * Returns a string that is the given pathName with the last 
   * directory removed. In other words, returns the path name of the 
   * parent directory specified by pathName.
   * If the pathName is the root directory's path, then returns pathName.
   * 
   * @param pathName a relative or absolute path name
   * @return         the parent directory's path name
   */
  private static String moveToParentDirectory(String pathName) {
    
    if (pathName.equals("/")) {
      return pathName;
    }
    
    String newPathName = pathName;
    
    if (newPathName.charAt(newPathName.length() - 1) == '/') {
      newPathName = newPathName.substring(0, newPathName.length() - 1);
    }
    
    for (int i = newPathName.length() - 1; i>=0; i--) {
      if (newPathName.charAt(i) == '/') {
        break;
      }      
      newPathName = newPathName.substring(0, i);
    } 
    return newPathName;
  }
  
  /**
   * Adds the subdirectory into the parent directory
   * 
   * @param parentDir   the directory the user is adding into
   * @param subDir   the directory that is being added by the user
   */
 public static void addSubdirectory(Directory parentDir, Directory subDir) {   
     HashMap<String, FileSystemNode> listOfNodes = parentDir.getListOfFileSystemNodes();
     
     if (listOfNodes.containsKey(subDir.getName())) {
         System.out.println("The name '"+subDir.getName()+"' already exists in this directory.");
         return;
     }
     subDir.setParentDirectory(parentDir);
     listOfNodes.put(subDir.getName(), subDir);
 }
}
