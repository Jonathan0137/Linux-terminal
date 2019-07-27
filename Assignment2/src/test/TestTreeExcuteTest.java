package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import command.Command;
import output.Output;
import commandParameter.CommandParameter;
import driver.JShell;
import verifier.Verifier;

/**
 * Test Case for Class Tree's excute Method
 * 
 * @author Chongmin Bai
 */
public class TestTreeExcuteTest {

  ArrayList<String> input;
  JShell newJShell;
  ArrayList<String> acutal;

  @Before
  public void setUp() {
    input = new ArrayList<String>();
    acutal = new ArrayList<String>();
    newJShell = new JShell();
  }

  @Test
  public void testTree() {
    input.add("mkdir Folder1");
    input.add("mkdir Folder2");
    input.add("mkdir Folder1/Folder3");
    input.add("mkdir Folder2/Folder4");
    input.add("tree");

    for (String userInput : input) {
      Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
      if (toBeExecuted != null) {
        CommandParameter param =
            new CommandParameter(toBeExecuted, newJShell, userInput);
        toBeExecuted.execute(param.getParameters());
      }
    }

    assertEquals("\\\n  Folder2\n    Folder4\n  Folder1\n    Folder3\n",
        Output.getOutputInstance().getStringOutput());
    Output.getOutputInstance().resetOutput();
  }

}
