package output;

/**
 * Contains information about an user output message.
 * 
 * @author Gary Xie
 */
public class UserOutput extends AbstractOutput {

  /**
   * Set the output message of the UserOutput object.
   * 
   * @param output the user output message
   */
  @Override
  public void setOutput(String output) {
    this.outputMessage = output;
  }
}
