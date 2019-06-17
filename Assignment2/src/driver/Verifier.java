package driver;

import java.util.Arrays;

public class Verifier 
{
  //Verifers user input
  private String[] CommandStringArray = {"ls", "cd", "mkdir", "exit", "pwd", 
      "pushd", "popd", "history", "cat", "echo", "man"};
  
  private boolean checkUserCommand(String command)
  {
    return Arrays.asList(CommandStringArray).contains(command); 
  }
  private boolean checkUserPath(String path)
  {
    return true;
  }
  
  public boolean checkUserInput(String userInput)
  {
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ");
    String command = input[0];
    String path = input[1];
    if(checkUserCommand(path)==false)
    {
      System.out.println("This Command does not exist.");
      return false;
    }
    if(checkUserPath(command)==false)
    {
      System.out.println("This path does not exist.");
      return false;
    }
    if(checkUserCommand(path)==true && checkUserPath(command)==true)
    {
      return true;
    }
  }
}
