package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import verifier.Verifier;


public class UnitTestVerifierTest 
{
  String userInput;
  String expected;
  Verifier correct;
  
  @Before
  public void setUp()
  {
    userInput = null;
    expected = null;
    correct = new Verifier();
  }

  @Test
  public void testCheckUserInputCommandCd() 
  {
    userInput = "cd hello";
    expected = "Cd";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandExit() 
  {
    userInput = "exit";
    expected = "Exit";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandMkdir() 
  {
    userInput = "mkdir blah";
    expected = "Mkdir";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandLs() 
  {
    userInput = "ls";
    expected = "Ls";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandPwd() 
  {
    userInput = "pwd";
    expected = "Pwd";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
//  @Test
//  public void testCheckUserInputCommandMv() 
//  {
//    userInput = "mv path path";
//    expected = "Mv";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
//  @Test
//  public void testCheckUserInputCommandCp() 
//  {
//    userInput = "cp path path";
//    expected = "Cp";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
  @Test
  public void testCheckUserInputCommandCat() 
  {
    userInput = "cat blah";
    expected = "Cat";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
//  @Test
//  public void testCheckUserInputCommandGet() 
//  {
//    userInput = "get";
//    expected = "Get";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
//  @Test
//  public void testCheckUserInputCommandEcho() 
//  {
//    userInput = "echo";
//    expected = "Echo";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
  @Test
  public void testCheckUserInputCommandMan() 
  {
    userInput = "man";
    expected = "Man";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandPushd() 
  {
    userInput = "pushd";
    expected = "Pushd";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandPopd() 
  {
    userInput = "popd";
    expected = "Popd";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandHistory() 
  {
    userInput = "history";
    expected = "History";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
//  @Test
//  public void testCheckUserInputCommandLoad() 
//  {
//    userInput = "load";
//    expected = "Load";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
//  @Test
//  public void testCheckUserInputCommandFind() 
//  {
//    userInput = "find";
//    expected = "Find";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
//  @Test
//  public void testCheckUserInputCommandTree() 
//  {
//    userInput = "tree";
//    expected = "Tree";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
  @Test
  public void testCheckUserInputCommandInvalidCommand() 
  {
    userInput = "hehehehe";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput));
  }
  
  @Test
  public void testcheckUserInputEmpty()
  {
    userInput = "";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  //*******************************TEST EXIT**************************/
  @Test
  public void testcheckUserInputexitWithNoParam()
  {
    userInput = "exit";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputexitWithParam()
  {
    userInput = "exit blah";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  /*******************************test mkdir********************************/
  
  @Test
  public void testcheckUserInputMkdirWithNoParam()
  {
    userInput = "mkdir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testcheckUserInputMkdirWithMutiSpaceAtCurrentDir()
  {
    userInput = "mkdir           directory           directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithOneParamAtCurrentDir()
  {
    userInput = "mkdir directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithMutiParamAtCurrentDir()
  {
    userInput = "mkdir directory directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithMutiParamInFront()
  {
    userInput = "mkdir /directory/hello /directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithOneParamAtFullPath()
  {
    userInput = "mkdir Hello/directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithMutiParamAtFullPath()
  {
    userInput = "mkdir Hello/directory Hello/bruh";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithDot()
  {
    userInput = "mkdir Hello/../directory Hello/./bruh";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithInvalidChar1()
  {
    userInput = "mkdir Hello/!directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithInvalidChar2()
  {
    userInput = "mkdir Hello/?directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithPartentFolder1()
  {
    userInput = "mkdir .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithPartentFolder2()
  {
    userInput = "mkdir ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputMkdirWithPartentFolder3()
  {
    userInput = "mkdir ...";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  /*******************************test cd*******************/
  @Test
  public void testcheckUserInputCD()
  {
    userInput = "cd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDOneParam()
  {
    userInput = "cd path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDMutiParam()
  {
    userInput = "cd path path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithFullPath1()
  {
    userInput = "cd /path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithFullPath2()
  {
    userInput = "cd path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithSlash()
  {
    userInput = "cd /";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithParentFolder1()
  {
    userInput = "cd .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithParentFolder2()
  {
    userInput = "cd ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithParentFolder3()
  {
    userInput = "cd ...";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDWithFullPath3()
  {
    userInput = "cd path/../path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputCDCheckRredirect()
  {
    userInput = "cd path > hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  /******************************TEST LS***************************/
  @Test
  public void testcheckUserInputLS()
  {
    userInput = "ls";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputLSWithPath()
  {
    userInput = "ls /Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputLSWithFolder()
  {
    userInput = "ls /Path/Folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testcheckUserInputLSWithFile()
  {
    userInput = "ls /Path/File.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
