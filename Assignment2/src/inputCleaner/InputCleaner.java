package inputCleaner;

public class InputCleaner 
{
  public static String cleanInput(String userInput)
  {
    userInput = userInput.replaceAll(" +", " ");
    
    
    return userInput;
  }
}
