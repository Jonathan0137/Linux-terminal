package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import output.Output;
import redirection.Redirection;
import verifier.Verifier;

public class CatTest {

	ArrayList<String> input;
	JShell newJShell;
	ArrayList<Object> param;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}
	
	@Test
	public void CatWith1File() {
		execute("echo \"File1 contents\" > File1", newJShell);
		execute("cat File1", newJShell);
		assertEquals("File1 contents\n", 
				Output.getOutputInstance().getStringOutput());
		Output.getOutputInstance().resetOutput();
	}
	
	@Test
	public void CatWithMultipleFiles() {
		execute("echo \"File1 contents\" > File1", newJShell);
		execute("echo \"File2 contents\" > File2", newJShell);
		execute("cat File1 File2", newJShell);
		assertEquals("File1 contents\n\n\n\nFile2 contents\n", 
				Output.getOutputInstance().getStringOutput());
		Output.getOutputInstance().resetOutput();
	}

	@Test
	public void CatWith1FileError() {
		execute("cat File1", newJShell);
		assertEquals("Error: The file 'File1' does not exist in /\n", 
				Output.getOutputInstance().getStringOutput());
		Output.getOutputInstance().resetOutput();
	}
	
	
	private void execute(String userInput, JShell newJShell) {
		Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
		if (toBeExecuted != null) {
			CommandParameter param = new CommandParameter(toBeExecuted,
													newJShell, userInput);
			toBeExecuted.execute(param.getParameters());
			Redirection.redirectionSetUp(userInput);
	    }

	}

}
