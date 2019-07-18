package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.FileSystemManipulation;
import output.Output;

public class Tree extends Command
{
  public String getDoc()
  {
    return "some doc";
  }
  public void execute (ArrayList<Object> param)
  {
    Directory traversalDirectory = fs.getRootDirectory();
    printTree("", traversalDirectory);
  }
  
  private static void printTree(String space, Directory node)
  {
    if(node != null)
    {
      Output output = Output.getOutputInstance();
      
      output.addUserOutput(space + node.getName());
      
      
      for(String key : node.getListOfFileSystemNodes().keySet())
      {
        printTree("\t", (Directory) FileSystemManipulation.findSubNode(node, key));
      }
    }
  }
}
