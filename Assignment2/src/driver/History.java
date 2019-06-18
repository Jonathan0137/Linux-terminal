package driver;

import java.util.ArrayList;

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
			if (History.historyCheck(splitInput[1],
					shell.getInputHistory().getInputList())) {
				for (int i=shell.getInputHistory().getInputList().size()-1; 
						i>-1 && i>=shell.getInputHistory().getInputList().size()
						-Integer.parseInt(splitInput[1]); i--) {
					System.out.print(i+1);
					System.out.print(". ");
					System.out.println(shell.
							getInputHistory().getInputList().get(i));
				}
			}
		}
	}
	
	public static boolean historyCheck(String argument,
			ArrayList<String> list) {
		try {
			int cap = Integer.parseInt(argument);
			if (cap>list.size()) {
				return false;
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("The second parameter; '"+ argument+
					"' is not an integer");
			return false;
		}
	}
	
}
