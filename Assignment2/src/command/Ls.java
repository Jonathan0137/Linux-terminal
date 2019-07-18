package command;

import java.util.ArrayList;
import java.util.Collections;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystemManipulation;
import fileSystem.FileSystemNode;
import output.Output;
  /**
   * Ls is a Command where it can print all the folders and files under
   * current working directory.
   * 
   * @author Chongmin Bai
   */
public class Ls extends Command {
  /**
   * Returns a String containing the documentation for the functionalities 
   * of the 'ls' command.
   * 
   * @return the documentation of the 'ls' command
   */
  @Override
  public String getDoc() {
    String documentation = "ls [PATH ...]"
        + "\n\tIf no paths are given, print the contents (file or directory) "
        + "of the current"
        + "\n\tdirectory, with a new line following each of the content "
        + "(file or directory)."
        + "\n\tOtherwise, for each path p, the order listed:"
        + "\n\t\tIf p specifies a file, print p"
        + "\n\t\tIf p specifies a directory, print p, a colon, then the "
        + "contents of that"
        + "\n\t\t\tdirectory, then an extra new line."
        + "\n\t\tIf p does not exist, print a suitable message.";

    return documentation;
  }

  /**
   * Print all the folders and files under the current working folder
   * 
   * 
   */
  @Override
  public void execute(ArrayList<Object> param){
    String input = (String) param.get(0);
    String[] userInput = input.split(" ");
    int numOfArg = userInput.length;
    Directory workingDir = fs.getCurrentDirectory();
    if(input.contains("> || >>"))
    {
      //redirect stuff
    }
    else
    {
      if(input.contains("-R"))
      {
        if(numOfArg == 2)
        {
          
        }
        else if(numOfArg == 3)
        {
          
        }
      }
      else
      {
        if (numOfArg == 1)
          printFilesAndDirectories(workingDir);
        else if (numOfArg == 2) 
        {
          printFileAndDir(workingDir, userInput[1]);
        }
      }
    }


  
  }
  private void printFileAndDir(Directory workingDir, String path)
  {
    Output output = Output.getOutputInstance();
    if (path.isEmpty() == true)
      printFilesAndDirectories(workingDir);
    else 
    {
      FileSystemNode subNode = FileSystemManipulation.findSubNode(workingDir, path);
      if (subNode instanceof Directory) 
      {
        System.out.println(path + " : ");
        Directory nextDir = (Directory) subNode;
        printFilesAndDirectories(nextDir);
        System.out.println();
      } 
      else if (subNode instanceof File) 
      {
        output.addUserOutput(path);
      } 
      else 
      {
        output.addErrorOutput("No such file or directory");
      }
    }
    
  }

  /**
   * A helper function that takes in an instance of an Directory and print 
   * any files and directories in it, in sorted order.
   * 
   * @param workingDir         Current working directory
   */
  private void printFilesAndDirectories(Directory workingDir) {
    Output output = Output.getOutputInstance();
    ArrayList<String> sortedList = new 
        ArrayList<String>(workingDir.getListOfFileSystemNodes().keySet());
    Collections.sort(sortedList);
    
    for (String name : sortedList) {
      output.addUserOutput(name);
    }
  }

}
