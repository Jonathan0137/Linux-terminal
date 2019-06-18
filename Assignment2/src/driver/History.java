package driver;

public class History extends Command {

	public void execute(JShell shell, String input) {
		String[] splitInput = input.split(" ");
		if (splitInput.length == 1) {
			for (int i=0; i<.length(); i++) {
				System.out.println(); //To complete
			}
		}
		else {
			for (int i=0; i<.length() && 
					i<Integer.parseInt(splitInput[1]); i++) {
				System.out.println(); //To complete
			}
		}
	}

}
