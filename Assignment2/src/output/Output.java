package output;

import java.util.ArrayList;

/**
 * Contains information about a list of user output and error output to be
 * sent to the user after a command executes.
 * 
 * @author Gary Xie
 */
public class Output {
  /**
   * A static instance of the Output, to 
   * follow Singleton design pattern.
   */
  private static Output out=null;
  
  /**
   * The list of output messages.
   */
  private ArrayList<AbstractOutput> outputList;
  
  /**
   * Constructor to create an Output object.
   */
  private Output() {
    outputList = new ArrayList<AbstractOutput>();
  };
  
  /**
   * Returns the sole instance of the Output object
   * (following Singleton design pattern). The first time
   * this method is called, it will create a new 
   * Output object.
   * 
   * @return the instance of the Output object
   */
  public static Output getOutputInstance() {
    if (out==null) {
      out = new Output();
    }
    return out;
  }
  
  /**
   * Empty the list of output messages.
   */
  public void resetOutput() {
    outputList = new ArrayList<AbstractOutput>();
  }
  
  /**
   * Return the list of output as a concatenated string. 
   * 
   * @return the list of output messages concatenated into a string
   */
  public String getStringOutput() {
    String result="";
    for (AbstractOutput out : outputList) {
      result = result + out.getOutput() + "\n";
    }
    return result;
  }
  
  /**
   * Add a UserOutput message to the list of output.
   * 
   * @param output the output message
   */
  public void addUserOutput(String output) {
    UserOutput uOut = new UserOutput();
    uOut.setOutput(output);
    outputList.add(uOut);
  }
  
  /**
   * Add a ErrorOutput message to the list of output.
   * 
   * @param output the output message
   */
  public void addErrorOutput(String output) {
    ErrorOutput eOut = new ErrorOutput();
    eOut.setOutput(output);
    outputList.add(eOut);
  }
  
  /**
   * Returns the list of output messages.
   * 
   * @return the list of output messages
   */
  public ArrayList<AbstractOutput> getOutputList() {
    return outputList;
  }
}
