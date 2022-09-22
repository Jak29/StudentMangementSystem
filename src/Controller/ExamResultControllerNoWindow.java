// Had to remove pop up window to be able to test in junit because junit can't click okay and was getting stopped

package Controller;

import View.Display;

public class ExamResultControllerNoWindow {
	
	private static Display display = new Display();

	public ExamResultControllerNoWindow() {}	
	
	public boolean verifyExamResult(String examResult, String moduleID, String studentID)
	{
		boolean state = false;
		try {
			if (!examResult.matches("[0-9]+") || examResult == "" || examResult == "null" || Integer.valueOf(examResult) < 0 || Integer.valueOf(examResult) > 100) {

			} else if (!moduleID.matches("[0-9]+") || moduleID == "" || moduleID == "null") {

			} else if (!studentID.matches("[0-9]+") || studentID == "" || studentID == "null") { 

			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public boolean verifyRemoveExamResult(String moduleID, String studentID)
	{
		boolean state = false;
		try {
			if (!moduleID.matches("[0-9]+") || moduleID == "" || moduleID == "null" ||  Integer.valueOf(moduleID) < 0) {

			} else if (!studentID.matches("[0-9]+") || studentID == "" || studentID == "null" ||  Integer.valueOf(studentID) < 0) {

			} else {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		return state;
	}
	
}
