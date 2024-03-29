package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fileSystem.Directory;
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
		output.resetOutput();
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
		assertEquals(expected.get(0).getOutput(), actual.get(0).getOutput());
		assertEquals(expected.get(1).getOutput(), actual.get(1).getOutput());
	}
	
	@Test
	public void testredirectionSetUpNonExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) > newFile1";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile1")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpNonExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) >> newFile2";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile2")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) > oldFile1";
		File oldFile = new File("oldFile1", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile1")).getContents();
		String expected = "test";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		userInput = "commandx (...) >> oldFile2";
		File oldFile = new File("oldFile2", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile2")).getContents();
		String expected = "Some arbitrary string\ntest";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsNonExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) > newFile3";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile3")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsNonExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) >> newFile4";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "newFile4")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsExistingFileCurrentDirOverwrite() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) > oldFile3";
		File oldFile = new File("oldFile3", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile3")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsExistingFileCurrentDirAppend() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) >> oldFile4";
		File oldFile = new File("oldFile4", "Some arbitrary string");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), oldFile);
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findSubNode(fs.getCurrentDirectory(), "oldFile4")).getContents();
		String expected = "Some arbitrary string\ntest\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsIllegalFile() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) >> /";
		Redirection.redirectionSetUp(userInput);
		String actual = output.getOutputList().get(0).getOutput();
		String expected = "Error: Invalid file name for redirection.";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsIllegalPath() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) >> /Not/A/Real/path";
		Redirection.redirectionSetUp(userInput);
		String actual = output.getOutputList().get(0).getOutput();
		String expected = "Error: Redirection: Given directory does not exist";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsfullPathOverwriteNonExistingFile() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		Directory first = new Directory("A");
		Directory second = new Directory("Real");
		Directory third = new Directory("Path");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), first);
		FileSystemManipulation.addFileSystemNode(first, second);
		FileSystemManipulation.addFileSystemNode(second, third);
		userInput = "commandx (...) > /A/Real/Path/newFile1";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findFileSystemNode("/A/Real/Path/newFile1")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsfullPathAppendNonExistingFile() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		userInput = "commandx (...) >> /A/Real/Path/newFile2";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findFileSystemNode("/A/Real/Path/newFile2")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsfullPathOverwriteExistingFile() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		File oldFile = new File("oldFile1", "Some arbitrary string");
		Directory first = new Directory("A");
		Directory second = new Directory("Real");
		Directory third = new Directory("Path");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), first);
		FileSystemManipulation.addFileSystemNode(first, second);
		FileSystemManipulation.addFileSystemNode(second, third);
		Directory parent = (Directory) FileSystemManipulation.findFileSystemNode("/A/Real/Path");
		FileSystemManipulation.addFileSystemNode(parent, oldFile);
		userInput = "commandx (...) > /A/Real/Path/oldFile1";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findFileSystemNode("/A/Real/Path/oldFile1")).getContents();
		String expected = "test\nanother one\nagain";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testredirectionSetUpManyOutputsfullPathAppendExistingFile() {
		output.addUserOutput("test");
		output.addErrorOutput("another output");
		output.addUserOutput("another one");
		output.addUserOutput("again");
		File oldFile = new File("oldFile2", "Some arbitrary string");
		Directory first = new Directory("A");
		Directory second = new Directory("Real");
		Directory third = new Directory("Path");
		FileSystemManipulation.addFileSystemNode(fs.getCurrentDirectory(), first);
		FileSystemManipulation.addFileSystemNode(first, second);
		FileSystemManipulation.addFileSystemNode(second, third);
		Directory parent = (Directory) FileSystemManipulation.findFileSystemNode("/A/Real/Path");
		FileSystemManipulation.addFileSystemNode(parent, oldFile);
		userInput = "commandx (...) >> /A/Real/Path/oldFile2";
		Redirection.redirectionSetUp(userInput);
		String actual = ((File) FileSystemManipulation
				.findFileSystemNode("/A/Real/Path/oldFile2")).getContents();
		String expected = "Some arbitrary string\ntest\nanother one\nagain";
		assertEquals(expected, actual);
	}
}
