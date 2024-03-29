package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.lang.reflect.Field;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inputHistory.InputHistory;

/**
 * JUnit testing all test cases for non setter/getter methods of InputHistory.
 * 
 * @author Tom Daudelin
 *
 */
public class InputHistoryTest {

	ArrayList<String> expected;
	ArrayList<String> actual;
	InputHistory testSubject;

	@Before
	public void setUp() {
		expected = new ArrayList<String>();
		testSubject = InputHistory.getInputHistory();
	}

	@After
	public void reset() throws NoSuchFieldException, SecurityException, 
	  IllegalArgumentException, IllegalAccessException {
        Field field = (testSubject.getClass()).getDeclaredField("history");
    	field.setAccessible(true);
    	field.set(null, null);
	}

	@Test
	public void testAddToHistoryOneString() {
		expected.add("hello");
		testSubject.addToHistory("hello");
		actual = testSubject.getInputList();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddToHistoryMultipleStrings() {
		expected.add("test");
		expected.add("");
		expected.add("test 2");
		expected.add("");
		testSubject.addToHistory("test");
		testSubject.addToHistory("");
		testSubject.addToHistory("test 2");
		testSubject.addToHistory("");
		actual = testSubject.getInputList();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSingletonPrincipals() {
		InputHistory inputCopy = InputHistory.getInputHistory();
		inputCopy.addToHistory("test");
		inputCopy.addToHistory("test again");
		expected = inputCopy.getInputList();
		actual = testSubject.getInputList();
		assertEquals(expected, actual);
	}
}
