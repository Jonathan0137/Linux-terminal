package output;

/**
 * Contains information about an error output message.
 * 
 * @author Gary Xie
 */
public class ErrorOutput extends AbstractOutput {

  /**
   * Set the output message of the ErrorOutput object.
   * 
   * @param output the error output message
   */
  @Override
  public void setOutput(String output) {
    this.outputMessage = "Error: " + output;    
  }
}
