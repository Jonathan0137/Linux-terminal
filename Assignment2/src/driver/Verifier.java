package driver;

//import java.util.Arrays;

public class Verifier 
{
  //Verifers user input
//  private String[] CommandStringArray = {"ls", "cd", "mkdir", "exit", "pwd", 
//      "pushd", "popd", "history", "cat", "echo", "man"};
//  
//  private boolean checkUserCommand(String command)
//  {
//    return Arrays.asList(CommandStringArray).contains(command); 
//  }
//  private boolean checkUserPath(String path)
//  {
//    return true;
//  }
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
        {
          return new EchoToFile();
        }
        else
        {
          return new EchoToOutput();
        }
      case "man":
        return new Man();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }
  }
  public boolean checkUserInput(String userInput)   //looking at the second part check the num of args
  {
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ", 100);
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
    else
    {
      return true;
    }
  
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
