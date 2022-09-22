package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Controller.*;

public class ModuleControllerNoWindowTest {

	// verifyModule()
	@Test
	public void verifyModuleValidInputs() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyModule("English", "1");
		assertTrue(result);
		
	}
	
	@Test
	public void verifyModuleInvalidName() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyModule("1", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyModuleInvalidID() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyModule("English", "English");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyModuleEmptyName() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyModule("", "1");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyModuleEmptyID() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyModule("English", "");
		assertFalse(result);
		
	}
	
	// verifyRemoveModule()
	@Test
	public void verifyRemoveValidID() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyRemoveModule("1");
		assertTrue(result);
		
	}
	
	@Test
	public void verifyRemvoveInvalidID() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyRemoveModule("a");
		assertFalse(result);
		
	}
	
	@Test
	public void verifyRemvoveEmptyID() {
		
		ModuleControllerNoWindow moduleControl = new ModuleControllerNoWindow();
		
		boolean result = moduleControl.verifyRemoveModule("");
		assertFalse(result);
		
	}

}
