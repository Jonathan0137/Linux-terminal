// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student2:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student3:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student4:
// UTORID user_name:
// UT Student #:
// Author:
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import java.util.Scanner;

public class JShell {
	private Directory directoryTree;
	private DirectoryStack directoryHistory;
	private InputHistory userInputHistory;
	private Exit exitStatus; 
	
	public JShell() {
		directoryTree = new Directory();
		directoryHistory = new DirectoryStack();
		userInputHistory = new InputHistory();
		exitStatus = new Exit();
	}

	public static void main(String[] args) {
		JShell newJShell = new JShell();
		while (!newJShell.exitStatus.exitCheck) {
			Scanner input = new Scanner(System.in);
			String userInput = input.nextLine();
			input.close();
			System.out.println(userInput);
			newJShell.exitStatus.exitShell();
		}

  }

}
