package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import output.Output;
import verifier.Verifier;

class PwdTest {
	ArrayList<String> input;
	JShell newJShell;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}
	
	@Test
	void testPwdExecute() {
		execute("mkdir Folder1", newJShell);
		execute("cd Folder1", newJShell);
		execute("pwd", newJShell);
		
		assertEquals("/Folder1/\n", 
				Output.getOutputInstance().getStringOutput());
		Output.getOutputInstance().resetOutput();
	}
	
	private void execute(String userInput, JShell newJShell) {
		Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
		if (toBeExecuted != null) {
			CommandParameter param = new CommandParameter(toBeExecuted,
													newJShell, userInput);
			toBeExecuted.execute(param.getParameters());
	    }

	}

}
