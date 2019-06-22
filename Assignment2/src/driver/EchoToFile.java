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
		
		int inputCase = EchoToFile.echoToFileCheck(shell, path); 
		if (inputCase != -1) {
			String[] extractString = path.split("\"");
			String[] optionalInput = extractString[2].split(" ");
			String[] outfileFullPath = optionalInput[2].split("/");
			String fullPath = "/";
			for (int i=0; i<outfileFullPath.length-1; i++) {
				if (!outfileFullPath[i].equals("")) {
					fullPath = path.concat(outfileFullPath[i]);
					fullPath = path.concat("/");
				}
			}
			if (inputCase == 1) {
				File txtFile = shell.getDirectoryTree().getDirectory(fullPath)
						.findFile(outfileFullPath[outfileFullPath.length-1]);
				txtFile.setContents(extractString[1]);
			}
			
			else if (inputCase == 2) {
				Directory destination = shell.getDirectoryTree()
						.getDirectory(fullPath);
				File txtFile = new File(outfileFullPath
						[outfileFullPath.length-1], extractString[1]);
				//ASK IF I NEED TO CHANGE FILE's FULL PATH N TINGZ USING METHODS IN FILE.JAVA
				destination.addFile(txtFile);
			}
			
			else if (inputCase == 3) {
				shell.getCurrentDirectory()
				.findFile(optionalInput[2]).setContents(extractString[1]);
			}
			
			else if (inputCase == 4) {
				File txtFile = new File(optionalInput[2], extractString[1]);
				shell.getCurrentDirectory().addFile(txtFile);
				//ASK IF I NEED TO CHANGE FILE's FULL PATH N TINGZ USING METHODS IN FILE.JAVA
			}
			
			else if (inputCase == 5) {
				File txtFile = shell.getDirectoryTree().getDirectory(fullPath)
						.findFile(outfileFullPath[outfileFullPath.length-1]);
				txtFile.setContents(txtFile.getContents()
						.concat(extractString[1])); //ASK IF I NEED TO ADD A NEW LINE OR A SPACE OR SUM
			}
			
			else if (inputCase == 6) {
				shell.getCurrentDirectory().findFile(optionalInput[2])
				.setContents(shell.getCurrentDirectory()
						.findFile(optionalInput[2])
						.getContents().concat(extractString[1]));
			}
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
			String[] echoInput = extractString[0].split(" ");
			String[] optionalInput = extractString[2].split(" ");
			
			if (echoInput.length != 1) {
				System.out.println("echo: wrong order of arguments");
				return -1;
			}
			
			if (optionalInput.length != 3) {
				System.out.println("echo: wrong number of "
						+ "arguments for outfile");
				return -1;
			}
			
			if (optionalInput[1].equals(">")) { 
				if (optionalInput[2].split("/").length > 2) {
					String[] outfileFullPath = optionalInput[2].split("/");
					String path = "/";
					for (int i=0; i<outfileFullPath.length-1; i++) {
						if (!outfileFullPath[i].equals("")) {
							path = path.concat(outfileFullPath[i]);
							path = path.concat("/");
						}
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (EchoToFile.findFileByName(shell.getDirectoryTree()
								.getDirectory(path), 
								outfileFullPath[outfileFullPath
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
				
				else if (EchoToFile.findFileByName(shell.getCurrentDirectory(), 
						optionalInput[2]) != null) {
					return 3; //i.e file exists
				}
				
				else {
					return 4; //i.e file dne
				}
			}
			
			//NOW FOR ">>"
			if (optionalInput[1].equals(">>")) {
				if (optionalInput[2].split("/").length > 2) {
					String[] outfileFullPath = optionalInput[2].split("/");
					String path = "/";
					for (int i=0; i<outfileFullPath.length-1; i++) {
						if (!outfileFullPath[i].equals("")) {
							path = path.concat(outfileFullPath[i] + "/");
						}
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (EchoToFile.findFileByName(shell.getDirectoryTree()
								.getDirectory(path), 
								outfileFullPath[outfileFullPath
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
				
				else if (EchoToFile.findFileByName(shell.getCurrentDirectory(), 
						optionalInput[2]) != null) {
					return 6; //i.e file exists
				}
				
				else {
					return 4; //i.e file dne
				}
			}
		}
		return -1;
	}

	/**
	 * Adds a new file into a specified directory
	 * @param target The target directory in which we want to add a new file
	 * @param newFile The new file that is to be added into the target directory
	 */
	public static void addFile(Directory target, File newFile) {
		target.getListOfFiles().add(newFile);
	}
	
	/**
	 * Finds a file by name in a specific directory
	 * @param location The target directory
	 * @param fileName The name of the sought out file
	 * @return fileList.get(i) The file with same name as fileName
	 */
	public static File findFileByName(Directory location, String fileName) {
		ArrayList<File> fileList = location.getListOfFiles();
		for (int i=0; i<fileList.size()-1;i++) {
			if (fileList.get(i).getName().equals(fileName)) {
				return fileList.get(i);
			}
		}
		return null;
	}
	
}
