package driver;

public abstract class Command 
//public interface Command
// change all other class to implement 
{

  protected String doc;
  public abstract void execute(JShell shell, String input);
  
  protected abstract String getDoc();
}
