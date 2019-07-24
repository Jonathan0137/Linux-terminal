package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import command.Command;
import output.AbstractOutput;
import output.Output;
import commandParameter.CommandParameter;
import driver.JShell;
import verifier.Verifier;




public class TestLSExcuteTest 
{
  ArrayList<String> input;
  JShell newJShell;
  ArrayList<String> acutal;
  @Before
  public void setUp()
  {
    input.clear();
    acutal.clear();
    newJShell = new JShell();
  }
  @Test
  public void testLs() 
  {
    input.add("mkdir Folder1");
    input.add("mkdir Folder2");
    input.add("mkdir Folder1/Folder3");
    input.add("ls");
    
    for(String userInput : input)
    {
      System.out.println(userInput);
      Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
      if (toBeExecuted != null) 
      {
        CommandParameter param = new CommandParameter(toBeExecuted,newJShell,userInput);
        toBeExecuted.execute(param.getParameters());
      }
    }
    Output.getOutputInstance().printOutput();
    
    for(int i = 0; i<Output.getOutputInstance().getOutputList().size(); i++)
    {
      acutal.add(Output.getOutputInstance().getOutputList().getOutput());
      
    }
    
    
    
    
    assertEquals("mkdir Folder1", input.get(0));
    
  }
//  public void testLsWithR() 
//  {
//    
//  }
}
