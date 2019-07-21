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
    // TODO Auto-generated method stub
    return null;
  }
  

}
