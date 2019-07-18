package output;

public class ErrorOutput extends AbstractOutput {

  @Override
  public void setOutput(String output) {
    this.outputMessage = "Error: " + output;
    
  }

}
