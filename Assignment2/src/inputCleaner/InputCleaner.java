package inputCleaner;

/**
 * InputCleaner is an class that change up some of the minor mistakes
 * that user makes that would not be allowed in our code.
 * 
 * @author Chongmin Bai
 */
public final class InputCleaner 
{
  /**
   * Replace all more than 1 instance of contintous space character into 
   * one space character.
   * 
   * @param userInput     a string that contains what user has typed
   * @return              an instance of String that represents the 
   *                      cleaned version of userInput
   */
  public static String cleanInput(String userInput)
  {
    userInput = userInput.replaceAll(" +", " ").trim();
    return userInput;
  }
}
