package driver;

import java.util.ArrayList; //ASK IF WE CAN DO THIS

public class InputHistory {
	private ArrayList<String> inputList;
	
	/**
	 * The constructor
	 */
	public InputHistory() {
		inputList = new ArrayList<String>();
	}
	/**
	 * Adds the string representation of a user's input at the end of the
	 * list
	 * @param toAdd
	 */
	public void addToHistory(String toAdd) {
		this.inputList.add(toAdd);
	}
}
