package inputHistory;

import java.util.ArrayList; 

public class InputHistory {
	/**
	 * A list of all user inputs
	 */
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
	 * @param toAdd A String representation of a user's input
	 */
	public void addToHistory(String toAdd) {
		this.inputList.add(toAdd);
	}
	
	/**
	 * Returns the list of all user inputs stored within 
	 * the InputHistory object
	 * @return this.inputList the ArrayList<String> instance variable
	 */
	public ArrayList<String> getInputList(){
		return this.inputList;
	}
}
