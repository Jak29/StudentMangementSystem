package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Controller.*;

public class ExamResultControllerNoWindowTest {

	// verifyExamResult()
	@Test
	public void verifyExamResultValidInputs() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("80", "1", "1");
		assertTrue(result);
		
	}
	
	@Test
	public void verifyExamResultInvalidResult() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("a", "1", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultInvalidModuleID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("80", "a", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultInvalidStudentID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("80", "1", "a");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultEmptyResult() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("", "1", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultEmptyModuleID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("80", "", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultEmptyStudentID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("80", "1", "");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultResultUnderBounds() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("-1", "1", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyExamResultResultAboveBounds() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyExamResult("101", "1", "1");
		assertFalse(result);
		
	}
	
	// verifyRemoveExamResult()
	@Test
	public void verifyRemoveValidInputs() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyRemoveExamResult("1", "1");
		assertTrue(result);
				
	}
	
	@Test
	public void verifyRemoveInvalidModuleID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyRemoveExamResult("a", "1");
		assertFalse(result);
				
	}
	
	@Test
	public void verifyRemoveInvalidStudentID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyRemoveExamResult("1", "a");
		assertFalse(result);
				
	}
	
	@Test
	public void verifyRemoveEmptyModuleID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyRemoveExamResult("", "1");
		assertFalse(result);
				
	}
	
	@Test
	public void verifyRemoveEmptyStudentID() {
		
		ExamResultControllerNoWindow examResultControl = new ExamResultControllerNoWindow();
		
		boolean result = examResultControl.verifyRemoveExamResult("1", "");
		assertFalse(result);
				
	}

}
