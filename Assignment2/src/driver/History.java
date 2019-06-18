package driver;

public class History extends Command {
	
	public void execute(JShell shell, String input) {
		String[] splitInput = input.split(" ");
		if (splitInput.length == 1) {
			for (int i=0; 
					i<shell.getInputHistory().getInputList().size(); i++) {
				System.out.print(i+1);
				System.out.print(". ");
				System.out.println(shell.
						getInputHistory().getInputList().get(i));
			}
		}
		else {
			if (History.historyCheck(splitInput[1])) {
				for (int i=0; i<shell.getInputHistory().getInputList().size() 
						&& i<Integer.parseInt(splitInput[1]); i++) {
					System.out.print(i+1);
					System.out.print(". ");
					System.out.println(shell.
							getInputHistory().getInputList().get(i));
				}
			}
		}
	}
	
	public static boolean historyCheck(String argument) {
		try {
			Integer.parseInt(argument);
			return true;
		}
		catch(Exception e) {
			System.out.println("The second parameter; '"+ argument+
					"' is not an integer");
			return false;
		}
	}
	
}
