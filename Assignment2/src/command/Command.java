package command;

import java.util.ArrayList;
import fileSystem.Directory;
import fileSystem.FileSystem;

/**
 * Command is an abstract parent class that represents each executable 
 * commands. Such as: exit, mkdir, cd, ls, pwd, pushd, popd, history,
 * cat, echo and man.
 * 
 * @author Chongmin Bai
 */
public abstract class Command 
{
  /**
   * The instance of the file system.
   */
  protected final FileSystem fs=FileSystem.getFileSystem();
  
  /**
   * An Abstract class that will be used for children classes to implement
   * 
   * @param shell an instance of the JShell that is interacting with the user
   * @param input User input.
   */
  public abstract void execute(ArrayList<Object> param);
  
  /**
   * An Abstract class that will be used for children classes to implement
   * to print each command's documentation.
   * 
   * @return the documentation of each command.
   */
  protected abstract String getDoc();

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }

}
