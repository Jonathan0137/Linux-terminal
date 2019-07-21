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

public class Load extends Command {
  
  private InputHistory history;
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
      
      fs.setFileSystem((FileSystem) objIn.readObject());
      shell.setDirectoryStack((DirectoryStack) objIn.readObject());
      history.setInputHistory((InputHistory) objIn.readObject());
      
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

  @Override
  protected String getDoc() {
    // TODO Auto-generated method stub
    return null;
  }
  

}
