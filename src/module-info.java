module Assignment1 {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
