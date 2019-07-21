package commandParameter;

import java.util.ArrayList;
import command.Command;
import driver.JShell;

public class CommandParameter {
  private ArrayList<Object> parameters;
  
  public CommandParameter(Command command, JShell shell, String input) {
    parameters = new ArrayList<Object>();
    String commandName = command.getClass().getSimpleName();  
    switch(commandName) {
      // Parameters: Input
      case "Cat":
      case "Cd": 
      case "Cp": 
      case "Echo": 
      case "Get": 
      case "History":
      case "Ls": 
      case "Man":
      case "Mkdir": 
      case "Mv":
        parameters.add(input);
        break;
      case "Save":  // Parameters: Input and DirectoryStack
      case "Pushd":
        parameters.add(input);
      case "Popd": // Parameters: DirectoryStack 
        parameters.add(shell.getDirectoryStack());
        break;
      case "Load": // Parameters: Input and JShell
        parameters.add(input);
      case "Exit": // Parameters: JShell
        parameters.add(shell);
      // All other commands require no input parameters
    }
  }
  
  public ArrayList<Object> getParameters() {
    return parameters;
  }
}
