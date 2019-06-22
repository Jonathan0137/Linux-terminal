package driver;

public class Ls extends Command
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
  public void execute(JShell shell, String input) 
  {
    String[] userInput = input.split(" ", 2);
    int numOfArg = userInput.length;
    if(numOfArg == 1)
    {
      Directory wd = shell.getCurrentDirectory();
      for(File file  : wd.getListOfFiles())
      {
        System.out.println(file.getName());
      }
      for(Directory dir : wd.getListOfSubdirectories())
      {
        System.out.println(dir.getName());
      }
    }
    else if(numOfArg == 2)
    {
      if(userInput[1].isEmpty()==true)
      {
        Directory wd = shell.getCurrentDirectory();
        for(File file  : wd.getListOfFiles())
        {
          System.out.println(file.getName());
        }
        for(Directory dir : wd.getListOfSubdirectories())
        {
          System.out.println(dir.getName());
        }
      }
      else
      {
        //asdsad
        //asdsad
        
      }
    }
   
  }
}
