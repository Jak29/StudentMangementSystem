package Controller;

import View.Display;

public class ModuleController {
	
	private static Display display = new Display();

	public ModuleController() {}	
	
	/** Verify the parameters entered so they are valid to create a module
	 * 
	 * @param name The name for the module
	 * @param id The unique id for the module
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyModule(String name, String id)
	{
		// State is false by default and changed to true if all parameters are valid
		boolean state = false;
		try {
			// Check if id is valid
			if (!id.matches("[0-9]+") || id == "" || id == "null") {
				display.verify("Invalid Input", "Your input for id was invalid");
			// Check if name is valid
			} else if (!(name.matches("[ a-zA-Z]+")) || name == "" || name == "null") {
				display.verify("Invalid Input", "Your input for name was invalid");
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
	 * @param id The unique id for the module
	 * @return True if inputs are valid and false if inputs are invalid
	 */
	public boolean verifyRemoveModule(String id)
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
