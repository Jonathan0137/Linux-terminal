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
    if(Verifier.checkUserInputCommand(userInput)!=null)
    {
      userInput = userInput.replaceAll(" +", " ");
      String[] input = userInput.split(" ", 2); 
      String command = input[0];
      Hashtable<String, String> hashtable = new Hashtable<String, String> (); 
      initializeHashTableWithInputLimit(hashtable);

      boolean tOrF = userInput.matches(hashtable.get(command));
      if(tOrF==false)
      {
        System.out.println("Verifier: "+ command + ": invalid inputs");
      }
      return tOrF;
    }
    return false;
  }
  private static void initializeHashTableWithInputLimit(Hashtable<String, String> hashtable)
  { 
    hashtable.put("exit", "exit"); //dont have redirect
    hashtable.put("mkdir", "mkdir(\\s((\\/){0,1}(\\w+|\\.{0,2})(\\/){0,1})+)+");  //mkdir Dir...// 
    hashtable.put("cd", "cd(\\s((\\/){0,1}(\\w+|\\.{0,2})(\\/){0,1})+){0,1}");  //cd Dir  // didnot add redirect
   
    
    
    
    
    
    hashtable.put("ls", "ls(\\s\\-R){0,1}(\\s((\\/){0,1}(\\w+||\\.{0,2})(\\/){0,1})+){0,1}");  //ls[-R][PATH..] 
   
    
    
    
    
    
    
    
    
    
    
    hashtable.put("pwd", "pwd"); 
    hashtable.put("mv", "mv\\s(\\/\\w+)*(.[\\w]+){0,1}\\s(\\/\\w+)*(.[\\w]+){0,1}"); //mv OLDPATH NEWPATH //OLD AND NEW PATH CAN BE DIR OR FILE
    hashtable.put("cp", "cp\\s(\\/\\w+)*(.[\\w]+){0,1}\\s(\\/\\w+)*(.[\\w]+){0,1}"); //cp OLDPATH NEWPATH
    hashtable.put("cat", "cat(\\s(\\w||\\/)+\\.\\w+)+"); //cat File...
//    hashtable.put("get", "get http://"); //get URL
    hashtable.put("echo", "echo\\s[\\w\\W]+"); //echo String
    hashtable.put("man", "man\\\\s(man||ls||cd||exit||mkdir||||pwd||mv||cp"
        + "||cat||get||echo||pushd||popd||history||save||load||find||tree)");  // man CMD
    hashtable.put("pushd", "pushd\\s(\\/\\w+)+");  // pushd Dir
    hashtable.put("popd", "popd");
    hashtable.put("history", "history(\\s\\d+){0,1}"); //history [number]
    hashtable.put("save", "save\\s(\\w||\\/)+\\.\\w+"); //save FileName
    hashtable.put("load", "load\\s(\\w||\\/)+\\.\\w+"); //load FileName
    hashtable.put("find", ""); //idk
    hashtable.put("tree", "tree"); 
  } 
}


















