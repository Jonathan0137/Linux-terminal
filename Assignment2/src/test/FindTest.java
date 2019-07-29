package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystemManipulation;
import output.Output;
import verifier.Verifier;

public class FindTest {
	
	JShell newJShell;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}

	@Test
	public void FindFileInOnePath() {
		execute("mkdir a", newJShell);
		Directory a = (Directory) FileSystemManipulation.findFileSystemNode(
																		"/a");
		File file1 = new File("File1");
		file1.setContents("File1 contents");
		file1.setParentDirectory(a);
		FileSystemManipulation.addFileSystemNode(a, file1);
		execute("find /a -type f -name \"File1\"", newJShell);
		String actualOutput = Output.getOutputInstance().getStringOutput();
		assertEquals("/a/File1\n", actualOutput);
		Output.getOutputInstance().resetOutput();
	}
	
	@Test
	public void FindDirectoryInOnePath() {
		execute("mkdir b", newJShell);
		execute("mkdir b/c", newJShell);
		execute("find /b -type d -name \"c\"", newJShell);
		String actualOutput = Output.getOutputInstance().getStringOutput();
		assertEquals("/b/c/\n", actualOutput);
		Output.getOutputInstance().resetOutput();
	}

	@Test
	public void FindNodeInMultiplePaths() {
		execute("mkdir a1 b1", newJShell);
		execute("mkdir b1/c1", newJShell);
		execute("find /a1 /b1 -type d -name \"c1\"", newJShell);
		String actualOutput = Output.getOutputInstance().getStringOutput();
		assertEquals("Error: 'c1' is not in the directory /a1/\n/b1/c1/\n",
																actualOutput);
		Output.getOutputInstance().resetOutput();
	}
	

  	@Test
  	public void FindNodeNotInPath() {
  		execute("mkdir a2", newJShell);
  		execute("find /a2 -type d -name \"e1\"", newJShell);
		String actualOutput = Output.getOutputInstance().getStringOutput();
		assertEquals("Error: 'e1' is not in the directory /a2/\n",
																actualOutput);
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
