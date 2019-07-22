package command;

import java.util.ArrayList;
import output.Output;
import java.util.Hashtable;
/**
 * Man is a Command where it can print the previously stored documentation
 * for each command base on which command user wants to see.
 * 
 * @author Chongmin Bai
 */
public class Man extends Command
{
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'man' command.
   * 
   * @return the documentation of the 'man' command
   */
  @Override
  public String getDoc() {
    String documentation = "\t\tMan: man CMD\n"
                         + "\tPrint Print documentation for CMD.\n"
                         + "\tCMD means commands that we use.\n"
                         + "\tExample: man cat \n"
                         + "\tList of all commands\n\n"
                         + "\texit  mkdir   cd      ls    pwd\n"
                         + "\tpushd popd    history cat   echo man \n";
    return documentation;
  }
  /**
   * Print documentation of selected commands
   * 
   * @param param       The list of required parameters to successfully 
   *                    execute command requested command.
   */
  @Override
  public void execute(ArrayList<Object> param)
  {
    Output output = Output.getOutputInstance();
    String input = (String) param.get(0);
    String[] userInput = input.split(" ", 2);
    String command = userInput[1];
    Hashtable<String, String> hashtable = new Hashtable<String, String> (); 
    initializeHashTableWithGetDoc(hashtable);
    if(hashtable.containsKey(command))
    {
      output.addUserOutput(hashtable.get(command));
    }
    else
    {
      output.addErrorOutput("No such CMD exist, check man man for "
          + "more information");
    }    
  }
  /**
   * An private helper method that stores an hashtable with name of the 
   * commands as keys and a String that represents the docemsentations 
   * of that command. 
   * 
   * @param hashtable  An instance of hashtable with a string as key and 
   *                   String as value
   */
  private static void initializeHashTableWithGetDoc(Hashtable<String, String> hashtable)
  {
      hashtable.put("cd", (new Cd()).getDoc());
      hashtable.put("exit", (new Exit()).getDoc());
      hashtable.put("mkdir", (new Mkdir()).getDoc());
      hashtable.put("ls", (new Ls()).getDoc());
      hashtable.put("pwd", (new Pwd()).getDoc());
      hashtable.put("mv", (new Mv()).getDoc());
      //hashtable.put("cp", (new Cp()).getDoc());
      hashtable.put("cat", (new Cat()).getDoc());
      hashtable.put("get", (new Get()).getDoc());
      hashtable.put("echo", (new Echo()).getDoc());
      hashtable.put("man", (new Man()).getDoc());
      hashtable.put("pushd", (new Pushd()).getDoc());
      hashtable.put("popd", (new Popd()).getDoc());
      hashtable.put("history", (new History()).getDoc());
      hashtable.put("save", (new Save()).getDoc());
      hashtable.put("load", (new Load()).getDoc());
      //hashtable.put("find", (new Find()).getDoc());
      hashtable.put("tree", (new Tree()).getDoc());    
    
  }
 
}
