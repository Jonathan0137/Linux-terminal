package command;

import java.util.ArrayList;
import java.util.Map;
import fileSystem.Directory;
import fileSystem.FileSystemManipulation;


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
      if(node == null)
      {
        
      }
      System.out.println(space + node.getName());
      
      
      for(String key : node.getListOfFileSystemNodes().keySet())
      {
        printTree("\t", FileSystemManipulation.findSubNode(traversalDirectory, key));
      }
  }
}
