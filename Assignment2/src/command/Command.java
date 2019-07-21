package command;

import java.util.ArrayList;
import fileSystem.FileSystem;
import output.Output;

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
   * The instance of the Output control.
   */
  protected final Output output = Output.getOutputInstance();
  
  /**
   * An Abstract class that will be used for children classes to implement
   * 
   * @param param   An instance of ArraryList with its type being unknown.
   *                It could be any type base on what Jshell gives.
   */
  public abstract void execute(ArrayList<Object> param);
  
  /**
   * An Abstract class that will be used for children classes to implement
   * to print each command's documentation.
   * 
   * @return the documentation of each command.
   */
  protected abstract String getDoc();

  /**
   * An toString method that tells the name of each command under command
   * class
   * 
   * @return the name representation of each command.
   */
  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }

}
