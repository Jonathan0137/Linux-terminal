package driver;

public abstract class Command 
{
  //user enteres invalid commands?
  public abstract String execute(JShell shell, String path);
  
  
}
