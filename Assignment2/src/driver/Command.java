package driver;

import java.util.ArrayList;

public abstract class Command 
//public interface Command
// change all other class to implement 
{

  protected String doc;
  public abstract void execute(JShell shell, String input);
  
  protected abstract String getDoc();
  
  /**
   * Returns the directory in the file system with the given absolute path name
   * if it exists, otherwise returns null.
   * 
   * @param fs                  the file system in which the directory is being searched for
   * @param absolutePathName    the absolute path name of a directory in the file system
   * @return                    the directory with the given absolute path name
   */
  public static Directory findDirectory(FileSystem fs, String absolutePathName) {
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
}
