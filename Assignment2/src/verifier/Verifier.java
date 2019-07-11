package verifier;

import java.util.Hashtable;
import command.*;
/**
 * Verifier is a class that checks if user inputs follow the given style
 * and their command exists. If not, it will not process the user's command.
 * 
 * @author Chongmin Bai
 */
public class Verifier {
  /**
   * Check if user's command exists or not, if exist then return 
   * an instance of that command, if not, return null.
   * 
   * @param userInput     a string that contains what user has typed
   * @return              an instance of command of user's selected commands
   */


  public static Command checkUserInputCommand(String userInput)  
  {
    if (userInput == "")
      return null;
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ", 2);
    String command = input[0];
    Hashtable<String, Command> hashtable = new Hashtable<String, Command> (); 
    initializeHashTableWithUserInput(hashtable);
    if(hashtable.containsKey(command))
    {
      return hashtable.get(command);
    }
    else
    {
      System.out.println("Command " + command + " does not exist, Please try again");
      return null;
    }
  }
  private static void initializeHashTableWithUserInput(Hashtable<String, Command> hashtable)
  {
    hashtable.put("cd", new Cd());
    hashtable.put("exit", new Exit());
    hashtable.put("mkdir", new Mkdir());
    hashtable.put("ls", new Ls());
    hashtable.put("pwd", new Pwd());
    //hashtable.put("mv", new Mv());
    //hashtable.put("cp", new Cp());
    hashtable.put("cat", new Cat());
    //hashtable.put("get", new Get());
    //hashtable.put("echo", new Echo());
    hashtable.put("man", new Man());
    hashtable.put("pushd", new Pushd());
    hashtable.put("popd", new Popd());
    hashtable.put("history", new History());
//    hashtable.put("load", new Load());
//    hashtable.put("find", new Find());
//    hashtable.put("tree", new Tree());    
  }
  
  /**
   * Check if user input has the correct number of arguments. 
   * if not return false, else return true.
   * 
   * @param userInput      a string that contains what user has typed
   * @return               return true if user enters correct, else false
   */
  public boolean checkUserInput(String userInput)
  {

    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ", 2);
   // int numOfArg = input.length;    
    String command = input[0];
    Hashtable<String, String> hashtable = new Hashtable<String, String> (); 
    initializeHashTableWithInputLimit(hashtable);
//    if(numOfArg!=1)
//    {
      return userInput.matches(hashtable.get(command));
//    }
//    else// num of Arg == 1
//    {
//      if(command.equals("pwd")||command.equals("exit")||command.equals("history")||command.equals("cd"))
//        return true;
//      else
//      {
//        System.out.println("bash: "+ command + ": not enought arguments");
//        return false;
//      }
//     
//    }

  }
  private static void initializeHashTableWithInputLimit(Hashtable<String, String> hashtable)
  { 
    hashtable.put("cd", "^(\\c)(\\d)({2}\\s)"); // true
    hashtable.put("ls", ""); // ls can be ls or ls Path or ls -R path
  } 
}


















