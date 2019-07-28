package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import fileSystem.Directory;
import fileSystem.FileSystemManipulation;
import verifier.Verifier;

public class MkdirTest {

	JShell newJShell;

  	@Before
  	public void setUp() {
    	newJShell = new JShell();
  	}
	
	@Test
	public void Mkdir1RelativeDirectory() {
		execute("mkdir a", newJShell);
		Directory a = (Directory) FileSystemManipulation.findFileSystemNode("/a");
		assertEquals("/a/", a.getFullPathName());
	}
	
	@Test
	public void Mkdir1AbsoluteDirectory() {
		execute("mkdir a", newJShell);
		execute("mkdir a/b", newJShell);
		Directory b = (Directory) FileSystemManipulation.findFileSystemNode("/a/b");
		assertEquals("/a/b/", b.getFullPathName());
	}
	
	@Test
	public void MkdirMultipleRelativeDirectories() {
		execute("mkdir a b c", newJShell);
		Directory a = (Directory) FileSystemManipulation.findFileSystemNode("/a");
		Directory b = (Directory) FileSystemManipulation.findFileSystemNode("/b");
		Directory c = (Directory) FileSystemManipulation.findFileSystemNode("/c");
		assertEquals("/a/", a.getFullPathName());
		assertEquals("/b/", b.getFullPathName());
		assertEquals("/c/", c.getFullPathName());
	}
	
	@Test
	public void MkdirMultipleAbsoluteDirectory() {
		execute("mkdir a", newJShell);
		execute("mkdir a/b a/c", newJShell);
		Directory b = (Directory) FileSystemManipulation.findFileSystemNode("/a/b");
		Directory c = (Directory) FileSystemManipulation.findFileSystemNode("/a/c");
		assertEquals("/a/b/", b.getFullPathName());
		assertEquals("/a/c/", c.getFullPathName());
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
