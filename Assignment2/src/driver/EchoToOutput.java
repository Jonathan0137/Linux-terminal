package driver;

public class EchoToOutput extends Command {
  
  @Override
  public String getDoc() {
    // Has the same documentation as EchoToFile
    EchoToFile etf = new EchoToFile();
    return etf.getDoc();
  }
  
  @Override 
  public void execute(JShell shell, String input) {
    System.out.println(input);
  }
}
