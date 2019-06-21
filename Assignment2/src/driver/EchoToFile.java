package driver;

import java.util.ArrayList;

public class EchoToFile extends Command {
	
	/**
	 * The constructor
	 */
	public EchoToFile() {
		doc = "Allows user to print onto shell, overwrite, add onto and create"
				+ " new text files using an inputed string";
	}
	
	/**
	 * Creates or modifies text files that will contain the user input string
	 */
	@Override
	public void execute(JShell shell, String path) {
		//String[] inputSplit = path.split(" ");
		int inputCase = EchoToFile.echoToFileCheck(shell, path); 
		if (inputCase == 1) {
			String[] outfileSplit = path.split(" ")[4].split("/");
			String realPath = "/";
			for (int i=0; i<outfileSplit.length-2; i++) {
				realPath = realPath.concat(outfileSplit[i] + "/");
			}
			File txtFile = shell.getDirectoryTree().getDirectory(realPath)
					.findFile(outfileSplit[outfileSplit.length-1]);
			txtFile.setContents(path.split(" ")[2]);
		}
		
		else if (inputCase == 2) {
			String[] outfileSplit = path.split(" ")[4].split("/");
			String realPath = "/";
			for (int i=0; i<outfileSplit.length-2; i++) {
				realPath = realPath.concat(outfileSplit[i] + "/");
			}
			Directory destination = shell.getDirectoryTree()
					.getDirectory(realPath);
			File txtFile = new File(outfileSplit[outfileSplit.length-1], path.
					split(" ")[2]); //create txtfile
			//ASK IF I NEED TO CHANGE FILE's FULL PATH N TINGZ USING METHODS IN FILE.JAVA
			destination.addFile(txtFile);
		}
		
		else if (inputCase == 3) {
			shell.getCurrentDirectory().findFile(path.split(" ")
					[path.split(" ").length-1]).setContents(path.split(" ")[2]);
		}
		
		else if (inputCase == 4) {
			File txtFile = new File(path.split(" ")[path.split(" ").length-1], 
					path.split(" ")[2]);
			shell.getCurrentDirectory().addFile(txtFile);
			//ASK IF I NEED TO CHANGE FILE's FULL PATH N TINGZ USING METHODS IN FILE.JAVA
		}
		
		else if (inputCase == 5) {
			String[] outfileSplit = path.split(" ")[4].split("/");
			String realPath = "/";
			for (int i=0; i<outfileSplit.length-2; i++) {
				realPath = realPath.concat(outfileSplit[i] + "/");
			}
			File txtFile = shell.getDirectoryTree().getDirectory(realPath)
					.findFile(outfileSplit[outfileSplit.length-1]);
			txtFile.setContents(txtFile.getContents()
					.concat(path.split(" ")[2])); //ASK IF I NEED TO ADD A NEW LINE OR A SPACE OR SUM
		}
		
		else if (inputCase == 6) {
			shell.getCurrentDirectory().findFile(path.split(" ")
					[path.split(" ").length-1])
			.setContents(shell.getCurrentDirectory().findFile(path.split(" ")
					[path.split(" ").length-1]).getContents().
					concat(path.split(" ")[2]));
		}
	}

	/**
	 * Returns the Echo command documentation
	 * @return this.doc The documentation for the Echo
	 */
	protected String getDoc() {
		// TODO Auto-generated method stub
		return this.doc;
	}
	
	/**
	 * Verifies that command call is valid, determines which valid case is 
	 * related to the user input and returns an integer representation of that
	 * case
	 * @param shell An instance of the JShell 
	 * @param input A string representation of a user input
	 * @return int That tells execute() what option is used in Echo call
	 */
	public static int echoToFileCheck(JShell shell, String input) {

		if (input.split(" ").length < 4) {
			System.out.println("echo: missing outfile or string arguments");
			return -1;
		}
		
		else {
			if (input.split("\"").length != 3) {
				System.out.println("echo: incorrect number of input strings");
				return -1;
			}
			
			String[] extractString = input.split("\"");
			String[] echoInput = extractString[1].split(" ");
			String[] optionalInput = extractString[3].split(" ");
			ArrayList<String> inputIntoSections = null;
			inputIntoSections.add(echoInput[1]);
			inputIntoSections.add(extractString[2]);
			
			if (echoInput.length != 1) {
				System.out.println("echo: wrong order of arguments");
				return -1;
			}
			
			else if (optionalInput.length != 2) {
				System.out.println("echo: wrong number of "
						+ "arguments for outfile");
				return -1;
			}
			
			else if (optionalInput[1] == ">") {
				if (optionalInput[2].split("/").length > 1) {
					String[] outfileFullPath = optionalInput[2].split("/");
					String path = "/";
					for (int i=0; i<outfileFullPath.length-2; i++) {
						path = path.concat(outfileFullPath[i] + "/");
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (shell.getDirectoryTree().getDirectory(path)
								.findFile(outfileFullPath[outfileFullPath
								                          .length-1]) != null) {
							return 1;
						}
						else return 2; //i.e file dne
					}
					else { //i.e path does not exist What do i do
						System.out.println("echo: input path does not exist");
						return -1;
					}
				}
				
				else if (shell.getCurrentDirectory().findFile(optionalInput[2])
						!= null) {
					return 3; //i.e file exists
				}
				
				else {
					return 4; //i.e file dne
				}
			}
			
			//NOW FOR ">>"
			else if (optionalInput[1] == ">>") {
				if (optionalInput[2].split("/").length > 1) {
					String[] outfileFullPath = optionalInput[2].split("/");
					String path = "/";
					for (int i=0; i<outfileFullPath.length-2; i++) {
						path = path.concat(outfileFullPath[i] + "/");
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (shell.getDirectoryTree().getDirectory(path)
								.findFile(outfileFullPath[outfileFullPath
								                          .length-1]) != null) {
							return 5;
						}
						else return 2; //i.e file dne
					}
					else { //i.e path does not exist What do i do
						System.out.println("echo: input path does not exist");
						return -1;
					}
				}
				
				else if (shell.getCurrentDirectory().findFile(optionalInput[2])
						!= null) {
					return 6; //i.e file exists
				}
				
				else {
					return 4; //i.e file dne
				}
			}
		}
		return -1;
	}

}
