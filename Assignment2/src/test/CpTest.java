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

public class CpTest {


	JShell newJShell;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}
	
	@Test
	public void CpCDirectory() {
		execute("mkdir a b", newJShell);
		execute("mkdir a/c", newJShell);
		execute("cp a/c b", newJShell);
		Directory c = (Directory) FileSystemManipulation.findFileSystemNode("/b/c");
		assertEquals("/b/c/", c.getFullPathName());
	}
	
	@Test
	public void CpFile() {
		execute("mkdir d d2", newJShell);
		Directory d = (Directory) FileSystemManipulation.findFileSystemNode("/d");
		File file1 = new File("File1");
		file1.setContents("File1 contents");
		file1.setParentDirectory(d);
		FileSystemManipulation.addFileSystemNode(d, file1);
		execute("cp /d/File1 /d2", newJShell);
		File file1Copy = (File) FileSystemManipulation.findFileSystemNode("/d2/File1");
		assertEquals("/d2/File1", file1Copy.getFullPathName());
	}
	
	@Test
	public void CpToLocationContainingNodeAlready() {
		execute("mkdir e f", newJShell);
		execute("mkdir e/g", newJShell);
		execute("mkdir f/g", newJShell);
		execute("cp e/g f", newJShell);
		Output out = Output.getOutputInstance();
		assertEquals("Error: The name 'g' already exists in this directory.\n", out.getStringOutput());
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
