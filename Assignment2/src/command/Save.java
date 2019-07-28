package command;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import inputHistory.InputHistory;
import fileSystem.DirectoryStack;

public class Save extends Command {
  
  private InputHistory history;
  
  @Override
  public void execute(ArrayList<Object> param) {
    history = InputHistory.getInputHistory();
    String input = (String) param.get(0);
    String[] inputSplit = input.split(" ", 2);
    String fileName = inputSplit[1].trim();
    DirectoryStack dirStack = (DirectoryStack) param.get(1);
    
    try {
      FileOutputStream fileOut = new FileOutputStream(new File(fileName));
      ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
      
      objOut.writeObject(fs);
      objOut.writeObject(dirStack);
      objOut.writeObject(history);
      
      objOut.close();
      fileOut.close();    
    } catch(FileNotFoundException e) {
        output.addErrorOutput("Invalid file path or name.");
    } catch(IOException e) {
        output.addErrorOutput("Cannot save data to specified file.");
    } catch(Exception e) {
        output.addErrorOutput("Save failed to execute.");
    }  
    
    
    
  }

  @Override
  protected String getDoc() {
    String documentation = "save: save FILE\n\tSave the current state of the shell to FILE, "
        + "on the user's \n\tcomputer file system. This allows the user to close the "
        + "\n\tshell and reopen it later in the same state.\n\n\tIf FILE's path "
        + "is not specified, the default location to \n\tsave FILE is the folder Assignment2.";
    return documentation;
  }
  

}
