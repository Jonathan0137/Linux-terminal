package driver;

public abstract class Command 
{
  protected String doc;
  //user enteres invalid commands?
  public abstract void execute(JShell shell, String path);
  
  protected abstract String getDoc();
}
