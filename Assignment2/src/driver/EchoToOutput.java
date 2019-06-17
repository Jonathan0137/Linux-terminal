package driver;

public class EchoToOutput extends printCommand {
  // Required Parent Class: PrintCommand
  
  // Should be @Override after PrintCommand is implemented
  public void execute(String input) {
    System.out.println(input);
  }
}
