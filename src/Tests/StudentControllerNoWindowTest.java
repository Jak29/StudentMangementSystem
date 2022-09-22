package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Controller.*;

public class StudentControllerNoWindowTest {

	// verifyStudent()
	@Test
	public void verifyStudentValidInputs() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("Jak", "1", "01-01-2022");
		assertTrue(result);
		
	}
	
	@Test
	public void verifyStudentInvalidName() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("1", "1", "01-01-2022");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyStudentInvalidID() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("Jak", "Jak", "01-01-2022");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyStudentEmptyName() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("", "1", "01-01-2022");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyStudentEmptyID() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("Jak", "", "01-01-2022");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyStudentEmptyDOB() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyStudent("Jak", "1", "");
		assertFalse(result);
		
	}
	
	// verifyRemoveStudent()
	@Test
	public void verifyRemoveValidID() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyRemoveStudent("1");
		assertTrue(result);
				
	}
	
	@Test
	public void verifyRemoveInvalidID() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyRemoveStudent("a");
		assertFalse(result);
				
	}
	
	@Test
	public void verifyRemoveEmptyID() {
		
		StudentControllerNoWindow studentControl = new StudentControllerNoWindow();
		
		boolean result = studentControl.verifyRemoveStudent("");
		assertFalse(result);
				
	}

}
