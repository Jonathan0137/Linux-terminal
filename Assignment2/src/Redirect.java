import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;

public class Redirect {
	private static File outputTo = null;
	
	/*private Redirect(String fileName, Directory location) {
		outputTo = new File(fileName);
		outputTo.setParentDirectory(location);
	}
	
	public static File createRedirection() {
		if (Redirect.outputTo == null) {
			Redirect(fileName, location);
		}
	}*/
	
	public static void resetRedirection() {
		Redirect.outputTo = null;
	}
	
	public static boolean checkRedirection(String input) {
		int situation = 0;
		String[] splitInput = input.split(" ");
		for (int i=0; i<splitInput.length; i++) {
			if (splitInput[i].contentEquals(">") || 
					splitInput[i].contentEquals(">>")) {
				situation = 1;
				break;
			}
		}
		if (situation == 1) {
			String potentialCall = Redirect.getRedirectCall(input);
			if (potentialCall.split(" ")[0].contentEquals(">") ||
					potentialCall.split(" ")[0].contentEquals(">>")) {
				return true;
			}
			//RAISE ERROR AND APPEND ERROR MESSAGE TO OUTPUT CLASS
			throw Exception; //UNFINISHED DONT KNOW HOW TO FULLY CALL
			
		}
		return false;
	}
	
	public static void redirect(FileSystem fileSystem, 
			String userInput, String text) {
		
	}
		
	public static String getRedirectCall(String userInput) {
		String[] splitInput = userInput.split(" ");
		String call = splitInput[splitInput.length-1]
				.concat(" "+splitInput[splitInput.length-2]);
		return call;
	}
}
