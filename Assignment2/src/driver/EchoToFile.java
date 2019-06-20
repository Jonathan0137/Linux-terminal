package driver;

public class EchoToFile extends Command {

	@Override
	public void execute(JShell shell, String path) {
		//String[] inputSplit = path.split(" ");
		
		if (EchoToFile.echoToFileCheck(shell, path) == 1) {
			String[] outfileSplit = path.split(" ")[4].split("/");
			String realPath = "/";
			for (int i=0; i<outfileSplit.length-2; i++) {
				realPath = realPath.concat(outfileSplit[i] + "/");
			}
			File txtFile = shell.getDirectoryTree().getDirectory(realPath)
					.findFile(outfileSplit[outfileSplit.length-1]);
			txtFile.setContents(path.split(" ")[2]);
		}
		
		else if (EchoToFile.echoToFileCheck(shell, path) == 2) {
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
		
		else if (EchoToFile.echoToFileCheck(shell, path) == 3) {
			shell.getCurrentDirectory().findFile(path.split(" ")
					[path.split(" ").length-1]).setContents(path.split(" ")[2]);
		}
		
		else if (EchoToFile.echoToFileCheck(shell, path) == 4) {
			File txtFile = new File(path.split(" ")[path.split(" ").length-1], 
					path.split(" ")[2]);
			shell.getCurrentDirectory().addFile(txtFile);
			//ASK IF I NEED TO CHANGE FILE's FULL PATH N TINGZ USING METHODS IN FILE.JAVA
		}
		
		else if (EchoToFile.echoToFileCheck(shell, path) == 5) {
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
		
		
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static int echoToFileCheck(JShell shell, String input) {
		if (input.split(" ").length < 4) {
			System.out.println("echo: missing outfile or string arguments");
			return -1;
		}
		
		else if (input.split(" ").length > 4) {
			System.out.println("echo: too many arguments");
			return -1;
		}
		
		else {
			if (input.split("\"").length != 3) {
				System.out.println("echo: incorrect number of input strings");
				return -1;
			}
			
			else if (input.split(" ")[2].indexOf('\"', 0) != 0 && 
					input.split(" ")[2].indexOf('\"', 
							input.split(" ").length -1) != 
							input.split(" ").length -1) {
						System.out.println
						("echo: order of arguments is invalid");
						return -1;
			}
			
			else if (input.split(" ")[3] == ">") {
				if (input.split(" ")[4].split("/").length > 2) {
					String[] outfileSplit = input.split(" ")[4].split("/");
					String path = "/";
					for (int i=0; i<outfileSplit.length-2; i++) {
						path = path.concat(outfileSplit[i] + "/");
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (shell.getDirectoryTree().getDirectory(path)
								.findFile(outfileSplit[outfileSplit.length-1]) 
								!= null) {
							return 1;
						}
						else return 2; //i.e file dne
					}
					else { //i.e path does not exist What do i do
						System.out.println("echo: input path does not exist");
						return -1;
					}
				}
				
				else if (shell.getCurrentDirectory().findFile(input.
						split(" ")[4]) != null) {
					return 3; //i.e file exists
				}
				
				else {
					return 4; //i.e file dne
				}
			}
			
			//NOW FOR ">>"
			else if (input.split(" ")[3] == ">>") {
				if (input.split(" ")[4].split("/").length > 2) {
					String[] outfileSplit = input.split(" ")[4].split("/");
					String path = "/";
					for (int i=0; i<outfileSplit.length-2; i++) {
						path = path.concat(outfileSplit[i] + "/");
					}
					if (shell.getDirectoryTree().getDirectory(path) != null) {
						if (shell.getDirectoryTree().getDirectory(path)
								.findFile(outfileSplit[4]) != null) {
							return 5;
						}
						else return 6; //i.e file dne
					}
					else { //i.e path does not exist What do i do
						System.out.println("echo: input path does not exist");
						return -1;
					}
				}
				
				else if (shell.getCurrentDirectory().findFile(input.
						split(" ")[4]) != null) {
					return 7; //i.e file exists
				}
				
				else {
					return 8; //i.e file dne
				}
			}
		}
		return -1;
	}

}
