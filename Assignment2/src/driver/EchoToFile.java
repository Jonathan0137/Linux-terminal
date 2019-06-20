package driver;

public class EchoToFile extends Command {

	@Override
	public void execute(JShell shell, String path) {
		String[] inputSplit = path.split(" ");
		if (EchoToFile.EchoToFileCheck(shell, path) == ) {
			
		}
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static int EchoToFileCheck(JShell shell, String input) {
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
				if (shell.getDirectoryTree().getDirectory(input.split(" ")[4]) 
						!= null) {
					return 1;
				}
				
				else if (shell.getCurrentDirectory().findDirectory(input.
						split(" ")[4]) != null) {
					return 2;
				}
				
				else {
					return 3;
				}
			}
		}
		return -1;
	}

}
