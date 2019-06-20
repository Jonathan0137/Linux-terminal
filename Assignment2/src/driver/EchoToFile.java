package driver;

public class EchoToFile extends Command {

	@Override
	public void execute(JShell shell, String path) {
		String[] inputSplit = path.split(" ");
		if (EchoToFile.EchoToFileCheck(shell, path) == 1) {
			
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
								.findFile(outfileSplit[4]) != null) {
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
		}
		return -1;
	}

}
