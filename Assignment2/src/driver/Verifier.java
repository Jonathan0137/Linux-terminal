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
  private boolean checkUserPath(String path)
  {
    return true;
  }
  public Command checkUserInputCommand(String userInput)
  {
    //userInput = userInput.replaceAll("  +", " ");
    String[] input = userInput.split(" ");
    String command = input[0];
//    if(checkUserCommand(command)==true)
//    {
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
        return new Echo();
        break;
      case "man":
        return new Man();
      default:
        return null;
        
    }
//    }
//    else
//    {
//      return null;
//    }
    
  }
  public boolean checkUserInput(String userInput)
  {
    //userInput = userInput.replaceAll("  +", " ");
    String[] input = userInput.split(" ");
    
    String command = input[0];
    String path = input[1];
    
    if(checkUserCommand(command)==false)
    {
      System.out.println("This Command does not exist.");
      return false;
    }
    if(checkUserPath(path)==false)
    {
      System.out.println("This path does not exist.");
      return false;
    }
    return true;
  }
}
