package verifier;

import command.*;

public class Verifier {
  /**
   * Check if user's command exist or not, if exist then return 
   * an instance of that command, if not,return null.
   * 
   * @param userInput a string that contains what user has typed
   * @return a instance of command of user's selected commands
   */

  public static Command checkUserInputCommand(String userInput) {
    if (userInput == "")
      return null;
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ", 2);
    String command = input[0];
    if (command.equals("cd") || command.equals("mkdir") || 
        command.equals("pwd")
        || command.equals("ls")) {
      return createDirCommands(command);
    } else if (command.equals("pushd") || command.equals("popd")) {
      return createDirStackCommands(command);
    } else if (command.equals("cat") || command.equals("echo")) {
      return createFilesCommands(command, userInput);
    } else if (command.equals("history") || command.equals("exit") || 
        command.equals("man")) {
      return createOtherCommands(command);
    } else {
      System.out.println("Command not found, please try again");
      return null;
    }
  }

  /**
   * Helper method that check if user's command exist or not, 
   * if exist then return a instance of that command, if not,return null. 
   * Only for Other commands that are left such as history, exit
   * and man.
   * 
   * @param command A String that represents the command to be created
   * @return An instance of command of user's selected commands
   */
  private static Command createOtherCommands(String command) {
    switch (command) {
      case "history":
        return new History();
      case "exit":
        return new Exit();
      case "man":
        return new Man();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }
  }

  /**
   * Helper method that check if user's command exist or not, if exist 
   * then return a instance of that command, 
   * if not,return null. Only for Directory Stack Commands 
   * such as pushd and popd
   * 
   * @param command A String that represents the command to be created
   * @return An instance of command of user's selected commands
   */
  private static Command createFilesCommands(String command, 
      String userInput) {
    switch (command) {
      case "cat":
        return new Cat();
      case "echo":
        if (userInput.contains(">"))
          return new EchoToFile();
        else
          return new EchoToOutput();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }
  }

  /**
   * Helper method that check if user's command exist or not, if exist 
   * then return a instance of that command, if not,
   * return null. Only for Directory Stack Commands such as pushd and popd
   * 
   * @param command A String that represents the command to be created
   * @return An instance of command of user's selected commands
   */
  private static Command createDirStackCommands(String command) {
    switch (command) {
      case "pushd":
        return new Pushd();
      case "popd":
        return new Popd();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }
  }

  /**
   * Helper method that check if user's command exist or not, if exist 
   * then return a instance of that command, if not,
   * return null. Only for DirCommands such as cd, mkdir, pwd and ls
   * 
   * @param command A String that represents the command to be created
   * @return An instance of command of user's selected commands
   */
  private static Command createDirCommands(String command) {
    switch (command) {
      case "cd":
        return new Cd();
      case "mkdir":
        return new Mkdir();
      case "pwd":
        return new Pwd();
      case "ls":
        return new Ls();
      default:
        System.out.println("Command not found, please try again");
        return null;
    }

  }

