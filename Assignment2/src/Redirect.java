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
	
	public static boolean checkRedirection(String redirectCall) {
		if (redirectCall.split(" ")[0].contentEquals(">") ||
				redirectCall.split(" ")[0].contentEquals(">>")) {
			return true;
		}
		return false;
	}
	
	public static File getRedirection(FileSystem fileSystem, 
			String potentialCall) {
		File returnTo = null;
		return returnTo;
	}
		
	
}
