package fileSystem;

import java.util.HashMap;
import output.Output;

/**
 * A static class containing methods related to manipulating and using 
 * the File System.
 *  
 * @author Gary Xie
 */
public final class FileSystemManipulation {
  
  /**
   * The instance of the file system.
   */
  private static FileSystem fs = FileSystem.getFileSystem();
  
  /**
   * Private constructor, since it does not make sense to instantiate
   * a FileSystemManipulation object.
   */
  private FileSystemManipulation() {};
  
  /**
   * Returns the node in the file system with the given absolute path name
   * if it exits, otherwise returns null.
   * 
   * @param absolutePathName    the absolute path name of a FileSystemNode
   * @return                    the node with the given absolute path name
   */
  public static FileSystemNode findFileSystemNode(String absolutePathName) {
    Directory traversalDirectory = fs.getRootDirectory();    
    String[] nameList = absolutePathName.split("/");
    if (nameList.length == 0) {
      return traversalDirectory;
    }
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
   * Returns the subnode with the given name if it exists, 
   * otherwise returns null.
   * 
   * @param parentDir  the directory to look in for the subnode
   * @param nodeName the name of the wanted subnode
   * @return the subnode in parentDir with the name of nodeName
   */
  public static FileSystemNode findSubNode(Directory parentDir, String nodeName) {
    HashMap<String, FileSystemNode> listOfFileSystemNodes = parentDir.
        getListOfFileSystemNodes();    
    for (String name : listOfFileSystemNodes.keySet()) {
      if (name.equals(nodeName)) {
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
  public static String moveToParentDirectory(String pathName) {
    
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
   * Adds a FileSystemNode into the specified directory.
   * 
   * @param parentDir   the directory the user is adding into
   * @param subNode  the node that is being added to parentDir
   */
 public static void addFileSystemNode(Directory parentDir, FileSystemNode subNode) {   
     Output output = Output.getOutputInstance();
     HashMap<String, FileSystemNode> listOfNodes = parentDir.getListOfFileSystemNodes();
     
     if (listOfNodes.containsKey(subNode.getName())) {
         output.addErrorOutput("The name '"+subNode.getName()
                               +"' already exists in this directory.");
         return;
     }
     subNode.setParentDirectory(parentDir);
     listOfNodes.put(subNode.getName(), subNode);
 }
}
