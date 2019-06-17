package driver;

public class Command 
{
  //user enteres invalid commands?
 
  public boolean UserCommands(String userInput) 
  {
    //check user enters valid command
    Verifier correct = new Verifier();
    if(correct.checkUserInput(userInput)==true)// if user enters valid command
    {
      //excute the userCommands
      return true;
    }
    else
    {
      return false;
    }

  }
 
}
