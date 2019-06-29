package driver;

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
      case "cd":
        Cd cd = new Cd();
        System.out.println(cd.getDoc());
        break;
      case "mkdir":
        Mkdir mkdir = new Mkdir();
        System.out.println(mkdir.getDoc());
        break;
      case "pwd":
        Pwd pwd = new Pwd();
        System.out.println(pwd.getDoc());
        break;
      case "pushd":
        Pushd pushd = new Pushd();
        System.out.println(pushd.getDoc());
        break;
      case "history":
        History history = new History();
        System.out.println(history.getDoc());
        break;
      case "ls":
        Ls ls = new Ls();
        System.out.println(ls.getDoc());
        break;
      case "exit":
        Exit exit = new Exit();
        System.out.println(exit.getDoc());
        break;
      case "popd":
        Popd popd = new Popd();
        System.out.println(popd.getDoc());
        break;
      case "cat":
        Cat cat = new Cat();
        System.out.println(cat.getDoc());
        break;
      case "echo":
          EchoToOutput echo2 = new EchoToOutput();
          System.out.println(echo2.getDoc());
        break;
      case "man":
        Man man = new Man();
        System.out.println(man.getDoc());
        break;
      default:
        System.out.println("No such CMD exist, check man man for more information");
        break;
    }
  }

}
