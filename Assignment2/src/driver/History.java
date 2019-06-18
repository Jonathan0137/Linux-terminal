package driver;

public class History extends Command {

	public void execute(JShell shell, String input) {
		String[] splitInput = input.split(" ");
		if (splitInput.length == 1) {
			for (int i=0; 
					i<shell.getInputHistory().getInputList().size(); i++) {
				System.out.print(i+1);
				System.out.print(". ");
				System.out.print(shell.getInputHistory().getInputList().get(i));
			}
		}
		else {
			if (History.historyCheck(input)) {
				for (int i=0; i<shell.getInputHistory().getInputList().size() 
						&& i<Integer.parseInt(splitInput[1]); i++) {
					System.out.print(i+1);
					System.out.print(". ");
					System.out.print(shell.getInputHistory().getInputList().get(i));
				}
			}
		}
	}
	
	
	
}