  /**
   * Check if user input has the correct number of arguments. 
   * if not return false, else return true.
   * 
   * @param userInput      a string that contains what user has typed
   * @return               return true if user enters correct, else false
   */
  public boolean checkUserInput(String userInput) {
    userInput = userInput.replaceAll(" +", " ");
    String[] input = userInput.split(" ");
    int numOfArg = input.length;
    String command = input[0];
    if (command.equals("cd") || command.equals("mkdir") || 
        command.equals("pwd")
        || command.equals("ls")) {
      return checkDirCommands(command, numOfArg);
    } else if (command.equals("pushd") || command.equals("popd")) {
      return checkDirStackCommands(command, numOfArg);
    } else if (command.equals("cat") || command.equals("echo")) {
      return checkFilesCommands(command, numOfArg, userInput);
    } else if (command.equals("history") || command.equals("exit") || 
        command.equals("man")) {
      return checkOtherCommands(command, numOfArg);
    } else {
      System.out.println("Command not found, please try again");
      return false;
    }

  }
  /**
   * Check if user input has the correct number of arguments.
   * if not return false, else return true. 
   * Only for Dir commands such as cd, pwd, mkdir, and ls
   * 
   * @param command    A string that represents the command user want to check
   * @param numOfArg   A integer that represents the number of arguments
   * @return           return true if user enters correct, else false
   */
  private static boolean checkDirCommands(String command, int numOfArg) {
    if (command.equals("cd") && numOfArg > 2) {
      System.out.println("bash cd: too many arguments");
      return false;
    } else if (command.equals("cd") && numOfArg == 1) {
      System.out.println("bash cd: not enough arguments");
      return false;
    } else if (command.equals("pwd") && numOfArg > 1) {
      System.out.println("bash pwd: too many arguments");
      return false;
    } else if (command.equals("mkdir") && numOfArg == 1) {
      System.out.println("bash mkdir: missing directory");
      return false;
    } else {
      return true;
    }
  }
  /**
   * Check if user input has the correct number of arguments.
   * if not return false, else return true. 
   * Only for Dir Stack commands such as pushd and popd
   * 
   * @param command    A string that represents the command user want to check
   * @param numOfArg   A integer that represents the number of arguments
   * @return           return true if user enters correct, else false
   */
  private static boolean checkDirStackCommands(String command, int numOfArg) {
    if (command.equals("pushd") && numOfArg > 2) {
      System.out.println("bash pushd: too many arguments");
      return false;
    } else if (command.equals("popd") && numOfArg != 1) {
      System.out.println("bash: popd: too many arguments");
      return false;
    } else if (command.equals("pushd") && numOfArg == 1) {
      System.out.println("bash: pushd: no other directory");
      return false;
    } else {
      return true;
    }
  }
  /**
   * Check if user input has the correct number of arguments.
   * if not return false, else return true. 
   * Only for Files commands such cat and echo.
   * 
   * @param command    A string that represents the command user want to check
   * @param numOfArg   A integer that represents the number of arguments
   * @param userInput  A string that represents user input
   * @return           return true if user enters correct, else false
   */
  private static boolean checkFilesCommands(String command, int numOfArg, 
      String userInput) {
    if (command.equals("cat") && numOfArg == 1) {
      System.out.println("bash: cat: not enought arguments");
      return false;
    } else if (command.equals("echo")) {
      if (userInput.split("\"").length != 3 && userInput.split("\"").length 
          != 2) {
        System.out.println("bash: echo: invalid input");
        return false;
      }
      if (userInput.split("\"").length == 3) {
        String input2 = userInput.split("\"")[2];
        if (input2.contains(">") == false && input2.contains(">>") == false) {
          System.out.println("bash: echo: invalid input");
          return false;
        } else {
          if (input2.contains(">>")) {
            if (input2.split(">>").length == 1) {
              System.out.println("bash: echo: invalid input");
              return false;
            }
          } else if (input2.contains(">")) {
            if (input2.split(">").length == 1) {
              System.out.println("bash: echo: invalid input");
              return false;
            }
          }
        }
      }
    } 
    return true;
  }
  /**
   * Check if user input has the correct number of arguments.
   * if not return false, else return true. 
   * Only for other commands such as exit, history and man.
   * 
   * @param command    A string that represents the command user want to check
   * @param numOfArg   A integer that represents the number of arguments
   * @return           return true if user enters correct, else false
   */
  private static boolean checkOtherCommands(String command, int numOfArg) {
    if (command.equals("exit") && numOfArg > 1) {
      System.out.println("bash exit: too many arguments");
      return false;
    } else if (command.equals("history") && numOfArg > 2) {
      System.out.println("bash: history: too many arguments");
      return false;
    } else if (command.equals("man") && numOfArg == 1) {
      System.out.println("What manual page do you want?");
      return false;
    } else if (command.equals("man") && numOfArg > 2) {
      System.out.println("bash: man: too many arguments");
      return false;
    } else {
      return true;
    }
  }

}
