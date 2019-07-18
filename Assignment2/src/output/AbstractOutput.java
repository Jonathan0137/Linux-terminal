package output;

public abstract class AbstractOutput {
  protected String outputMessage;
  
  public abstract void setOutput(String output);
  
  public String getOutput() {
    return this.outputMessage;
  }
}
