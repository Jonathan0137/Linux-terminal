package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import verifier.Verifier;

/**
 * Test Case for Class Verifier's CheckUserInputCommand Method
 * 
 * @author Chongmin Bai
 */
public class TestcheckUserInputCommandTest {
  String userInput;
  String expected;
  Verifier correct;

  @Before
  public void setUp() {
    userInput = null;
    expected = null;
    correct = new Verifier();
  }

  @Test
  public void testCheckUserInputCommandCd() {
    userInput = "cd hello";
    expected = "Cd";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandExit() {
    userInput = "exit";
    expected = "Exit";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandMkdir() {
    userInput = "mkdir blah";
    expected = "Mkdir";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandLs() {
    userInput = "ls";
    expected = "Ls";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandPwd() {
    userInput = "pwd";
    expected = "Pwd";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandMv() {
    userInput = "mv path path";
    expected = "Mv";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandCp() {
    userInput = "cp path path";
    expected = "Cp";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandCat() {
    userInput = "cat blah";
    expected = "Cat";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandGet() {
    userInput = "get";
    expected = "Get";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandEcho() {
    userInput = "echo";
    expected = "Echo";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandMan() {
    userInput = "man";
    expected = "Man";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandPushd() {
    userInput = "pushd";
    expected = "Pushd";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandPopd() {
    userInput = "popd";
    expected = "Popd";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandHistory() {
    userInput = "history";
    expected = "History";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandLoad() {
    userInput = "load";
    expected = "Load";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  // @Test
  // public void testCheckUserInputCommandFind()
  // {
  // userInput = "find";
  // expected = "Find";
  // assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  // }
  @Test
  public void testCheckUserInputCommandTree() {
    userInput = "tree";
    expected = "Tree";
    assertEquals(expected,
        Verifier.checkUserInputCommand(userInput).toString());
  }

  @Test
  public void testCheckUserInputCommandInvalidCommand() {
    userInput = "hehehehe";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput));
  }

  @Test
  public void testCheckUserInputCommandEmpty() {
    userInput = "";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput));
  }

}
