package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.FileSystemManipulation;
import output.Output;

public class Tree extends Command
{
  public String getDoc()
  {
    return "\t\tCommand: Tree"
        + "\tThe Tree Command start from the root directory \n"
        + "\tdisplay the entire file system as a tree. \n"
        + "\tFor every level of the tree, there is an "
        + "\tindent by a tab character\n\n"
        + "\tExample: \root\n"
        + "\t\tdocement\n"
        + "\t\t\tsome_file.txt\n"
        + "\t\tDownload\n";
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
