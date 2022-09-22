package Controller;

import View.Display;

public class StudentController {
	
	private Display display = new Display(); 
	
	public StudentController() {};
	
	/** Verify the parameters entered so they are valid to create a student
	 * 
	 * @param name The name for the student
	 * @param id The unique id for the student
	 * @param dob The students date of birth
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyStudent(String name, String id, String dob)
	{
		// State is false by default and changed to true if all parameters are valid
		boolean state = false;
		try {
			// Check if name is valid
			if (!(name.matches("[ a-zA-Z]+")) || name == "" || name == "null") {
				display.verify("Invalid Input", "Your input for name was invalid");
			// Check if id is valid
			} else if (!id.matches("[0-9]+") || id == "" || id == "null" ||  Integer.valueOf(id) < 0) {
				display.verify("Invalid Input", "Your input for id was invalid");
			// Check if dob is valid
			} else if (dob == "" || dob == "null") {
				display.verify("Invalid Input", "Your input for date of birth was invalid");
			// If its valid change the state to true
			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		// Return the state
		return state;
	}
	
	/** Verify if the parameters entered so they are valid to remove an exam result
	 * 
	 * @param id The unique id for the student
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyRemoveStudent(String id)
	{
		// State is false by default and changed to true if id is valid
		boolean state = false;
		try {
			// Check if id is valid
			if (!id.matches("[0-9]+") || id == "" || id == "null" ||  Integer.valueOf(id) < 0) {
				display.verify("Invalid Input", "Your input for id was invalid");
			// If its valid change the state to true
			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		// Return the state
		return state;
	}
    
}