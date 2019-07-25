package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import inputCleaner.InputCleaner;

/**
 * Test Case for Class InputCleaner's cleanInput Method
 * 
 * @author Chongmin Bai
 */
public class TestInputCleanerTest {

  String acutal;
  String expected;
  String userInput;

  @Before
  public void setUp() {
    acutal = null;
    expected = null;
    userInput = null;
  }

  @Test
  public void testCleanInput() {
    userInput = "    mkdir      folder1   folder2";
    expected = "mkdir folder1 folder2";
    acutal = InputCleaner.cleanInput(userInput);
    assertEquals(acutal, expected);
  }

}
