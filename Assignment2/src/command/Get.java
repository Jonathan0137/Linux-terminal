package command;

import driver.JShell;

public class Get extends Command {

	@Override
	public void execute(JShell shell, String input) {
		String userParam = Get.cleanInput(input);
		if (Get.getChecker(input)) {
			try {
				
			}
			catch (Exception e) {
				
			}
		}
	}

	@Override
	protected String getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean getChecker(String input) {
		int inputSize = input.split(" ").length;
		if (inputSize != 2 && inputSize != 4) {
			//MAKE OUTPUT CLASS HOLD ERROR STRING!
			return false;
		}
		try {
			String specialChar = input.split(" ")[2];
			if (!specialChar.contentEquals(">") || 
					!specialChar.contentEquals(">>")) {
				//MAKE OUTPUTCLASS HOLD ERROR STRING
				return false;
			}
		}
		catch (Exception e) {
			return true;
		}
		return true;
	}
}
