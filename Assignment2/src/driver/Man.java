package driver;

public class Man extends Command
{
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
  
  public void execute(JShell shell ,String commandName)
  {
    String[] input = commandName.split(" ", 2);
    String docClass = input[1];
    switch(docClass)
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
//      case "cat":
//        Cat cat = new Cat();
//        System.out.println(cat.getDoc());
        //break;
      case "echo":
        if(commandName.contains(">"))
        {
          EchoToFile echo1 = new EchoToFile();
          System.out.println(echo1.getDoc());
        }
        else
        {
          EchoToOutput echo2 = new EchoToOutput();
          System.out.println(echo2.getDoc());
        }
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
