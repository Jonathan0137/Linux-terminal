package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import verifier.Verifier;


public class TestVerifierCheckUserInputTest 
{
  String userInput;
  Verifier correct;
  
  @Before
  public void setUp()
  {
    userInput = null;
    correct = new Verifier();
  }

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
  public void testCheckUserInputexitWithSingleRedirectWithFile()
  {
    userInput = "exit > lol.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithSingleRedirectWithFolder()
  {
    userInput = "exit > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithDoubleRedirectWithFile()
  {
    userInput = "exit >> lol.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputexitWithDoulbeRedirectWithFolder()
  {
    userInput = "exit >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithNoParam()
  {
    userInput = "mkdir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputMkdirWithMutiSpace()
  {
    userInput = "mkdir           directory           directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithOneParam()
  {
    userInput = "mkdir directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithMutiParam()
  {
    userInput = "mkdir directory directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithMutiParamWithFullPath()
  {
    userInput = "mkdir /directory/hello /directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithOneParamWithFullPath()
  {
    userInput = "mkdir Hello/directory";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithMutiParamWithDots()
  {
    userInput = "mkdir Hello/../directory Hello/./bruh";
    assertEquals(true, correct.checkUserInput(userInput));
  } 
  @Test
  public void testCheckUserInputMkdirWithInvalidFolderName()
  {
    userInput = "mkdir Hello/!directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithInvalidFolderName2()
  {
    userInput = "mkdir Hello/?directory Hello/./bruh";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithDot()
  {
    userInput = "mkdir .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWith2Dots()
  {
    userInput = "mkdir ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWith3Dots()
  {
    userInput = "mkdir ...";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithRedirectWithExtension()
  {
    userInput = "mkdir path > hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithRedirectWithoutExtension()
  {
    userInput = "mkdir path > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithDoubleRedirectWithExtension()
  {
    userInput = "mkdir path >> hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithDoubleRedirectWithNoExtension()
  {
    userInput = "mkdir path >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithValidNoneAlphanumeric()
  {
    userInput = "mkdir , hello- qwe_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMkdirWithInvalidFileName()
  {
    userInput = "mkdir hello! burh@";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithNoParam()
  {
    userInput = "cd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWith1Param()
  {
    userInput = "cd path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWith2Param()
  {
    userInput = "cd path path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithFullPath()
  {
    userInput = "cd /path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithFullPathVersion2()
  {
    userInput = "cd path/path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithExtension()
  {
    userInput = "cd hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithSlash()
  {
    userInput = "cd /";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithDot()
  {
    userInput = "cd .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWith2Dots()
  {
    userInput = "cd ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithDotsInThePath()
  {
    userInput = "cd path/../path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithDotsInFront()
  {
    userInput = "cd ../path/../path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithRedirectionWithExtension()
  {
    userInput = "cd path > hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithRedirection()
  {
    userInput = "cd path > folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithDoubleRedirectionWithExtension()
  {
    userInput = "cd path >> hehe.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCDWithDoubleRedirection()
  {
    userInput = "cd path >> folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithNoParam()
  {
    userInput = "ls";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithPath()
  {
    userInput = "ls /Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithMorePath()
  {
    userInput = "ls /Path/Folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithPathWithExtension()
  {
    userInput = "ls /Path/File.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotsInFrontOfPathWithExtension()
  {
    userInput = "ls ../file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotsInFrontOfPath()
  {
    userInput = "ls ../folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotWithExtension()
  {
    userInput = "ls ./file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotWithFolder()
  {
    userInput = "ls ./folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithR()
  {
    userInput = "ls -R";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWith2Path()
  {
    userInput = "ls -R Path Path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWithFullPath()
  {
    userInput = "ls -R Path/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWithFullPathWithExtension()
  {
    userInput = "ls -R Path/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWithFullPathVersion2WithExtension()
  {
    userInput = "ls -R /Path/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotsInFrontOfFullPathWithExtension()
  {
    userInput = "ls -R ../file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotsInFrontOfFullPath()
  {
    userInput = "ls -R ../folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotInFrontOfFullPathWithExtension()
  {
    userInput = "ls -R ./file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDotInFrontOfFullPathWithFolder()
  {
    userInput = "ls -R ./folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDot()
  {
    userInput = "ls .";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDots()
  {
    userInput = "ls ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRedirection()
  {
    userInput = "ls > fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDoubleRedirection()
  {
    userInput = "ls >> fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLSWithInvalidSpacing()
  {
    userInput = "ls -R> fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWithRedirection()
  {
    userInput = "ls -R > fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLSWithRedirectionWithFullPath()
  {
    userInput = "ls > folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRedirectionWithFullPath2()
  {
    userInput = "ls > /folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRedirectionWithMutiParam()
  {
    userInput = "ls > folder fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRedirectionWithNoPath()
  {
    userInput = "ls >";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithRWithDoubleRedirection()
  {
    userInput = "ls -R >> fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDoubleRedirectionWithFullPath()
  {
    userInput = "ls >> folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDoubleRedirectionWithFullPath2()
  {
    userInput = "ls >> /folder/fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDoubleRedirectionWith2Param()
  {
    userInput = "ls >> folder fileName";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSWithDoubleRedirectionWithDotsInFullPath()
  {
    userInput = "ls >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSTestInvalidFileName()
  {
    userInput = "ls hey!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSForValidNoneAlphanumeric()
  {
    userInput = "ls hey_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSForValidNoneAlphanumericForRedirect()
  {
    userInput = "ls hey > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLSTestInvalidFileNameForRedirect()
  {
    userInput = "ls hey > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDNoParam()
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
  public void testCheckUserInputPWDWithRedirectWithNoParam()
  {
    userInput = "pwd >";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirect()
  {
    userInput = "pwd > Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirectWithSlash()
  {
    userInput = "pwd > /Path";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirectWithFullPathWithExtension()
  {
    userInput = "pwd > Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirectWithFullPathWithExtensionVersion2()
  {
    userInput = "pwd > /Path/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithRedirectWithFullPath()
  {
    userInput = "pwd > /Path/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithDoubleRedirect()
  {
    userInput = "pwd >> /Path/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDWithDoubleRedirectWithDotsWithFullPath()
  {
    userInput = "pwd >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDForValidNoneAlphanumericForRedirect()
  {
    userInput = "pwd > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPWDTestInvalidFileNameForRedirect()
  {
    userInput = "pwd > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVwithNoParam()
  {
    userInput = "mv";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWithOneParam()
  {
    userInput = "mv path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWithExtension()
  {
    userInput = "mv hello.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWithMutiParam()
  {
    userInput = "mv path hi.txt lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2Param()
  {
    userInput = "mv path hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPath()
  {
    userInput = "mv path/lol /hello/hey";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithExtension()
  {
    userInput = "mv path/lol.txt /hello/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithRedirection()
  {
    userInput = "mv path/lol /hello/hey > folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithDoubleRedirection()
  {
    userInput = "mv path/lol /hello/hey >> folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithRedirectionWithExtension()
  {
    userInput = "mv path/lol /hello/hey > file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithDoubleRedirectionWithExtension()
  {
    userInput = "mv path/lol /hello/hey >> file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithFullPathRedirection()
  {
    userInput = "mv path/lol /hello/hey > folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVWith2ParamWithFullPathWithFullPathDoubleRedirection()
  {
    userInput = "mv path/lol /hello/hey >> folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVForValidNoneAlphanumericForRedirect()
  {
    userInput = "mv hey yo > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMVTestInvalidFileNameForRedirect()
  {
    userInput = "mv jeu ki > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPwithNoParam()
  {
    userInput = "cp";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWithOneParam()
  {
    userInput = "cp path";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWithOneParamWithExtension()
  {
    userInput = "cp hello.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputWithMutiParam()
  {
    userInput = "cp path hi.txt lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2Param()
  {
    userInput = "cp path hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPath()
  {
    userInput = "cp path/lol /hello/hey";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPathAndExtension()
  {
    userInput = "cp path/lol.txt /hello/hey.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPathWithRedirect()
  {
    userInput = "cp path/lol /hello/hey > folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPathWithDoubleRedirect()
  {
    userInput = "cp path/lol /hello/hey >> folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPathWithFullPathRedirect()
  {
    userInput = "cp path/lol /hello/hey > folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPWith2ParamWithFullPathWithFullPathDoubleRedirect()
  {
    userInput = "cp path/lol /hello/hey >> folder/folder.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPForValidNoneAlphanumericForRedirect()
  {
    userInput = "cp jw we > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCPTestInvalidFileNameForRedirect()
  {
    userInput = "cp qwe wqe > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }  
  @Test
  public void testCheckUserInputCAT()
  {
    userInput = "cat";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithOneParam()
  {
    userInput = "cat file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithOneParamWithExtension()
  {
    userInput = "cat file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithOneParamWithFullPath()
  {
    userInput = "cat folder/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithOneParamWithExtensionWithFullPath()
  {
    userInput = "cat folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithDotsInFullPath()
  {
    userInput = "cat folder/../file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWIth2Param()
  {
    userInput = "cat folder/file file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithMutiParam()
  {
    userInput = "cat file file file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithRedirect()
  {
    userInput = "cat file > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithDoubleRedirect()
  {
    userInput = "cat file >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithFullPathRedirect()
  {
    userInput = "cat file > hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithDoubleFullPathRedirect()
  {
    userInput = "cat file >> hello/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithFullPathRedirectWithExtension()
  {
    userInput = "cat file > hello/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithDoubleFullPathRedirectWithExtension()
  {
    userInput = "cat file >> hello/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATWithDoubleRedirectWithDotsInFullPath()
  {
    userInput = "cat file >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATForValidNoneAlphanumericForRedirect()
  {
    userInput = "cat jw- > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputCATTestInvalidFileNameForRedirect()
  {
    userInput = "cat qwe@ > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETNoParam()
  {
    userInput = "get";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithOneParam()
  {
    userInput = "get http://www.google.ca/";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithMutiParam()
  {
    userInput = "get qwewqe qeweqw";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithWebsiteExtensions()
  {
    userInput = "get http://www.google.ca/hello/apple.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithWebSites()
  {
    userInput = "get www.google.ca/";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithRedirect()
  {
    userInput = "get www.google.ca/ > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithRedirectExtension()
  {
    userInput = "get www.google.ca/ > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithRedirectFullPathExtensions()
  {
    userInput = "get www.google.ca/ > /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithDoubleRedirect()
  {
    userInput = "get www.google.ca/ >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithDoubleRedirectWithExtension()
  {
    userInput = "get www.google.ca/ >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithDoubleRedirectWithFullPath()
  {
    userInput = "get www.google.ca/ >> /root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETWithDoubleRedirectWithFullPathWithDots()
  {
    userInput = "get www.google.ca/ >> root/../hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETInvalidFileName()
  {
    userInput = "get www.google.ca/????/";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGETForValidNoneAlphanumericForRedirect()
  {
    userInput = "get www.google.ca/-_/ > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputGetTestInvalidFileNameForRedirect()
  {
    userInput = "get www.google.ca/-_/ > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithNoParam()
  {
    userInput = "echo";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWith2ParamWithNoQuotes()
  {
    userInput = "echo String";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithString()
  {
    userInput = "echo \"string\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithStringWithRedirect()
  {
    userInput = "echo \"string\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithStringWithFullPathRedirect()
  {
    userInput = "echo \"string\" > hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithStringWithFullPathDoubleRedirect()
  {
    userInput = "echo \"string\" >> hello/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithDoubleRedirect()
  {
    userInput = "echo \"string\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithDoubleRedirectWithFullPath()
  {
    userInput = "echo \"string\" >> hello/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHO1WithDoubleRedirectWithFullPathWithExtension()
  {
    userInput = "echo \"string\" >> hello/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithDoubleRedirectWithFUllPathAndDots()
  {
    userInput = "echo \"string\" >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputECHOWithInvalidParam()
  {
    userInput = "echo \"string\" hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  public void testCheckUserInputECHOWithEmptyString()
  {
    userInput = "echo \"\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputEchoForValidNoneAlphanumericForRedirect()
  {
    userInput = "echo \"string\" > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputEchoTestInvalidFileNameForRedirect()
  {
    userInput = "echo \\\"string\\\" > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMAN()
  {
    userInput = "man";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANCD()
  {
    userInput = "man cd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANEXIT()
  {
    userInput = "man exit";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANMkdir()
  {
    userInput = "man mkdir";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANLs()
  {
    userInput = "man ls";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANPwd()
  {
    userInput = "man pwd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANMV()
  {
    userInput = "man mv";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANCP()
  {
    userInput = "man cp";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANCat()
  {
    userInput = "man cat";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANGet()
  {
    userInput = "man get";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANEcho()
  {
    userInput = "man echo";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANMan()
  {
    userInput = "man man";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANPushd()
  {
    userInput = "man pushd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANPopd()
  {
    userInput = "man popd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANHistory()
  {
    userInput = "man history";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANLoad()
  {
    userInput = "man load";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANFind()
  {
    userInput = "man find";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANTree()
  {
    userInput = "man tree";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANNotCMD()
  {
    userInput = "man NotCMD";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANMutiParam()
  {
    userInput = "man NotCMD somethingelse";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithRedirect()
  {
    userInput = "man cd > lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithRedirectWithExtension()
  {
    userInput = "man cd > lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithRedirectWithFullPath()
  {
    userInput = "man cd > root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithRedirectWithFullPathWithExtension()
  {
    userInput = "man cd > root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithDoubleRedirect()
  {
    userInput = "man cd >> lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithDoubleRedirectWithExtension()
  {
    userInput = "man cd >> lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithDoubleRedirectWithFullPath()
  {
    userInput = "man cd >> root/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithDoubleRedirectWithFullPathWithExtension()
  {
    userInput = "man cd >> root/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputMANWithDoubleRedirectWithFullPathWithDots()
  {
    userInput = "man cd >> folder/../fileName";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputManForValidNoneAlphanumericForRedirect()
  {
    userInput = "man cd > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputManTestInvalidFileNameForRedirect()
  {
    userInput = "man cd > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  @Test
  public void testCheckUserInputPUSHDWithNoParam()
  {
    userInput = "pushd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithOneParam()
  {
    userInput = "pushd file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithOneParamWithExtension()
  {
    userInput = "pushd file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithSlashWithExtension()
  {
    userInput = "pushd /file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithFullPathWithExtension()
  {
    userInput = "pushd /folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithFullPath()
  {
    userInput = "pushd folder/file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithFullPathWithExtensionVersion2()
  {
    userInput = "pushd folder/file.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithFullPathWithDots()
  {
    userInput = "pushd folder/../file";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWith2Param()
  {
    userInput = "pushd folder/file file";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWith3Param()
  {
    userInput = "pushd file file file";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithRedirect()
  {
    userInput = "pushd file > lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithDoubleRedirect()
  {
    userInput = "pushd file >> lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithDoubleRedirectWithDots()
  {
    userInput = "pushd file >> lol/../";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPUSHDWithDoubleRedirectWithDotsInFront()
  {
    userInput = "pushd file >> ../lol";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPD()
  {
    userInput = "popd";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPDMutiParam()
  {
    userInput = "popd anythingelse";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPDWithRedirect()
  {
    userInput = "popd anythingelse > any dir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputPOPDWithDoubleRedirect()
  {
    userInput = "popd anythingelse >> any dir";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYNoParam()
  {
    userInput = "history";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithNoHistory()
  {
    userInput = "history 0";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithOneHistory()
  {
    userInput = "history 1";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithMoreHistoryThanStored()
  {
    userInput = "history 111111111111111111111";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithMutiParam()
  {
    userInput = "history 1111 1111 11111 11111 111";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWith2Param()
  {
    userInput = "history 1 1";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirectWithExtension()
  {
    userInput = "history 1 > lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirect()
  {
    userInput = "history 1 > lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirectWithFullPath()
  {
    userInput = "history 1 > hey/lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirectWithFullPathAndExtension()
  {
    userInput = "history 1 > /hey/lol.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirectWithFullPathAndDots()
  {
    userInput = "history 1 > hello/../lol";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithRedirectWithDots()
  {
    userInput = "history 1 > ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHISTORYWithDoubleRedirect()
  {
    userInput = "history 1 >> ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHistoryForValidNoneAlphanumericForRedirect()
  {
    userInput = "history 1 > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputHistoryTestInvalidFileNameForRedirect()
  {
    userInput = "history 1 > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithNoParam()
  {
    userInput = "save";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithOneParam()
  {
    userInput = "save LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithOneParamWithExtension()
  {
    userInput = "save LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithFullPath()
  {
    userInput = "save root/LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithFullPathVersion2()
  {
    userInput = "save /root/LOL";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithFullPathWithExtension()
  {
    userInput = "save root/LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithFullPathWithExtensionVersion2()
  {
    userInput = "save /root/LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWith2Param()
  {
    userInput = "save root LOL.txt";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithFullPathWithDots()
  {
    userInput = "save /root/../LOL.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithDots()
  {
    userInput = "save ..";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithDotsWithDoubleRedirect()
  {
    userInput = "save .. >> hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputSAVEWithDotsWithRedirect()
  {
    userInput = "save .. > hello";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithNoParam()
  {
    userInput = "load";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithOneParam()
  {
    userInput = "load folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOADWith2Param()
  {
    userInput = "load folder folder";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOADWithExtension()
  {
    userInput = "load load.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOADWithFullPath()
  {
    userInput = "load hey/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOADWithFullPathVersion2()
  {
    userInput = "load /hey/folder";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputLOADWithRedirect()
  {
    userInput = "load hey > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithRedirectWithFullPath()
  {
    userInput = "load hey > root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithRedirectWithFullPathVersion2()
  {
    userInput = "load hey > /root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithDoubleRedirect()
  {
    userInput = "load hey >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithDoubleRedirectWithFullPath()
  {
    userInput = "load hey >> root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLOADWithDoubleRedirectWithFullPathVersion2()
  {
    userInput = "load hey >> /root/hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLoadForValidNoneAlphanumericForRedirect()
  {
    userInput = "load root > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputLoadTestInvalidFileNameForRedirect()
  {
    userInput = "load root > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDNoParam()
  {
    userInput = "find";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFullPath()
  {
    userInput = "find /user/data";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithIncompleteSyntax()
  {
    userInput = "find /user/data -type";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithIncompleteSyntax2()
  {
    userInput = "find /user/data -type d";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithIncompleteSyntax3()
  {
    userInput = "find /user/data -type d - name";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithOneParamForLocation()
  {
    userInput = "find /user/data -type d -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithTwoParamForLocation()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithTwoParamForLocationWithRedirect()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithTwoParamForLocationWithRedirectWithExtension()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithTwoParamForLocationWithRedirectWithFullPath()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithTwoParamForLocationWithRedirectWithFullPath2()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFile()
  {
    userInput = "find /user/data -type f -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWith2Location()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\"";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithRedirect()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithRedirectWithExtension()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithRedirectWithFullPath()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithRedirectWithFullPathVerson2()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" > hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithDoulbeRedirect()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithDoulbeRedirectWithExtension()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithFileWithDoulbeRedirectWithFullPath()
  {
    userInput = "find /user/data /user/data2 -type f -name \"Text\" >> /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithDirectoryWithDoulbeRedirect()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithDirectoryWithDoulbeRedirectWithExtension()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFINDWithDirectoryWithDoulbeRedirectWithFullPath()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" >> /hey/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFindForValidNoneAlphanumericForRedirect()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputFindTestInvalidFileNameForRedirect()
  {
    userInput = "find /user/data /user/data2 -type d -name \"Text\" > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREE()
  {
    userInput = "tree";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithSpaceChar()
  {
    userInput = "tree ";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithMutiParam()
  {
    userInput = "tree Anythingelse";
    assertEquals(false, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithRedirect()
  {
    userInput = "tree > hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithRedirectWithExtension()
  {
    userInput = "tree > hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithRedirectWithFullPath()
  {
    userInput = "tree > root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithDoubleRedirect()
  {
    userInput = "tree >> hello";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithDoubleRedirectWithExtension()
  {
    userInput = "tree >> hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithDoubleRedirectWithFullPath()
  {
    userInput = "tree >> root/hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTREEWithDoubleRedirectWithDotsInFullPath()
  {
    userInput = "tree >> root/../hello.txt";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  
  @Test
  public void testCheckUserInputTreeForValidNoneAlphanumericForRedirect()
  {
    userInput = "tree > hello_";
    assertEquals(true, correct.checkUserInput(userInput));
  }
  @Test
  public void testCheckUserInputTreeTestInvalidFileNameForRedirect()
  {
    userInput = "tree > hello!";
    assertEquals(false, correct.checkUserInput(userInput));
  }
}
