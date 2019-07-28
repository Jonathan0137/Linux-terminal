package command;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import inputHistory.InputHistory;
import fileSystem.DirectoryStack;
import driver.JShell;
import fileSystem.FileSystem;

/**
 * Provides functionality for the 'load' command,
 * allowing the user to load the FileSystem, DirectoryStack,
 * and InputHistory state from a previously saved file.
 * 
 * @author Gary Xie
 */
public class Load extends Command {
  
  /**
   * The instance of the user's input history.
   */
  private InputHistory history;
  
  /**
   * Returns a String containing the documentation for 
   * the functionalities of the 'load' command.
   * 
   * @return the documentation of the 'load' command
   */
  @Override
  protected String getDoc() {
    String documentation = "load: load FILE\n\tLoad the contents "
        + "of FILE and update the current shell's state to the state "
        + "\n\tsaved in FILE, if FILE exists and stores information "
        + "about console state. \n\tLoad must be the first command "
        + "called in a new console.\n\n\tIf FILE's path is not specified, "
        + "the default location to \n\tsearch for FILE is the folder Assignmnent2.";
    return documentation;
  }
  
  
  /**
   * Load the contents of a file containing a previously saved console state,
   * and update the FileSystem, DirectoryStack, and InputHistory to this state.
   * Load can only be run if it is the first command called in a new console.
   * 
   * @param param the list of required parameters to successfully execute Load
   */
  @Override
  public void execute(ArrayList<Object> param) {
    history = InputHistory.getInputHistory();
    if (history.getInputList().size() != 1) {
      output.addErrorOutput("Cannot execute load. load must "
          + "the first command called in a new shell to be executed.");
      return;
    }
    String input = (String) param.get(0);
    String[] inputSplit = input.split(" ", 2);
    String fileName = inputSplit[1].trim();
    JShell shell = (JShell) param.get(1);
    
    try {
      FileInputStream fileIn = new FileInputStream(new File(fileName));
      ObjectInputStream objIn = new ObjectInputStream(fileIn);
      
      fs.setFileSystem((FileSystem) objIn.readObject()); // Reflection to not break Singleton
      shell.setDirectoryStack((DirectoryStack) objIn.readObject());
      history.setInputHistory((InputHistory) objIn.readObject());
      history = InputHistory.getInputHistory();
      history.addToHistory(input);
      objIn.close();
      fileIn.close();
    } catch(FileNotFoundException e) {
        output.addErrorOutput("File not found.");
    } catch(IOException e) {
        output.addErrorOutput("Cannot load data from specified file.");
    } catch(Exception e) {
        output.addErrorOutput("Load failed to execute.");
    }  
  }
}
