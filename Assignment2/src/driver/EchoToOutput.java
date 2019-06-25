package driver;

public class EchoToOutput extends Command {
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'echo' command (same documentation as EchoToFile).
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
    
    System.out.println(input);
  }
}
