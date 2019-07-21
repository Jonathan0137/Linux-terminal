package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystemManipulation;
import fileSystem.FileSystemNode;
import output.Output;

/**
 * Tree is an Command that displays every file and directory in the file 
 * system to the user as a tree
 * 
 * @author Chongmin Bai
 */
public class Tree extends Command
{
  /**
   * Returns a String containing the documentation for the functionalities 
   * of the 'ls' command.
   * 
   * @return the documentation of the 'Tree' command
   */
  @Override
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
  /**
   * Displays every file and directory in the file 
   * system to the user as a tree
   * 
   * @param param   An instance of ArraryList with its type being unknown.
   *                It could be any type base on what Jshell gives.
   */
  @Override
  public void execute (ArrayList<Object> param)
  {
    Directory traversalDirectory = fs.getRootDirectory();
    Output output = Output.getOutputInstance();
    output.addUserOutput("\\");
    printTree("", traversalDirectory);
  }
  /**
   * An private helper method that is used for recursion to print the name 
   * of each of the file and directory in fileSystem. If the node is an 
   * directory then the method would go deeper into that Directory and do the
   * same.
   * 
   * @param space   an instance of String that is used for printing to output
   * @param node    an instance of FileSystemNode that keeps track of current
   *                position in the FileSystem
   */
  private static void printTree(String space, FileSystemNode node)
  {
    
    if(node != null)
    {
      Output output = Output.getOutputInstance();
      if(node instanceof Directory)
      { 
        if(node.getName().equals("")==false)
        {
          output.addUserOutput(space + node.getName());
        } 
        Directory dir = (Directory) node;
        for(String key : dir.getListOfFileSystemNodes().keySet())
        {
         
          printTree(space + "  ", FileSystemManipulation.findSubNode(dir, key));
        }
      }
      else if(node instanceof File)
      {
        output.addUserOutput(space + node.getName());
      }
      
    }
    
  }
}
