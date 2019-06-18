package driver;

public abstract class Command 
{
  //user enteres invalid commands?
  public abstract void execute(JShell shell, String path);
  
  
}
