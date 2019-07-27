package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import command.Command;
import commandParameter.CommandParameter;
import driver.JShell;
import output.Output;
import verifier.Verifier;

/**
 * Test Case for Class Man's excute Method
 * 
 * @author Chongmin Bai
 */

public class TestManTest {

  private String acutal;
  private String expected;
  private String userInput;
  private JShell newJShell;



  @Before
  public void setUp() {
    acutal = new String();
    expected = new String();
    userInput = new String();
    newJShell = new JShell();
  }

  @Test
  public void testManExecuteInvalidCMD() {
    userInput = "man jsadsadsad";
    expected =
        "Error: No such CMD exist, check man man for " + "more information\n";

    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteCd() {
    userInput = "man cd";
    expected = "cd: cd DIR\n\tChange the shell's current "
        + "directory to DIR.\n\tDIR must be a valid absolute or "
        + "relative path name.\n\n\tIf DIR begins with a slash (/), "
        + "then it is interpreted\n\tas an absolute path, starting "
        + "from the root directory.\n\tOtherwise, it is interpreted "
        + "as a relative path to the\n" + "\tcurrent directory.\n\n"
        + "\tThe root of the file system is a single slash (/).\n\n"
        + "\t'..' represents the parent directory.\n"
        + "\t'.' represents the current directory.\n\n";


    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteExit() {
    userInput = "man exit";
    expected = "exit: exit" + "\n\t" + "Terminates shell and deletes"
        + " all memory of " + "directory" + "\n\t\t" + "tree, user input"
        + ", directory stack and files.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteMkdir() {
    userInput = "man mkdir";
    expected = "mkdir: mkdir DIR...\n" + "\tCreate new directories\n"
        + "\tDIR must be a valid absolute path name or the name of"
        + " the new directory.\n\n\tIf DIR begins with a slash (/)"
        + ", then it is interpreted\n\tas an absolute path, "
        + "starting from the root directory.\n\tOtherwise, it is "
        + "interpreted as a relative path to the\n\tcurrent "
        + "directory.\n\n\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteLs() {
    userInput = "man ls";
    expected = "ls [PATH ...]"
        + "\n\tIf no paths are given, print the contents (file or directory) "
        + "of the current"
        + "\n\tdirectory, with a new line following each of the content "
        + "(file or directory)."
        + "\n\tOtherwise, for each path p, the order listed:"
        + "\n\t\tIf p specifies a file, print p"
        + "\n\t\tIf p specifies a directory, print p, a colon, then the "
        + "contents of that" + "\n\t\t\tdirectory, then an extra new line."
        + "\n\t\tIf p does not exist, print a suitable message.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecutePwd() {

    userInput = "man pwd";

    expected = "pwd: pwd\n" + "\tprint the absolute path of the current "
        + "working directory\n\n";

    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteMV() {

    userInput = "man mv";
    expected = "mv: mv OLDPATH NEWPATH\n"
        + "\tMove item OLDPATH to NEWPATH. Both OLDPATH\n"
        + "\tand NEWPATH may be relative to the current\n "
        + "\tdirectory or may be full paths. If NEWPATH is a\n"
        + "\tdirectory, move the item into the directory\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteCP() {
    userInput = "man cp";
    expected = "cp: cp OLDPATH NEWPATH\n"
        + "\tCopy item OLDPATH to NEWPATH. Both OLDPATH\n"
        + "\tand NEWPATH may be relative to the current\n "
        + "\tdirectory or may be full paths. If NEWPATH is a\n"
        + "\tdirectory, copy the item into the directory.\n"
        + "\tDoes not remove item OLDPATH\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteCat() {
    userInput = "man cat";
    expected = "cat: cat FILE1 [FILE2...]\n"
        + "\tPrint out contents of the files inputted\n"
        + "\tFILE1 [FILE2...] must be the names of a file.\n\n"
        + "\t3 line breaks seperate the contents if more than"
        + " 1 file name is inputted.\n\n\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteGet() {
    userInput = "man get";
    expected = "get: get URL [(>or>>) OUTFILE]" + "\n\t"
        + "If URL is valid, extract " + "all contents on the associated web"
        + "\n\t\t" + "page and store it onto a File" + " with the same name as"
        + "\n\t\t" + "the URLs file name. Otherwise utilizing" + " redirection,"
        + "\n\t\t" + "add the contents to a new or pre-existing file in"
        + "\n\t\t" + "the FileSystem.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteEcho() {
    userInput = "man echo";
    expected = "echo: echo STRING [(>or>>) OUTFILE]\n\tIf no optional"
        + " arguments are given, print STRING onto shell.\n\t" + "Otherwise;"
        + "\n\t\t" + "If OUTFILE file does not exist," + " create a new file in"
        + "\n\t\t\t" + "OUTFILE path with" + " STRING as its contents."
        + "\n\t\t" + "If OUTFILE file " + "and path exists, and user inputs"
        + "\n\t\t\t" + "argument \">\"," + " then overwrite" + " OUTFILE file"
        + "\n\t\t\t" + "with STRING." + "\n\t\t" + "If OUTFILE file and"
        + " path exists," + " and user inputs" + "\n\t\t\t"
        + "argument \">>\", then " + "append STRING onto" + "\n\t\t\t"
        + "the end of OUTFILE file.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteMan() {
    userInput = "man man";
    expected = "\t\tMan: man CMD\n" + "\tPrint Print documentation for CMD.\n"
        + "\tCMD means commands that we use.\n" + "\tExample: man cat \n"
        + "\tList of all commands\n\n" + "\texit  mkdir   cd      ls    pwd\n"
        + "\tpushd popd    history cat   echo man \n\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecutePushd() {
    userInput = "man pushd";
    expected =
        "pushd: pushd DIR\n" + "\tSaves the current directory by adding it "
            + "to the end of the\n\tdirectory stack. Then, it changes the "
            + "current directory to DIR.\n\n"
            + "\tDIR must be a valid absolute or relative path name.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecutePopd() {
    userInput = "man popd";
    expected = "popd: popd\n\tRemoves the top directory from the directory "
        + "stack and\n\tchanges the working directory to it.\n\n"
        + "\tReturns an error message if directory stack is empty.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteHistory() {
    userInput = "man history";
    expected = "history: history [NUMBER]" + "\n\t" + "If no NUMBER"
        + " is given, print out all user inputs since" + "\n\t\t"
        + "activating JShell, ordered from least recent input to most"
        + "\n\t\t" + "recent input." + "\n\t" + "Otherwise;" + "\n\t\t"
        + "print out the last n user inputs " + "where n is" + " NUMBER >= 0\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  // @Test
  // public void testManExecuteSave() {
  // // to be added
  // }

  @Test
  public void testManExecuteLoad() {
    userInput = "man load";
    expected = "load: load FILE\n\tLoad the contents "
        + "of FILE and update the current shell's state to the state "
        + "saved in FILE, if FILE exists and stores information "
        + "about console state. Load must be the first command "
        + "called in a new console.\nIf FILE's path is not given, "
        + "the default location to search for FILE is the folder Assignmnent2.\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteFind() {
    userInput = "man find";
    expected = "find: find path... -type [f|d] -name expression\n"
        + "\tfind the node named 'expression' in the directories\n"
        + "\tgiven by path. There can be multiple paths given.\n "
        + "\tIf the type is 'f' then find a file with name expression,\n"
        + "\tand if type is 'd' then find a directory with name expression\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }

  @Test
  public void testManExecuteTree() {
    userInput = "man tree";
    expected = "\t\tCommand: Tree"
        + "\tThe Tree Command start from the root directory \n"
        + "\tdisplay the entire file system as a tree. \n"
        + "\tFor every level of the tree, there is an "
        + "\tindent by a tab character\n\n" + "\tExample: \root\n"
        + "\t\tdocement\n" + "\t\t\tsome_file.txt\n" + "\t\tDownload\n\n";
    acutal = execute(userInput, newJShell);
    assertEquals(expected, acutal);
    Output.getOutputInstance().resetOutput();
  }
  private String execute(String userInput, JShell newJShell) {
    Command toBeExecuted = Verifier.checkUserInputCommand(userInput);
    if (toBeExecuted != null) {
      CommandParameter param =
          new CommandParameter(toBeExecuted, newJShell, userInput);
      toBeExecuted.execute(param.getParameters());
    }

    return Output.getOutputInstance().getStringOutput();
  }


}
