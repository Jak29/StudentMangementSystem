// Had to remove pop up window to be able to test in junit because junit can't click okay and was getting stopped

package Controller;

import View.Display;

public class ModuleControllerNoWindow {
	
	private static Display display = new Display();

	public ModuleControllerNoWindow() {}	
	
	public boolean verifyModule(String name, String id)
	{
		boolean state = false;
		try {
			if (!id.matches("[0-9]+") || id == "" || id == "null") {
				
			} else if (!(name.matches("[ a-zA-Z]+")) || name == "" || name == "null") {

			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		return state;
	}
	
	public boolean verifyRemoveModule(String id)
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
