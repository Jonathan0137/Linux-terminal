package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import command.Echo;
import output.Output;

public class EchoTest {
	Echo command = new Echo();
	Output outputList;
	String expected;
	ArrayList<Object> params;
	
	@Before
	public void setUp() {
		outputList = Output.getOutputInstance();
		params = new ArrayList<Object>();
	}
	
	@After
	public void reset() {
		outputList.resetOutput();
		params = null;
	}
	
	@Test
	public void testEchoEmptyString() {
		expected = "";
		String commandCall = "echo \"\"";
		params.add(commandCall);
		command.execute(params);
		assertEquals(expected, outputList.getOutputList().get(0).getOutput());
	}
	
	@Test
	public void testEchoNonEmptyStringWithAllCharacters() {
		expected = "qwertyuiopasdfghjklzxcvbnm,.<>?/;:'\"\\|]}[{1!2@3#4$5%6^7&8*9(0)-_=+";
		String commandCall = "echo \"qwertyuiopasdfghjklzxcvbnm,.<>?/;:'\"\\|]}[{1!2@3#4"
				+ "$5%6^7&8*9(0)-_=+\"";
		params.add(commandCall);
		command.execute(params);
		assertEquals(expected, outputList.getOutputList().get(0).getOutput());
	}

}
