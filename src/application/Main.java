package application;
	
import View.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Display display = new Display();
	
	public void start(Stage primaryStage) {

		display.start(primaryStage);		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
