package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import fileSystem.*;
import output.Output;
import verifier.Verifier;

public class MvTest {

	JShell newJShell;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}
	
	@Test
	public void MvDirectory() {
		execute("mkdir a b", newJShell);
		execute("mkdir a/c", newJShell);
		execute("mv a/c b", newJShell);
		Directory c = (Directory) FileSystemManipulation.findFileSystemNode("/b/c");
		assertEquals("/b/c/", c.getFullPathName());
	}
	
	@Test
	public void MvFile() {
		execute("mkdir d", newJShell);
		Directory d = (Directory) FileSystemManipulation.findFileSystemNode("/d");
		File file1 = new File("File1");
		file1.setContents("File1 contents");
		file1.setParentDirectory(d);
		assertEquals("/d/File1", file1.getFullPathName());
	}
	
	@Test
	public void MvToLocationContainingNodeAlready() {
		execute("mkdir e f", newJShell);
		execute("mkdir e/g", newJShell);
		execute("mkdir f/g", newJShell);
		execute("mv e/g f", newJShell);
		Output out = Output.getOutputInstance();
		assertEquals("Error: The node 'g' already exists in /f/\n", out.getStringOutput());
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
