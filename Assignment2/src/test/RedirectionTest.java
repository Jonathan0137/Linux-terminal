package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fileSystem.File;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import output.AbstractOutput;
import output.ErrorOutput;
import output.Output;
import output.UserOutput;
import redirection.Redirection;

public class RedirectionTest {

	Output output;
	FileSystem fs;
	String userInput;
	ArrayList<AbstractOutput> mockOutput;
	
	@Before
	public void setUp() {
		output = Output.getOutputInstance();
		fs = FileSystem.getFileSystem();
		mockOutput = new ArrayList<AbstractOutput>();
	}
	
	@After
	public void reset() {
		
	}
	
	
	@Test
	public void testredirectionSetUpNoRedirectionNeededOutputCheck() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		UserOutput input1 = new UserOutput();
		ErrorOutput input2 = new ErrorOutput();
		input1.setOutput("test");
		input2.setOutput("another output");
		mockOutput.add(input1);
		mockOutput.add(input2);
		userInput = "commandx (...)";
		Redirection.redirectionSetUp(userInput);
		ArrayList<AbstractOutput> actual = output.getOutputList();
		ArrayList<AbstractOutput> expected = mockOutput;
		assertEquals(expected, actual); //why does test fail? is it because they are 2 diffrent objects?
	}
	
	/*@Test //Checks that no file has been created
	public void testredirectionSetUpNoRedirectionNeededFileCheck() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		UserOutput input1 = new UserOutput();
		ErrorOutput input2 = new ErrorOutput();
		input1.setOutput("test");
		input2.setOutput("another output");
		mockOutput.add(input1);
		mockOutput.add(input2);
		userInput = "commandx (...)";
		Redirection.redirectionSetUp(userInput);
		FileSystemNode actual = FileSystemManipulation.;
		FileSystemNode expected = null;
		assertEquals(expected, actual);
	}*/
	
	@Test
	public void testredirectionSetUpNonExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) > newFile";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpNonExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) >> newFile";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) > oldFile";
		File oldFile = new File("oldFile", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) >> oldFile";
		File oldFile = new File("oldFile", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile")).getContents();
		String expected = "Some arbitrary string\ntest";
		assertEquals(expected, actual);
	}
}
