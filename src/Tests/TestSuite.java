package Tests;

import Controller.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.*;

@RunWith(Suite.class)

@SuiteClasses({
	StudentControllerNoWindowTest.class,
	ModuleControllerNoWindowTest.class,
	ExamResultControllerNoWindowTest.class
})

public class TestSuite {
}
