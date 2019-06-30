package driver;

//import java.util.Arrays;

public class Verifier 
{
  /**
   * Check if user's command exist or not, if exist then return a 
   * instance of that command, if not, return null.
   * 
   * @param userInput   a string that contains what user has typed
   * @return            a instance of command of user's selected commands
   */
  
  public static Command checkUserInputCommand(String userInput)
  {
    if(userInput == "")
      return null;
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ", 2);
    String command = input[0];
    switch(command)
    {
      case "cd":
        return new Cd();
      case "mkdir":
        return new Mkdir();
      case "pwd":
        return new Pwd();
      case "pushd":
        return new Pushd();
      case "history":
        return new History();
      case "ls":
        return new Ls();
      case "exit":
        return new Exit();
      case "popd":
        return new Popd();
      case "cat":
        return new Cat();
      case "echo":
        if(userInput.contains(">"))
          return new EchoToFile();
        else
          return new EchoToOutput();
      case "man":
        return new Man();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }
  }
  /**
   * Check if user input has the correct number of arguments.
   * if not return false, else return true.
   * 
   * @param userInput   a string that contains what user has typed
   * @return            true if user enters correct, else false
   */
  public boolean checkUserInput(String userInput)   
  {
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ");
    int numOfArg = input.length;
    String command=input[0];

    if(command.equals("exit") && numOfArg > 1)
    {
      System.out.println("bash exit: too many arguments");
      return false;
    }
    else if(command.equals("mkdir") && numOfArg == 1)
    {
      System.out.println("bash mkdir: missing directory");
      return false;
    }
    else if(command.equals("cd") && numOfArg > 2)
    {
      System.out.println("bash cd: too many arguments");
      return false;
    }
    else if(command.equals("cd") && numOfArg == 1)
    {
      System.out.println("bash cd: not enought arguments");
      return false;
    }
    // ls can have anynumer
    else if(command.equals("pwd") && numOfArg > 1)
    {
      System.out.println("bash pwd: too many arguments");
      return false;
    }
    else if(command.equals("pushd") && numOfArg > 2)
    {
      System.out.println("bash pushd: too many arguments");
      return false;
    } 
    else if(command.equals("pushd") && numOfArg == 1)
    {
      System.out.println("bash: pushd: no other directory");
      return false;
    } 
    else if(command.equals("history") && numOfArg > 2)
    { 
      System.out.println("bash: history: too many arguments");
      return false;
    } 
    else if(command.equals("cat") && numOfArg == 1)
    {
      System.out.println("bash: cat: not enought arguments");
      return false;
    }
    else if(command.equals("man") && numOfArg == 1)
    {
      System.out.println("What manual page do you want?");
      return false;
    } 
    else if(command.equals("man") && numOfArg > 2)
    {
      System.out.println("bash: man: too many arguments");
      return false;
    }   
    else if(command.equals("echo"))
    {
      if(numOfArg==1 || numOfArg == 3)
      {
        System.out.println("bash: echo: invalid entry");
        return false;
      }
      return true;
    }
    else
    {
      return true;
    }
  
  }
 
}
