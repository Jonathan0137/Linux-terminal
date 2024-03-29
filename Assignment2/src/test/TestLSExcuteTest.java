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
 * Test Case for Class Ls's excute Method
 * 
 * @author Chongmin Bai
 */
public class TestLSExcuteTest {
  ArrayList<String> input;
  JShell newJShell;
  String acutal;

  @Before
  public void setUp() {
    input = new ArrayList<String>();
    acutal = new String();
    newJShell = new JShell();
  }

  @Test
  public void testLs() {
    input.add("mkdir Folder1");
    input.add("mkdir Folder2");
    input.add("mkdir Folder1/Folder3");
    input.add("ls");
    for (String userInput : input) {
      execute(userInput, newJShell);
    }
    assertEquals("Folder1\nFolder2\n",
        Output.getOutputInstance().getStringOutput());

    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testLsWithR() {
    input.add("ls -R");

    for (String userInput : input) {
      execute(userInput, newJShell);
    }
    assertEquals("\n/Folder2/:\n\n/Folder1/:\n\n/Folder1/Folder3/:\n",
        Output.getOutputInstance().getStringOutput());

    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testLsWithMutiPath() {
    input.add("ls Folder1 Folder2");
    for (String userInput : input) {
      execute(userInput, newJShell);
    }
    assertEquals("Folder1 : \nFolder3\n\nFolder2 : \n\n",
        Output.getOutputInstance().getStringOutput());

    Output.getOutputInstance().resetOutput();
  }

  private void execute(String userInput, JShell newJShell) {
    Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
    if (toBeExecuted != null) {
      CommandParameter param =
          new CommandParameter(toBeExecuted, newJShell, userInput);
      toBeExecuted.execute(param.getParameters());
    }

  }
}
