package command;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import inputHistory.InputHistory;
import fileSystem.DirectoryStack;
import driver.JShell;
import fileSystem.FileSystem;

public class Load extends Command {
  
  private InputHistory history;
  @Override
  public void execute(ArrayList<Object> param) {
    history = InputHistory.getInputHistory();
    
    if (history.getInputList().size() != 1) {
      // Print an error message saying that the user cannot call load since it is not the first
      // command called in a new console
      return;
    }
    String input = (String) param.get(0);
    String[] inputSplit = input.split(" ", 2);
    String fileName = inputSplit[1].trim();
    JShell shell = (JShell) param.get(1);
    
    try {
      FileInputStream fileIn = new FileInputStream(new File(fileName));
      ObjectInputStream objIn = new ObjectInputStream(fileIn);
      
      fs.setFileSystem((FileSystem) objIn.readObject());
      shell.setDirectoryStack((DirectoryStack) objIn.readObject()); // Need a setDirectoryStack
      history.setInputHistory((InputHistory) objIn.readObject()); // Need a setInputHistory method
      
      objIn.close();
      fileIn.close();
      
      
    } catch(Exception e) { //Specify type of exception
      // Send Error Message
      output.addErrorOutput("Load exit due to error.");
    }  
  }

  @Override
  protected String getDoc() {
    // TODO Auto-generated method stub
    return null;
  }
  

}
