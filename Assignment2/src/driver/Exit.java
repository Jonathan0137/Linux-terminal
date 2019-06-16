package driver;

public class Exit {
	private boolean status;
	
	public Exit() {
		status = false;
	}
	
	/**
	 * Sets exit status to true in order to notify JShell to exit
	 */
	public void exitShell() {
		this.status = true;
	}
	
	/**
	 * Return the value of instance variable status 
	 * @return this.status the status of JShell's exit condition
	 */
	public boolean exitCheck() {
		return this.status;
	}
}
