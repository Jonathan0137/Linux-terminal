package output;

/**
 * An abstract class that provides the
 * implementation details for UserOutput and ErrorOutput.
 * 
 * @author Gary Xie
 */
public abstract class AbstractOutput {
  /**
   * The string that contains the output message.
   */
  protected String outputMessage;
  
  /**
   * Method to set the output message of the AbstractOutput object.
   * To be implemented by child classes.
   * 
   * @param output the output message
   */
  public abstract void setOutput(String output);
  
  /**
   * Returns the output message.
   * 
   * @return the output message
   */
  public String getOutput() {
    return this.outputMessage;
  }
}
