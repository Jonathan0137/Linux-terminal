package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.FileSystem;
import driver.JShell;

public abstract class Command 
//public interface Command
// change all other class to implement 
{

  protected String doc;
  /**
   * An Abstract class that will be used for children classes to implement
   * 
   * @param shell            an instance of the JShell that is interacting with the user
   * @param input            User input.
   */
  public abstract void execute(JShell shell, String input);
  
  /**
   * An Abstract class that will be used for children classes to implement
   * to print each command's docementation.
   * 
   * @return the documentation of each command.
   */
  protected abstract String getDoc();
  
  /**
   * Returns the directory in the file system with the given absolute path name
   * if it exists, otherwise returns null.
   * 
   * @param fs                  the file system in which the directory is being searched for
   * @param absolutePathName    the absolute path name of a directory in the file system
   * @return                    the directory with the given absolute path name
   */
  protected static Directory findDirectory(FileSystem fs, String absolutePathName) {
    Directory traversalDirectory = fs.getRootDirectory();
    String[] nameList = absolutePathName.split("/");
    
    for (int i=0; i<nameList.length; i++) {
      if (nameList[i].equals("")) {
        continue;
      }
      traversalDirectory = findSubdirectory(traversalDirectory, nameList[i]);
      if (traversalDirectory == null) {
        return null;
      }
    }
    return traversalDirectory;
  }
  
  /**
   * Returns the subdirectory with the given name if it exists, otherwise returns null.
   * 
   * @param parentDir  the parent directory in which the subdirectory is being searched for
   * @param subDirName the name of the wanted subdirectory
   * @return the subdirectory in parentDir with the name of subDirName
   */
  private static Directory findSubdirectory(Directory parentDir, String subDirName) {
    ArrayList<Directory> listOfSubdirectories = parentDir.getListOfSubdirectories();
    for (int i=0; i<listOfSubdirectories.size(); i++) {
      if (subDirName.equals(listOfSubdirectories.get(i).getName())) {
        return listOfSubdirectories.get(i);
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
  protected static String getAbsolutePath(String input, Directory workingDir) {
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
   * Returns a string that is the given pathName with the last directory removed.
   * In other words, returns the path name of the parent directory specified by pathName.
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
}
