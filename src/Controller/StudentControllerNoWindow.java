// Had to remove pop up window to be able to test in junit because junit can't click okay and was getting stopped

package Controller;

import View.Display;

public class StudentControllerNoWindow {
	
	private Display display = new Display(); 
	
	public StudentControllerNoWindow() {};
	
	public boolean verifyStudent(String name, String id, String dob)
	{
		boolean state = false;
		try {
			if (!(name.matches("[ a-zA-Z]+")) || name == "" || name == "null") {
			} else if (!id.matches("[0-9]+") || id == "" || id == "null" ||  Integer.valueOf(id) < 0) {
			} else if (dob == "" || dob == "null") {
			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		return state;
	}
	
	public boolean verifyRemoveStudent(String id)
	{
		boolean state = false;
		try {
			if (!id.matches("[0-9]+") || id == "" || id == "null" ||  Integer.valueOf(id) < 0) {
			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		return state;
	}
    
}