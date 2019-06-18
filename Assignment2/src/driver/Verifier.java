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
    //userInput = userInput.replaceAll("  ", " ");
    String[] input = userInput.split(" ", 2);
    String command = input[0];
    switch(command)
    {
      case "ls":
        return new Ls();
        break;
      case "cd":
        return new Cd();
        break;
      case "mkdir":
        return new Mkdir();
        break;
      case "exit":
        return new Exit();
        break;
      case "pwd":
        return new Pwd();
        break;
      case "pushd":
        return new Pushd();
        break;
      case "popd":
        return new Popd();
        break;
      case "history":
        return new History();
        break;
      case "cat":
        return new Cat();
        break;
      case "echo":
        if(userInput.contains(">"))
        {
          return new EchoToFile();
        }
        else
        {
          return new EchoToOutput();
        }
        break;
      case "man":
        return new Man();
        break;
      default:
        System.out.println("Command not found, please try again");
        return null;
        
    }
  }
  public boolean checkUserInput(String userInput)   //looking at the second part check the num of args
  {
    
    String[] input = userInput.split(" ", 10);
    int numOfArg = input.length;
    String command=input[0];
    if(command == "exit" && numOfArg > 1)
    {
      System.out.println("bash exit: too many arguments");
      return false;
    }
    else if(command == "mkdir" && numOfArg == 1)
    {
      System.out.println("bash mkdir: missing directory");
      return false;
    }
    else if(command == "cd" && numOfArg > 2)
    {
      System.out.println("bash cd: too many arguments");
      return false;
    }
//    else if(command == "cd" && numOfArg == 1)
//    {
//      System.out.println("bash cd: not enought arguments");
//      return false;
//    }
    // ls can have anynumer
    else if(command == "pwd" && numOfArg > 1)
    {
      System.out.println("bash pwd: too many arguments");
      return false;
    }
    else if(command == "pushd" && numOfArg > 2)
    {
      System.out.println("bash pushd: too many arguments");
      return false;
    } 
    else if(command == "pushd" && numOfArg == 1)
    {
      System.out.println("bash: pushd: no other directory");
      return false;
    } 
    else if(command == "history" && numOfArg > 2)
    {
      System.out.println("bash: history: too many arguments");
      return false;
    } 
    else if(command == "cat" && numOfArg == 1)
    {
      System.out.println("bash: cat: not enought arguments");
      return false;
    }
    else if(command == "man" && numOfArg == 1)
    {
      System.out.println("What manual page do you want?");
      return false;
    } 
    else if(command == "man" && numOfArg > 2)
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
