package test;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import command.History;
import inputHistory.InputHistory;
import output.AbstractOutput;
import output.Output;

public class HistoryTest {
	InputHistory mockHistory;
	ArrayList<String> expected = new ArrayList<String>();
	History command = new History();
	ArrayList<Object> params;
	
	@Before
	public void setUp() {
		mockHistory = InputHistory.getInputHistory();
		params = new ArrayList<Object>();
	}
	
	@After
	public void reset() throws NoSuchFieldException, SecurityException, 
	  IllegalArgumentException, IllegalAccessException {
		Output.getOutputInstance().resetOutput();
		params = null;
		
		Field field = (mockHistory.getClass()).getDeclaredField("history");
        field.setAccessible(true);
        field.set(null, null);
	}
	
	@Test
	public void testExecuteOneInputNoIndex() {
		String firstInput = "first input";
		mockHistory.addToHistory(firstInput);
		expected.add("1. " + firstInput);
		String commandCall = "history";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
	}
	
	@Test
	public void testExecuteOneInputIndexGreaterThanSize() {
		String firstInput = "first input";
		mockHistory.addToHistory(firstInput);
		expected.add("1. " + firstInput);
		String commandCall = "history 23";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
	}
	
	@Test
	public void testExecuteOneInputIndexLessThanSize() {
		String firstInput = "first input";
		mockHistory.addToHistory(firstInput);
		String commandCall = "history -2";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExecuteOneInputIndexEqualsSize() {
		String firstInput = "first input";
		mockHistory.addToHistory(firstInput);
		expected.add("1. " + firstInput);
		String commandCall = "history 1";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
	}
	
	@Test
	public void testExecuteMultipleInputsNoIndex() {
		String firstInput = "first input";
		String secondInput = "second input";
		String thirdInput = "third input";
		String fourthInput = "fourth input";
		String fithInput = "fith input";
		mockHistory.addToHistory(firstInput);
		mockHistory.addToHistory(secondInput);
		mockHistory.addToHistory(thirdInput);
		mockHistory.addToHistory(fourthInput);
		mockHistory.addToHistory(fithInput);
		expected.add("1. " + firstInput);
		expected.add("2. " + secondInput);
		expected.add("3. " + thirdInput);
		expected.add("4. " + fourthInput);
		expected.add("5. " + fithInput);
		String commandCall = "history";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
		assertEquals(expected.get(1), actual.get(1).getOutput());
		assertEquals(expected.get(2), actual.get(2).getOutput());
		assertEquals(expected.get(3), actual.get(3).getOutput());
		assertEquals(expected.get(4), actual.get(4).getOutput());
	}
	
	@Test
	public void testExecuteMultipleInputsIndexGreaterThanSize() {
		String firstInput = "first input";
		String secondInput = "second input";
		String thirdInput = "third input";
		String fourthInput = "fourth input";
		String fithInput = "fith input";
		mockHistory.addToHistory(firstInput);
		mockHistory.addToHistory(secondInput);
		mockHistory.addToHistory(thirdInput);
		mockHistory.addToHistory(fourthInput);
		mockHistory.addToHistory(fithInput);
		expected.add("1. " + firstInput);
		expected.add("2. " + secondInput);
		expected.add("3. " + thirdInput);
		expected.add("4. " + fourthInput);
		expected.add("5. " + fithInput);
		String commandCall = "history 100";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
		assertEquals(expected.get(1), actual.get(1).getOutput());
		assertEquals(expected.get(2), actual.get(2).getOutput());
		assertEquals(expected.get(3), actual.get(3).getOutput());
		assertEquals(expected.get(4), actual.get(4).getOutput());
	}
	
	@Test
	public void testExecuteMultipleInputsIndexLessThanSize() {
		String firstInput = "first input";
		String secondInput = "second input";
		String thirdInput = "third input";
		String fourthInput = "fourth input";
		String fithInput = "fith input";
		mockHistory.addToHistory(firstInput);
		mockHistory.addToHistory(secondInput);
		mockHistory.addToHistory(thirdInput);
		mockHistory.addToHistory(fourthInput);
		mockHistory.addToHistory(fithInput);
		expected.add("3. " + thirdInput);
		expected.add("4. " + fourthInput);
		expected.add("5. " + fithInput);
		String commandCall = "history 3";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
		assertEquals(expected.get(1), actual.get(1).getOutput());
		assertEquals(expected.get(2), actual.get(2).getOutput());
	}
	
	@Test
	public void testExecuteMultipleInputsIndexEqualsSize() {
		String firstInput = "first input";
		String secondInput = "second input";
		String thirdInput = "third input";
		String fourthInput = "fourth input";
		String fithInput = "fith input";
		mockHistory.addToHistory(firstInput);
		mockHistory.addToHistory(secondInput);
		mockHistory.addToHistory(thirdInput);
		mockHistory.addToHistory(fourthInput);
		mockHistory.addToHistory(fithInput);
		expected.add("1. " + firstInput);
		expected.add("2. " + secondInput);
		expected.add("3. " + thirdInput);
		expected.add("4. " + fourthInput);
		expected.add("5. " + fithInput);
		String commandCall = "history 5";
		params.add(commandCall);
		command.execute(params);
		ArrayList<AbstractOutput> actual = Output.getOutputInstance().getOutputList(); 
		assertEquals(expected.get(0), actual.get(0).getOutput());
		assertEquals(expected.get(1), actual.get(1).getOutput());
		assertEquals(expected.get(2), actual.get(2).getOutput());
		assertEquals(expected.get(3), actual.get(3).getOutput());
		assertEquals(expected.get(4), actual.get(4).getOutput());
	}
}
