package driver;

public class EchoToOutput extends Command {
  // Required Parent Class: PrintCommand
  
  // Should be @Override after PrintCommand is implemented
  public void execute(String input) {
    System.out.println(input);
  }
}
