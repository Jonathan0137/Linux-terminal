package driver;

import java.util.ArrayList;

public class Ls extends Command
{
  @Override
  public String getDoc() {
    String documentation = 
        "ls [PATH ...]"
        + "\n\tIf no paths are given, print the contents (file or directory) of the current"
        + "\n\tdirectory, with a new line following each of the content (file or directory)."
        + "\n\tOtherwise, for each path p, the order listed:"
        + "\n\t\tIf p specifies a file, print p"
        + "\n\t\tIf p specifies a directory, print p, a colon, then the contents of that"
        + "\n\t\t\tdirectory, then an extra new line."
        + "\n\t\tIf p does not exist, print a suitable message.";

    return documentation;
  }
  public void execute(JShell shell, String input) 
  {
    input = input.replaceAll(" +", " ");
    String[] userInput = input.split(" ", 2);
    int numOfArg = userInput.length;
    Directory workingDir = shell.getCurrentDirectory();
    if(numOfArg == 1)
    {
      
      for(File file  : workingDir.getListOfFiles())
      {
        System.out.println(file.getName());
      }
      for(Directory dir : workingDir.getListOfSubdirectories())
      {
        System.out.println(dir.getName());
      }
    }
    else if(numOfArg == 2)
    {
      if(userInput[1].isEmpty()==true)
      {
      
        for(File file  : workingDir.getListOfFiles())
        {
          System.out.println(file.getName());
        }
        for(Directory dir : workingDir.getListOfSubdirectories())
        {
          System.out.println(dir.getName());
        }
      }
      else
      {
        if(Ls.findDirectory(userInput[1], workingDir)!=null)
        {
          //userinput[1] is a folder, then print p, a colon, then the contents of that
          //directory, then an extra new line.
          //************************************************Ask abbas for format*****************/
          System.out.println(userInput[1] + " : ");
          Directory nextDir = Ls.findDirectory(userInput[1], workingDir);
          
          for(File file  : nextDir.getListOfFiles())
          {
            System.out.println(file.getName());
          }
          for(Directory dir : nextDir.getListOfSubdirectories())
          {
            System.out.println(dir.getName());
          }
          System.out.println();
        }
        else if(Ls.findFile(userInput[1], workingDir)!=null)
        {
         //userinput[1] is a File, then print userInput[1]
          System.out.println(userInput[1]);
        }
        else
        {
          //userinput[1] is invalid.
          System.out.println("No such file or directory");
        }
      }
    }
  }
  private static File findFile(String fileName, Directory currentWorkingDir) 
  {
    ArrayList<File> listOfFiles = currentWorkingDir.getListOfFiles();

    for (int i=0; i<listOfFiles.size(); i++) 
    {
        if (fileName.equals(listOfFiles.get(i).getName())) 
        {
          return listOfFiles.get(i);
        }
    }
    return null;
  }
  
  private static Directory findDirectory(String directoryName, Directory currentWorkingDir) 
  {
    
    ArrayList<Directory> listOfSubdirectories = currentWorkingDir.getListOfSubdirectories();
    for (int i=0; i<listOfSubdirectories.size(); i++) 
    {
      if (directoryName.equals(listOfSubdirectories.get(i).getName())) 
      {
        return listOfSubdirectories.get(i);
      }
    }
    return null;
  }
  
  
}
