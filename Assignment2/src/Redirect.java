import fileSystem.Directory;
import fileSystem.File;

public class Redirect {
	private static File outputTo = null;
	
	private Redirect(String fileName, Directory location) {
		outputTo = new File(fileName);
		outputTo.setParentDirectory(location);
	}
	
	public static File createRedirection() {
		if (Redirect.outputTo == null) {
			Redirect(fileName, location);
		}
	}
	
	public static void resetRedirection() {
		Redirect.outputTo = null;
	}
}
