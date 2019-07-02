package command;

import driver.JShell;

public class EchoToOutput extends Command {
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'echo' command
   * (same documentation as EchoToFile).
   * 
   * @return the documentation of the 'echo' command
   */
  @Override
  public String getDoc() {
    // Has the same documentation as EchoToFile
    EchoToFile etf = new EchoToFile();
    return etf.getDoc();
  }

  /**
   * Prints the input to the shell.
   * 
   * @param shell an instance of the JShell that is interacting with the user
   * @param input the string that will be output to the shell
   */
  @Override
  public void execute(JShell shell, String input) {
    String[] inputSplit = input.split(" ", 2);
    if (inputSplit.length < 2) {
      System.out.println();
      return;
    }
    // Ignore the 'echo' part of the input
    input = inputSplit[1];
    int count = countNumberOfOccurrences(input, '"');
    if (count > 2) {
      System.out.println("The input cannot contain \" (double quotes) "
                        + "inside of the start and end double quotes.");
      return;
    }
    // Don't output the double quotes
    input = input.replaceAll("\"", "");
    System.out.println(input);
  }
  
  /**
   * Returns the number of occurrences of the target character 
   * in the string input.
   * 
   * @param input  the string being checked for the target character
   * @param target the target character being searched for in input
   * @return       the number of occurrences of target in input
   */
  private static int countNumberOfOccurrences(String input, char target) {
    int count = 0;
    for (int i=0; i<input.length(); i++) {
      if (input.charAt(i) == target) {
        count++;
      }
    }
    return count;
  }
}
