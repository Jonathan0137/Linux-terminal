package inputHistory;

import java.util.ArrayList; 

/**
 * InputHistory class is in charge of remembering all user inputs.
 * @author Tom Daudelin
 *
 */
public class InputHistory {
	/**
	 * A list of all user inputs
	 */
	private ArrayList<String> inputList;
	
	/**
	 * A static instance of the InputHistory
	 */
	private static InputHistory history = null;
	
	/**
	 * The constructor
	 */
	private InputHistory() {
		inputList = new ArrayList<String>();
	}
	
	public static InputHistory getInputHistory() {
		if (history == null) {
			history = new InputHistory();
		}
		return history;
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
