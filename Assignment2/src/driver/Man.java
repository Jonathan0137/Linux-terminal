package driver;

public class Man extends Command
{
  @Override
  public String getDoc() {
    String documentation = "cd: cd DIR\n";
//                         + "\tChange the shell's current directory to DIR.\n"
//                         + "\tDIR must be a valid absolute or relative path name.\n\n"
//                         + "\tIf DIR begins with a slash (/), then it is interpreted\n"
//                         + "\tas an absolute path, starting from the root directory.\n"
//                         + "\tOtherwise, it is interpreted as a relative path to the\n"
//                         + "\tcurrent directory.\n\n"
//                         + "\tThe root of the file system is a single slash (/).\n\n"
//                         + "\t'..' represents the parent directory.\n"
//                         + "\t'.' represents the current directory.\n";
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
      case "pwd":
        Pwd pwd = new Pwd();
        System.out.println(pwd.getDoc());
      case "pushd":
        Pushd pushd = new Pushd();
        System.out.println(pushd.getDoc());
      case "history":
        History history = new History();
        System.out.println(history.getDoc());
      case "ls":
        Ls ls = new Ls();
        System.out.println(ls.getDoc());
      case "exit":
        Exit exit = new Exit();
        System.out.println(exit.getDoc());
      case "popd":
        Popd popd = new Popd();
        System.out.println(popd.getDoc());
      case "cat":
        Cat cat = new Cat();
        System.out.println(cat.getDoc());
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
      case "man":
        Man man = new Man();
        System.out.println(man.getDoc());
    }
  }

}
