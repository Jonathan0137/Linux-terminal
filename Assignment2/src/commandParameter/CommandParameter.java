package commandParameter;

import java.util.ArrayList;
import command.Command;
import driver.JShell;

/**
 * Determines the required parameters for a given command.
 * 
 * @author Gary Xie
 */
public class CommandParameter {
  /**
   * The list of parameters to be given to the command execute.
   */
  private ArrayList<Object> parameters;
  
  /**
   * Constructor for CommandParameter, which determines the required parameters
   * depending on the specified command.
   * 
   * @param command the command being called by the user
   * @param shell   the instance of the current shell
   * @param input   the input from the user
   */
  public CommandParameter(Command command, JShell shell, String input) {
    parameters = new ArrayList<Object>();
    String commandName = command.getClass().getSimpleName();  
    switch(commandName) {
      // Parameters: Input
      case "Cat":
      case "Cd": 
      case "Cp": 
      case "Echo": 
      case "Find":
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
  
  /**
   * Return a list of parameters that are required 
   * for a given command.
   * 
   * @return the list of required parameters for the command
   */
  public ArrayList<Object> getParameters() {
    return parameters;
  }
}
