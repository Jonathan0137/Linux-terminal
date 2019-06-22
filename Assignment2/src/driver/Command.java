package driver;

public abstract class Command 
{
  protected String doc;
  //user enteres invalid commands?
  public abstract void execute(JShell shell, String input);
  
  protected abstract String getDoc();
}
