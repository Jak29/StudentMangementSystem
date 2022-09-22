package Controller;

import View.Display;

public class ExamResultController {
	
	private static Display display = new Display();

	public ExamResultController() {}	

	/** Verify the parameters entered so they are valid to create an exam result
	 * 
	 * @param examResult The grade for a student in a module
	 * @param moduleID A unique identifier for a module
	 * @param studentID A unique identifier for a student
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyExamResult(String examResult, String moduleID, String studentID)
	{
		// State is false by default and changed to true if all parameters are valid
		boolean state = false;
		try {
			// Check if examResult is valid
			if (!examResult.matches("[0-9]+") || examResult == "" || examResult == "null" || Integer.valueOf(examResult) < 0 || Integer.valueOf(examResult) > 100) {
				display.verify("Invalid Input", "Your input for exam result was invalid");
			// Check if moduleID is valid
			} else if (!moduleID.matches("[0-9]+") || moduleID == "" || moduleID == "null") {
				display.verify("Invalid Input", "Your input for module id was invalid");
			// Check if studentID is valid	
			} else if (!studentID.matches("[0-9]+") || studentID == "" || studentID == "null") { 
				display.verify("Invalid Input", "Your input for student id was invalid");
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
	 * @param moduleID A unique identifier for a module
	 * @param studentID A unique identifier for a student
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyRemoveExamResult(String moduleID, String studentID)
	{
		// State is false by default and changed to true if all parameters are valid
		boolean state = false;
		try {
			// Check if moduleID is valid
			if (!moduleID.matches("[0-9]+") || moduleID == "" || moduleID == "null" ||  Integer.valueOf(moduleID) < 0) {
				display.verify("Invalid Input", "Your input for moduleID was invalid");
			// Check if studentID is valid
			} else if (!studentID.matches("[0-9]+") || studentID == "" || studentID == "null" ||  Integer.valueOf(studentID) < 0) {
				display.verify("Invalid Input", "Your input for studentID was invalid");
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
