package inputCleaner;

public final class InputCleaner 
{
  public static String cleanInput(String userInput)
  {
    userInput = userInput.replaceAll(" +", " ");
    return userInput;
  }
}
