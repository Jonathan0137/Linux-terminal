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
  @Test
  public void testCheckUserInputCommandMv() 
  {
    userInput = "mv path path";
    expected = "Mv";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandCp() 
  {
    userInput = "cp path path";
    expected = "Cp";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandCat() 
  {
    userInput = "cat blah";
    expected = "Cat";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandGet() 
  {
    userInput = "get";
    expected = "Get";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandEcho() 
  {
    userInput = "echo";
    expected = "Echo";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
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
  @Test
  public void testCheckUserInputCommandLoad() 
  {
    userInput = "load";
    expected = "Load";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
//  @Test
//  public void testCheckUserInputCommandFind() 
//  {
//    userInput = "find";
//    expected = "Find";
//    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
//  }
  @Test
  public void testCheckUserInputCommandTree() 
  {
    userInput = "tree";
    expected = "Tree";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput).toString());
  }
  @Test
  public void testCheckUserInputCommandInvalidCommand() 
  {
    userInput = "hehehehe";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput));
  }
  
  @Test
  public void testCheckUserInputCommandEmpty()
  {
    userInput = "";
    assertEquals(expected, Verifier.checkUserInputCommand(userInput));
  }
  
  //*******************************TEST EXIT**************************/
  @Test
  public void testCheckUserInputexitWithNoParam()
  {
    userInput = "exit";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithParam()
  {
    userInput = "exit blah";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithRedirect1()
  {
    userInput = "exit > lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithRedirect2()
  {
    userInput = "exit > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithRedirect3()
  {
    userInput = "exit >> lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithRedirect4()
  {
    userInput = "exit >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  /*******************************test mkdir********************************/
  
  @Test
  public void testCheckUserInputMkdir1()
  {
    userInput = "mkdir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputMkdir2()
  {
    userInput = "mkdir           directory           directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir3()
  {
    userInput = "mkdir directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir4()
  {
    userInput = "mkdir directory directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir5()
  {
    userInput = "mkdir /directory/hello /directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir6()
  {
    userInput = "mkdir Hello/directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir7()
  {
    userInput = "mkdir Hello/directory Hello/bruh";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir8()
  {
    userInput = "mkdir Hello/../directory Hello/./bruh";
    assertEquals(true, correct.checkUserInput(userInput));
  } 
  @Test
  public void testCheckUserInputMkdir9()
  {
    userInput = "mkdir Hello/!directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir10()
  {
    userInput = "mkdir Hello/?directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir11()
  {
    userInput = "mkdir .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir12()
  {
    userInput = "mkdir ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir13()
  {
    userInput = "mkdir ...";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir14()
  {
    userInput = "mkdir path > hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir15()
  {
    userInput = "mkdir path > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir16()
  {
    userInput = "mkdir path >> hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdir17()
  {
    userInput = "mkdir path >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  /*******************************test cd*******************/
  @Test
  public void testCheckUserInputCD()
  {
    userInput = "cd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD1()
  {
    userInput = "cd path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD2()
  {
    userInput = "cd path path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD3()
  {
    userInput = "cd /path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD4()
  {
    userInput = "cd path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD5()
  {
    userInput = "cd hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD6()
  {
    userInput = "cd /";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD7()
  {
    userInput = "cd .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD8()
  {
    userInput = "cd ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD9()
  {
    userInput = "cd path/../path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD10()
  {
    userInput = "cd ../path/../path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD11()
  {
    userInput = "cd path > hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD12()
  {
    userInput = "cd path > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD13()
  {
    userInput = "cd path >> hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCD14()
  {
    userInput = "cd path >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  /******************************TEST LS***************************/
  @Test
  public void testCheckUserInputLS()
  {
    userInput = "ls";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS1()
  {
    userInput = "ls /Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS2()
  {
    userInput = "ls /Path/Folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS3()
  {
    userInput = "ls /Path/File.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS4()
  {
    userInput = "ls ../file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS5()
  {
    userInput = "ls ../folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS6()
  {
    userInput = "ls ./file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS7()
  {
    userInput = "ls ./folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS8()
  {
    userInput = "ls -R";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS9()
  {
    userInput = "ls -R Path Path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS10()
  {
    userInput = "ls -R Path/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS11()
  {
    userInput = "ls -R Path/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS12()
  {
    userInput = "ls -R /Path/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS13()
  {
    userInput = "ls -R ../file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS14()
  {
    userInput = "ls -R ../folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS15()
  {
    userInput = "ls -R ./file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS16()
  {
    userInput = "ls -R ./folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS17()
  {
    userInput = "ls .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS18()
  {
    userInput = "ls ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS19()
  {
    userInput = "ls > fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS20()
  {
    userInput = "ls >> fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLS21()
  {
    userInput = "ls -R> fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS22()
  {
    userInput = "ls -R > fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLS23()
  {
    userInput = "ls > folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS24()
  {
    userInput = "ls > /folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS25()
  {
    userInput = "ls > folder fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS26()
  {
    userInput = "ls >";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS27()
  {
    userInput = "ls -R >> fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS28()
  {
    userInput = "ls >> folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS29()
  {
    userInput = "ls >> /folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS30()
  {
    userInput = "ls >> folder fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLS31()
  {
    userInput = "ls >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /***************************************Test pwd***********/
  
  @Test
  public void testCheckUserInputPWD()
  {
    userInput = "pwd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithParam()
  {
    userInput = "pwd path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect1()
  {
    userInput = "pwd >";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect4()
  {
    userInput = "pwd > Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect5()
  {
    userInput = "pwd > /Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect7()
  {
    userInput = "pwd > Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect8()
  {
    userInput = "pwd > /Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect9()
  {
    userInput = "pwd > /Path/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect10()
  {
    userInput = "pwd >> Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect11()
  {
    userInput = "pwd >> /Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect12()
  {
    userInput = "pwd >> /Path/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect13()
  {
    userInput = "pwd >> /Path/hello lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWD1()
  {
    userInput = "pwd >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /*************************test mv**************************************/
  @Test
  public void testCheckUserInputMVwithNoParam()
  {
    userInput = "mv";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV1()
  {
    userInput = "mv path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV2()
  {
    userInput = "mv hello.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV3()
  {
    userInput = "mv path hi.txt lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV4()
  {
    userInput = "mv path hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV5()
  {
    userInput = "mv path/lol /hello/hey";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV6()
  {
    userInput = "mv path/lol.txt /hello/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV7()
  {
    userInput = "mv path/lol /hello/hey > folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV8()
  {
    userInput = "mv path/lol /hello/hey >> folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV9()
  {
    userInput = "mv path/lol /hello/hey > file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV10()
  {
    userInput = "mv path/lol /hello/hey >> file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV11()
  {
    userInput = "mv path/lol /hello/hey > /folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV12()
  {
    userInput = "mv path/lol /hello/hey >> /folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV13()
  {
    userInput = "mv path/lol /hello/hey > folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV14()
  {
    userInput = "mv path/lol /hello/hey >> folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV15()
  {
    userInput = "mv path/lol /hello/hey > /folder/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMV16()
  {
    userInput = "mv path/lol /hello/hey >> /folder/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /*******************************TEST CP**********************/
  @Test
  public void testCheckUserInputCPwithNoParam()
  {
    userInput = "cp";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP1()
  {
    userInput = "cp path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP2()
  {
    userInput = "cp hello.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP3()
  {
    userInput = "cp path hi.txt lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP4()
  {
    userInput = "cp path hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP5()
  {
    userInput = "cp path/lol /hello/hey";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP6()
  {
    userInput = "cp path/lol.txt /hello/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP7()
  {
    userInput = "cp path/lol /hello/hey > folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP8()
  {
    userInput = "cp path/lol /hello/hey >> folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP9()
  {
    userInput = "cp path/lol /hello/hey > file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP10()
  {
    userInput = "cp path/lol /hello/hey >> file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP11()
  {
    userInput = "cp path/lol /hello/hey > /folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP12()
  {
    userInput = "cp path/lol /hello/hey >> /folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP13()
  {
    userInput = "cp path/lol /hello/hey > folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP14()
  {
    userInput = "cp path/lol /hello/hey >> folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP15()
  {
    userInput = "cp path/lol /hello/hey > /folder/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCP16()
  {
    userInput = "cp path/lol /hello/hey >> /folder/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  /***********************Test CAT**************************************/
  @Test
  public void testCheckUserInputCAT()
  {
    userInput = "cat";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT1()
  {
    userInput = "cat file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT2()
  {
    userInput = "cat file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT3()
  {
    userInput = "cat /file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT4()
  {
    userInput = "cat /folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT5()
  {
    userInput = "cat folder/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT6()
  {
    userInput = "cat folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT7()
  {
    userInput = "cat folder/../file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT8()
  {
    userInput = "cat folder/file file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT9()
  {
    userInput = "cat file file file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT10()
  {
    userInput = "cat file > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT11()
  {
    userInput = "cat file >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT12()
  {
    userInput = "cat file > hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT13()
  {
    userInput = "cat file >> hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT14()
  {
    userInput = "cat file > /hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT15()
  {
    userInput = "cat file >> /hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT16()
  {
    userInput = "cat file > hello/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT17()
  {
    userInput = "cat file >> hello/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT18()
  {
    userInput = "cat file.txt > hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT19()
  {
    userInput = "cat file.txt >> hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT20()
  {
    userInput = "cat hello/file > hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT21()
  {
    userInput = "cat hello/file >> hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT22()
  {
    userInput = "cat file > hello/file lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT23()
  {
    userInput = "cat file >> hello/file lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCAT24()
  {
    userInput = "cat file >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
/***********************txt get*****************************************/
  @Test
  public void testCheckUserInputGET()
  {
    userInput = "get";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET1()
  {
    userInput = "get http://www.google.ca/";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET3()
  {
    userInput = "get http://www.google.ca/hello/apple.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET6()
  {
    userInput = "get www.google.ca/";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET7()
  {
    userInput = "get www.google.ca/ > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET8()
  {
    userInput = "get www.google.ca/ > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET9()
  {
    userInput = "get www.google.ca/ > /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET10()
  {
    userInput = "get www.google.ca/ > root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET11()
  {
    userInput = "get www.google.ca/ >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET12()
  {
    userInput = "get www.google.ca/ >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET13()
  {
    userInput = "get www.google.ca/ >> /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET14()
  {
    userInput = "get www.google.ca/ >> root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET15()
  {
    userInput = "get www.google.ca/ >> root/../hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGET16()
  {
    userInput = "get www.google.ca/hey/bru.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  /*****************************TEST echo***************************/
  @Test
  public void testCheckUserInputECHO()
  {
    userInput = "echo";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO1()
  {
    userInput = "echo String";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO2()
  {
    userInput = "echo \"string\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO3()
  {
    userInput = "echo \"string\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO4()
  {
    userInput = "echo \"string\" > hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO5()
  {
    userInput = "echo \"string\" > /hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO6()
  {
    userInput = "echo \"string\" >> hello/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO7()
  {
    userInput = "echo \"string\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO8()
  {
    userInput = "echo \"string\" >> hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO9()
  {
    userInput = "echo \"string\" >> /hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO10()
  {
    userInput = "echo \"string\" >> hello/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO11()
  {
    userInput = "echo \"string\" >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO12()
  {
    userInput = "echo \"string\" hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  public void testCheckUserInputECHO13()
  {
    userInput = "echo \"\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  /***************************************TEST MAN************************/
  @Test
  public void testCheckUserInputMAN()
  {
    userInput = "man";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN1()
  {
    userInput = "man cd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN2()
  {
    userInput = "man exit";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN3()
  {
    userInput = "man mkdir";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN4()
  {
    userInput = "man ls";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN5()
  {
    userInput = "man pwd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN6()
  {
    userInput = "man mv";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN7()
  {
    userInput = "man cp";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN8()
  {
    userInput = "man cat";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN9()
  {
    userInput = "man get";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN10()
  {
    userInput = "man echo";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN11()
  {
    userInput = "man man";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN12()
  {
    userInput = "man pushd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN13()
  {
    userInput = "man popd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN14()
  {
    userInput = "man history";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN15()
  {
    userInput = "man load";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN16()
  {
    userInput = "man find";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN17()
  {
    userInput = "man tree";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN18()
  {
    userInput = "man NotCMD";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN19()
  {
    userInput = "man NotCMD somethingelse";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN20()
  {
    userInput = "man cd > lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN21()
  {
    userInput = "man cd > lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN22()
  {
    userInput = "man cd > root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN23()
  {
    userInput = "man cd > root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN24()
  {
    userInput = "man cd > /root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN25()
  {
    userInput = "man cd > /root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN26()
  {
    userInput = "man cd >> lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN27()
  {
    userInput = "man cd >> lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN28()
  {
    userInput = "man cd >> root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN29()
  {
    userInput = "man cd >> root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN30()
  {
    userInput = "man cd >> /root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN31()
  {
    userInput = "man cd >> /root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN32()
  {
    userInput = "man cd >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /********************************TEST PUSHD*********************/
  @Test
  public void testCheckUserInputPUSHD()
  {
    userInput = "pushd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD1()
  {
    userInput = "pushd file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD2()
  {
    userInput = "pushd file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD3()
  {
    userInput = "pushd /file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD4()
  {
    userInput = "pushd /folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD5()
  {
    userInput = "pushd folder/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD6()
  {
    userInput = "pushd folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD7()
  {
    userInput = "pushd folder/../file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD8()
  {
    userInput = "pushd folder/file file";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD9()
  {
    userInput = "pushd file file file";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD10()
  {
    userInput = "pushd file > lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD11()
  {
    userInput = "pushd file >> lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD12()
  {
    userInput = "pushd file >> lol/../";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHD13()
  {
    userInput = "pushd file >> ../lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  /********************************TEST POPD*********************/
  @Test
  public void testCheckUserInputPOPD()
  {
    userInput = "popd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPD1()
  {
    userInput = "popd anythingelse";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPD2()
  {
    userInput = "popd anythingelse > any dir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPD3()
  {
    userInput = "popd anythingelse >> any dir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  /********************************TEST History*********************/
  @Test
  public void testCheckUserInputHISTORY()
  {
    userInput = "history";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY1()
  {
    userInput = "history 0";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY2()
  {
    userInput = "history 1";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY3()
  {
    userInput = "history 111111111111111111111";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY4()
  {
    userInput = "history 1111 1111 11111 11111 111";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY5()
  {
    userInput = "history 1 1";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY6()
  {
    userInput = "history 1 > lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY7()
  {
    userInput = "history 1 > lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY8()
  {
    userInput = "history 1 > /lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY9()
  {
    userInput = "history 1 > hey/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY10()
  {
    userInput = "history 1 > /hey/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY11()
  {
    userInput = "history 1 > hello/../lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY12()
  {
    userInput = "history 1 > ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORY13()
  {
    userInput = "history 1 >> ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  /********************************TEST SAVE*********************/
  @Test
  public void testCheckUserInputSAVE()
  {
    userInput = "save";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE1()
  {
    userInput = "save LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE2()
  {
    userInput = "save LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE3()
  {
    userInput = "save root/LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE4()
  {
    userInput = "save /root/LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE5()
  {
    userInput = "save root/LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE6()
  {
    userInput = "save /root/LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE7()
  {
    userInput = "save root LOL.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE8()
  {
    userInput = "save /root/../LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE9()
  {
    userInput = "save ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE10()
  {
    userInput = "save .. >> hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVE11()
  {
    userInput = "save .. > hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  /********************************TEST LOAD*********************/
  @Test
  public void testCheckUserInputLOAD()
  {
    userInput = "load";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD1()
  {
    userInput = "load folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD2()
  {
    userInput = "load folder folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD3()
  {
    userInput = "load load.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD4()
  {
    userInput = "load hey/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD5()
  {
    userInput = "load /hey/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD6()
  {
    userInput = "load hey > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD7()
  {
    userInput = "load hey > /hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD8()
  {
    userInput = "load hey > root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD9()
  {
    userInput = "load hey > /root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD10()
  {
    userInput = "load hey >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOAD11()
  {
    userInput = "load hey >> /hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD12()
  {
    userInput = "load hey >> root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOAD13()
  {
    userInput = "load hey >> /root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /****************************************TEST FIND********************/
  @Test
  public void testCheckUserInputFIND()
  {
    userInput = "find";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND1()
  {
    userInput = "find /user/data";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND2()
  {
    userInput = "find /user/data -type";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND3()
  {
    userInput = "find /user/data -type d";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND4()
  {
    userInput = "find /user/data -type d - name";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND5()
  {
    userInput = "find /user/data -type d -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND6()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND7()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND8()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND9()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND10()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND11()
  {
    userInput = "find /user/data -type f -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND12()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND13()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND14()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND15()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND16()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND17()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND18()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND19()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND20()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND21()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND22()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND23()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFIND24()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  /*************************************TEST TREE****************************/
  
  @Test
  public void testCheckUserInputTREE()
  {
    userInput = "tree";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE1()
  {
    userInput = "tree ";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE2()
  {
    userInput = "tree > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE3()
  {
    userInput = "tree > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE4()
  {
    userInput = "tree > /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE5()
  {
    userInput = "tree > root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE6()
  {
    userInput = "tree >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE7()
  {
    userInput = "tree >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE8()
  {
    userInput = "tree >> /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE9()
  {
    userInput = "tree >> root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE10()
  {
    userInput = "tree >> root/../hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
}
