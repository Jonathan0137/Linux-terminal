package output;

import java.util.ArrayList;

public class Output {
  private static Output out=null;
  private ArrayList<AbstractOutput> outputList;
  
  private Output() {
    outputList = new ArrayList<AbstractOutput>();
  };
  
  public static Output getOutputInstance() {
    if (out==null) {
      out = new Output();
    }
    return out;
  }
  
  public void resetOutput() {
    outputList = new ArrayList<AbstractOutput>();
  }
  
  public String getStringOutput() {
    String result="";
    for (AbstractOutput out : outputList) {
      result = result + out.getOutput() + "\n";
    }
    return result;
  }
  
  public void addUserOutput(String output) {
    UserOutput uOut = new UserOutput();
    uOut.setOutput(output);
    outputList.add(uOut);
  }
  public void addErrorOutput(String output) {
    ErrorOutput eOut = new ErrorOutput();
    eOut.setOutput(output);
    outputList.add(eOut);
  }
  
  public ArrayList<AbstractOutput> getOutputList() {
    return outputList;
  }
}
