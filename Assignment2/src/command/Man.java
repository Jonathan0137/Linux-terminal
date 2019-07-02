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
   * @param shell   an instance of the JShell that is interacting with the user
   * @param input   a relative or absolute path name
   */
  @Override
  public void execute(JShell shell ,String input)
  {
    String[] userInput = input.split(" ", 2);
    String commandName = userInput[1];
    
    switch(commandName)
    {
      case "exit":
        System.out.println(new Exit().getDoc());
        break;
      case "mkdir":
        System.out.println(new Mkdir().getDoc());
        break;
      case "cd":
        System.out.println(new Cd().getDoc());
        break;
      case "ls":
        System.out.println(new Ls().getDoc());
        break;
      case "pwd":
        System.out.println(new Pwd().getDoc());
        break;
      case "pushd":
        System.out.println(new Pushd().getDoc());
        break;
      case "popd":
        System.out.println(new Popd().getDoc());
        break;
      case "history":
        System.out.println(new History().getDoc());
        break;
      case "cat":
        System.out.println(new Cat().getDoc());
        break;
      case "echo":
          System.out.println(new EchoToOutput().getDoc());
        break;
      case "man":
        System.out.println(new Man().getDoc());
        break;
      default:
        System.out.println("No such CMD exist, check man man for more information");
        break;
    }
    
  }
  public void printDirDocs(String commandName)
  {
    
  }

}
