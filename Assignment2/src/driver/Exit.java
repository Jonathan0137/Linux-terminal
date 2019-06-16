package driver;

public class Exit {
	private boolean status;
	
	public Exit() {
		status = false;
	}
	
	public exitShell() {
		this.status = true;
	}
	
	public boolean exitCheck() {
		return this.status;
	}
}
