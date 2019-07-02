package driver;

import java.util.ArrayList;

public class Ls extends Command {
  /**
   * Returns a String containing the documentation for the functionalities of the 'ls' command.
   * 
   * @return the documentation of the 'ls' command
   */
  @Override
  public String getDoc() {
    String documentation = "ls [PATH ...]"
        + "\n\tIf no paths are given, print the contents (file or directory) of the current"
        + "\n\tdirectory, with a new line following each of the content (file or directory)."
        + "\n\tOtherwise, for each path p, the order listed:"
        + "\n\t\tIf p specifies a file, print p"
        + "\n\t\tIf p specifies a directory, print p, a colon, then the contents of that"
        + "\n\t\t\tdirectory, then an extra new line."
        + "\n\t\tIf p does not exist, print a suitable message.";

    return documentation;
  }

  /**
   * print all the folders and files under current working folder
   * 
   * @param shell an instance of the JShell that is interacting with the user
   * @param input a relative or absolute path name
   */
  @Override
  public void execute(JShell shell, String input) {
    input = input.replaceAll(" +", " ");
    String[] userInput = input.split(" ", 2);
    int numOfArg = userInput.length;
    Directory workingDir = shell.getCurrentDirectory();
    if (numOfArg == 1)
      printFilesAndDirectories(workingDir);
    else if (numOfArg == 2) {
      if (userInput[1].isEmpty() == true)
        printFilesAndDirectories(workingDir);
      else {
        if (Ls.findDirectory(userInput[1], workingDir) != null) {
          System.out.println(userInput[1] + " : ");
          Directory nextDir = Ls.findDirectory(userInput[1], workingDir);
          printFilesAndDirectories(nextDir);
          System.out.println();
        } else if (Ls.findFile(userInput[1], workingDir) != null) {
          System.out.println(userInput[1]);
        } else {
          System.out.println("No such file or directory");
        }
      }
    }
  }

  /**
   * A helper function that takes in an instance of an Direcotry and print any files and folders
   * under it.
   * 
   * @param workingDir Current working direcotry
   */
  private void printFilesAndDirectories(Directory workingDir) {
    for (File file : workingDir.getListOfFiles()) {
      System.out.println(file.getName());
    }
    for (Directory dir : workingDir.getListOfSubdirectories()) {
      System.out.println(dir.getName());
    }
  }

  /**
   * A helper function that takes in the file name and find that file in current working folder and
   * return it.
   * 
   * @param fileName The name of the file that you want to find
   * @param currentWorkingDir A directory class variable that represents the current folder
   * @return A instance of File that is under the current directory, if not found then return null
   */
  private static File findFile(String fileName, Directory currentWorkingDir) {
    ArrayList<File> listOfFiles = currentWorkingDir.getListOfFiles();

    for (int i = 0; i < listOfFiles.size(); i++) {
      if (fileName.equals(listOfFiles.get(i).getName())) {
        return listOfFiles.get(i);
      }
    }
    return null;
  }

  /**
   * A helper function that takes in the directory name and find that directory in current working
   * folder and return it.
   * 
   * @param directoryName The name of the directory that you want to find
   * @param currentWorkingDir A directory class variable that represents the current folder
   * @return A instance of Directory that is under the current directory, if not found then return
   *         null
   */
  private static Directory findDirectory(String directoryName, Directory currentWorkingDir) {

    ArrayList<Directory> listOfSubdirectories = currentWorkingDir.getListOfSubdirectories();
    for (int i = 0; i < listOfSubdirectories.size(); i++) {
      if (directoryName.equals(listOfSubdirectories.get(i).getName())) {
        return listOfSubdirectories.get(i);
      }
    }
    return null;
  }


}
