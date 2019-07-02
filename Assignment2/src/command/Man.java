package command;

import driver.JShell;

public class Man extends Command
{
  /**
   * Returns a String containing the documentation 
   * for the functionalities of the 'man' command.
   * 
   * @return the documentation of the 'man' command
   */
  @Override
  public String getDoc() {
    String documentation = "\t\tMan: man CMD\n"
                         + "\tPrint Print documentation for CMD.\n"
                         + "\tCMD means commands that we use.\n"
                         + "\tExample: man cat \n"
                         + "\tList of all commands\n\n"
                         + "\texit  mkdir   cd      ls    pwd\n"
                         + "\tpushd popd    history cat   echo man \n";
    return documentation;
  }
  /**
   * Print documentation of selected commands
   * 
   * @param shell   an instance of the JShell that is interacting with user
   * @param input   a relative or absolute path name
   */
  @Override
  public void execute(JShell shell ,String input)
  {
    String[] userInput = input.split(" ", 2);
    String command = userInput[1];
    if (command.equals("cd") || command.equals("mkdir") || 
        command.equals("pwd")|| command.equals("ls")) {
      printDirDocs(command);
    } else if (command.equals("pushd") || command.equals("popd")) {
      printDirStackDocs(command);
    } else if (command.equals("cat") || command.equals("echo")) {
      printFilesDocs(command);
    } else if (command.equals("history") || command.equals("exit") || 
        command.equals("man")) {
      printOtherDocs(command);
    }
    else
    {
      System.out.println("No such CMD exist, check man man for "
          + "more information");
    }    
  }
  /**
   * Helper Method
   * Print documentation for Dir commands such as cd, mkdir, pwd, and ls
   * 
   * @param commandName   an String that represents the name of the command
   */
  private static void printDirDocs(String commandName)
  {
    switch(commandName)
    {
      case "cd":
        System.out.println(new Cd().getDoc());
        break;
      case "mkdir":
        System.out.println(new Mkdir().getDoc());
        break;
      case "pwd":
        System.out.println(new Pwd().getDoc());
        break;
      case "ls":
        System.out.println(new Ls().getDoc());
        break;
    }
  }
  /**
   * Helper Method
   * Print documentation for Dir Stack commands such as pushd and popd
   * 
   * @param commandName   an String that represents the name of the command
   */
  private static void printDirStackDocs(String commandName)
  {
    switch(commandName)
    {
      case "pushd":
        System.out.println(new Pushd().getDoc());
        break;
      case "popd":
        System.out.println(new Popd().getDoc());
        break;
    }
  }
  /**
   * Helper Method
   * Print documentation for file commands such as cat and echo
   * 
   * @param commandName   an String that represents the name of the command
   */
  private static void printFilesDocs(String commandName)
  {
    switch(commandName)
    {
      case "cat":
        System.out.println(new Cat().getDoc());
        break;
      case "echo":
          System.out.println(new EchoToOutput().getDoc());
        break;
    }
  }
  /**
   * Helper Method
   * Print documentation for other commands such as exit, history and man
   * 
   * @param commandName   an String that represents the name of the command
   */
  private static void printOtherDocs(String commandName)
  {
    switch(commandName)
    {
      case "exit":
        System.out.println(new Exit().getDoc());
        break;
      case "history":
        System.out.println(new History().getDoc());
        break;
      case "man":
        System.out.println(new Man().getDoc());
        break;
    }
  }
}
