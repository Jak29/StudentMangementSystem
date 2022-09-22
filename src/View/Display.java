package View;
	
import java.util.List;

import Controller.*;
import Model.*;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.CornerRadii;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.paint.*;


public class Display extends Application {
	
	private static StudentController studentControl = new StudentController();
	private static ModuleController moduleControl = new ModuleController();
	private static ExamResultController examResultControl = new ExamResultController();
	public static DBConnection connection = new DBConnection();
	
	public Display() {
		
	}
	
	public void start(Stage primaryStage) {
		try {
		
		primaryStage.setTitle("Jak Cullinane");   
		Group root = new Group();     // layout pane  
		Scene scene = new Scene(root, 550, 320);     
		TabPane tabPane = new TabPane();
		BorderPane mainPane = new BorderPane();
		
		tabPane.setSide(Side.LEFT);
		
		
		//Buttons
		Button addBtn = new Button("Add");
		Button removeBtn = new Button("Remove");
		Button addModuleBtn = new Button("Add");
		Button removeModuleBtn = new Button("Remove");
		Button addExamResultBtn = new Button("Add");
		Button removeExamResultBtn  = new Button("Remove");
		Button editStudentBtn = new Button ("Edit");

		Button displayAllBtn = new Button("All");
		Button displayStudentBtn = new Button("Student");
		Button displayHonorsBtn = new Button("Honors");
		Button quitBtn = new Button("Quit");
				
		//Labels
		Label nameLbl = new Label("Name");	
		Label idLbl = new Label("Student ID");	
		Label dobLbl = new Label("Date of Birth");
		Label moduleNameLbl = new Label("Module Name");
		Label moduleIDLbl = new Label("Module ID");
		Label examResultModuleIDLbl = new Label("Module ID");
		Label examResultStudentIDLbl = new Label("Student ID");
		Label examResultLbl = new Label ("Grade");
		Label studentIDLbl = new Label ("Student ID");
		Label editNameLbl = new Label("Name");	
		Label editIDLbl = new Label("Student ID");	
		Label editDOBLbl = new Label("Date of Birth");
		
		// Textfields
		TextField nameTxtField = new TextField();
		TextField idTxtField = new TextField();
		TextField moduleNameTxtField = new TextField();
		TextField moduleIDTxtField = new TextField();
		TextField examResultModuleIDTxtField = new TextField();
		TextField examResultStudentIDTxtField = new TextField();
		TextField examResultTxtField = new TextField();
		TextField studentIDTxtField = new TextField("Student ID");
		TextField editNameTxtField = new TextField();
		TextField editIDTxtField = new TextField();
		
		// Calendar
		DatePicker dobCalendar = new DatePicker();
		DatePicker editDOBCalendar = new DatePicker();
		
		// Textarea
		TextArea listTextArea = new TextArea();
		
		// Actions
		// Add Student
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				 if (studentControl.verifyStudent(nameTxtField.getText(), idTxtField.getText(), String.valueOf(dobCalendar.getValue()))) {
					 
					 String name = nameTxtField.getText();
					 int id = Integer.valueOf(idTxtField.getText());
					 String dob = String.valueOf(dobCalendar.getValue());
					 connection.addStudent(id, name ,dob);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		 });
		
		// Add Module
	 	addModuleBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 
				 if (moduleControl.verifyModule(moduleNameTxtField.getText(), moduleIDTxtField.getText())) {
					 
					 String name = moduleNameTxtField.getText();
					 int id = Integer.valueOf(moduleIDTxtField.getText());
					 connection.addModule(id, name);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		});
	 	
		// Add Exam Result
	 	addExamResultBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {

				 if (examResultControl.verifyExamResult(examResultTxtField.getText(), examResultModuleIDTxtField.getText(),  examResultStudentIDTxtField.getText())) {
					 
					 int examResult = Integer.valueOf(examResultTxtField.getText());
					 int moduleID = Integer.valueOf(examResultModuleIDTxtField.getText());
					 int studentID = Integer.valueOf(examResultStudentIDTxtField.getText());
					 connection.addExamResult(moduleID, studentID, examResult);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		});
	 	
	 // Edit Student
	 	 	editStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
	 			 public void handle(ActionEvent event) {

	 				if (studentControl.verifyStudent(editNameTxtField.getText(), editIDTxtField.getText(), String.valueOf(editDOBCalendar.getValue()))) {
						 
						 String name = editNameTxtField.getText();
						 int id = Integer.valueOf(editIDTxtField.getText());
						 String dob = String.valueOf(editDOBCalendar.getValue());
						 connection.editStudent(id, name ,dob);
						 
					 } else {
						 System.out.println("Error");
					 }
					 
	 			 }
	 		});
		
		// Remove Student
		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {

				if (studentControl.verifyRemoveStudent(idTxtField.getText())) {
					 
					 int id = Integer.valueOf(idTxtField.getText());
					 connection.removeStudent(id);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		});
		
		// Remove Module
		removeModuleBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {

				if (moduleControl.verifyRemoveModule(moduleIDTxtField.getText())) {
					 
					 int id = Integer.valueOf(moduleIDTxtField.getText());
					 connection.removeModule(id);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		});
		
		// Remove Exam Result
		removeExamResultBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {

				if (examResultControl.verifyRemoveExamResult(examResultModuleIDTxtField.getText(), examResultStudentIDTxtField.getText())) {
					 
					 int moduleID = Integer.valueOf(moduleIDTxtField.getText());
					 int studentID = Integer.valueOf(studentIDTxtField.getText());
					 connection.removeExamResult(moduleID, studentID);
					 
				 } else {
					 System.out.println("Error");
				 }
				 
			 }
		});
		
		// Display All
		displayAllBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 
				 List<Student> students = connection.getAllStudents();
				 String displayStudents = "NAME | ID | DOB\n===========\n\n";
				 
				 for (int i = 0; i < students.size(); i++) {
					 displayStudents += students.get(i);
				 }
 		
				 listTextArea.setText(displayStudents);
				 
			 }
		});
		
		// Display Student
		displayStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 
				 List<String> students = connection.getStudent(Integer.valueOf(studentIDTxtField.getText()));
				 String displayStudents = "NAME | ID | DOB\n===========\n\n";
				 
				 displayStudents += students.get(0);
 		
				 listTextArea.setText(displayStudents);
				 
			 }
		});
		
		// Display Honors
		displayHonorsBtn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 
				 List<String> students = connection.getStudentHonors(Integer.valueOf(studentIDTxtField.getText()));
				 String displayStudents = "NAME | GRADE\n===========\n\n";
				 
				 for (int i = 0; i < students.size(); i++) {
					 displayStudents += students.get(i);
				 }
 		
				 listTextArea.setText(displayStudents);
				 
			 }
		});
		
		// Quit
		quitBtn.setOnAction(e-> System.exit(0));
	 	
		// Visual adjustments
		nameLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		nameLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		idLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		idLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		dobLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		dobLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		moduleNameLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		moduleNameLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		moduleIDLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		moduleIDLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		examResultLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		examResultLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		examResultModuleIDLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		examResultModuleIDLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		examResultStudentIDLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		examResultStudentIDLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		studentIDLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		studentIDLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		editNameLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		editNameLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		editIDLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		editIDLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		editDOBLbl.setFont(Font.font(STYLESHEET_CASPIAN, 15));
		editDOBLbl.setStyle("-fx-font-weight: bold;-fx-text-fill: black");
		
		addBtn.setPrefSize(150, 20);
		removeBtn.setPrefSize(150, 20);
		addModuleBtn.setPrefSize(150, 20);
		removeModuleBtn.setPrefSize(150, 20);
		addExamResultBtn.setPrefSize(150, 20);
		removeExamResultBtn.setPrefSize(150, 20);
		displayAllBtn.setPrefSize(90, 20);
		displayStudentBtn.setPrefSize(90, 20);
		displayHonorsBtn.setPrefSize(90, 20);
		quitBtn.setPrefSize(90, 20);
		editStudentBtn.setPrefSize(150, 20);

		
		addBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		removeBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		addModuleBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		removeModuleBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		addExamResultBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		removeExamResultBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		displayAllBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		displayStudentBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		displayHonorsBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		quitBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		editStudentBtn.setStyle("-fx-border-color: white;-fx-background-color:white;-fx-font-size: 13;-fx-font-weight: bold;");
		
		nameTxtField.setPrefWidth(120);
		idTxtField.setPrefWidth(120);
		dobCalendar.setPrefWidth(120);
		moduleNameTxtField.setPrefWidth(120);
		moduleIDTxtField.setPrefWidth(120);
		examResultTxtField.setPrefWidth(120);
		examResultModuleIDTxtField.setPrefWidth(120);
		examResultStudentIDTxtField.setPrefWidth(120);
		studentIDTxtField.setPrefSize(120, 30);
		editNameTxtField.setPrefWidth(120);
		editIDTxtField.setPrefWidth(120);
		editDOBCalendar.setPrefWidth(120);
		
		listTextArea.setPrefSize(425, 200);
		listTextArea.setStyle("-fx-background-color: black; -fx-control-inner-background: black; -fx-text-fill: lightgreen;");
		
		// Hboxes and VBoxes (Layout)
		HBox nameHbox = new HBox();
		nameHbox.getChildren().add(nameTxtField);
	
		VBox nameVbox = new VBox();
        nameVbox.setPadding(new Insets (10));
        nameVbox.setSpacing(10);
        nameVbox.getChildren().addAll(nameLbl, nameHbox);
		
        HBox idHbox = new HBox();
		idHbox.getChildren().add(idTxtField);
		
        VBox idVbox = new VBox();
        idVbox.setPadding(new Insets (10));
        idVbox.setSpacing(10);
        idVbox.getChildren().addAll(idLbl, idHbox);
        
        HBox dobHbox = new HBox();
		dobHbox.getChildren().add(dobCalendar);
        
        VBox dobVbox = new VBox();
        dobVbox.setPadding(new Insets (10));
        dobVbox.setSpacing(10);
        dobVbox.getChildren().addAll(dobLbl, dobHbox);
        
        VBox entryVbox = new VBox();
        entryVbox.setPadding(new Insets (20, 50, 0, 50));
        entryVbox.setSpacing(10);
        entryVbox.getChildren().addAll(nameVbox, idVbox, dobVbox);
        
        
        HBox moduleNameHbox = new HBox();
        moduleNameHbox.getChildren().add(moduleNameTxtField);
        
        VBox moduleNameVbox = new VBox();
        moduleNameVbox.setPadding(new Insets (10));
        moduleNameVbox.setSpacing(10);
        moduleNameVbox.getChildren().addAll(moduleNameLbl, moduleNameHbox);
        
        HBox moduleIDHbox = new HBox();
        moduleIDHbox.getChildren().add(moduleIDTxtField);
        
        VBox moduleIDVbox = new VBox();
        moduleIDVbox.setPadding(new Insets (10));
        moduleIDVbox.setSpacing(10);
        moduleIDVbox.getChildren().addAll(moduleIDLbl, moduleIDHbox);
        
        VBox moduleEntryVbox = new VBox();
        moduleEntryVbox.setPadding(new Insets (20, 50, 0, 50));
        moduleEntryVbox.setSpacing(10);
        moduleEntryVbox.getChildren().addAll(moduleNameVbox, moduleIDVbox);
        
        
        HBox examResultHbox = new HBox();
        examResultHbox.getChildren().add(examResultTxtField);
	
		VBox examResultVbox = new VBox();
		examResultVbox.setPadding(new Insets (10));
		examResultVbox.setSpacing(10);
		examResultVbox.getChildren().addAll(examResultLbl, examResultHbox);
		
        HBox examResultModuleIDHbox = new HBox();
        examResultModuleIDHbox.getChildren().add(examResultModuleIDTxtField);
		
        VBox examResultModuleIDVbox = new VBox();
        examResultModuleIDVbox.setPadding(new Insets (10));
        examResultModuleIDVbox.setSpacing(10);
        examResultModuleIDVbox.getChildren().addAll(examResultModuleIDLbl, examResultModuleIDHbox);
        
        HBox examResultStudentIDHbox = new HBox();
        examResultStudentIDHbox.getChildren().add(examResultStudentIDTxtField);
		
        VBox examResultStudentIDVbox = new VBox();
        examResultStudentIDVbox.setPadding(new Insets (10));
        examResultStudentIDVbox.setSpacing(10);
        examResultStudentIDVbox.getChildren().addAll(examResultStudentIDLbl, examResultStudentIDHbox);
        
        VBox examResultEntryVbox = new VBox();
        examResultEntryVbox.setPadding(new Insets (20, 50, 0, 50));
        examResultEntryVbox.setSpacing(10);
        examResultEntryVbox.getChildren().addAll(examResultVbox, examResultModuleIDVbox, examResultStudentIDVbox);

        
        HBox studentIDHbox = new HBox();
        studentIDHbox.getChildren().add(studentIDTxtField);
        
        HBox quitHbox = new HBox();
        quitHbox.setPadding(new Insets (10, 0, 0, 385));
        quitHbox.getChildren().add(quitBtn);
        
        
        HBox editNameHbox = new HBox();
		editNameHbox.getChildren().add(editNameTxtField);
	
		VBox editNameVbox = new VBox();
		editNameVbox.setPadding(new Insets (10));
		editNameVbox.setSpacing(10);
		editNameVbox.getChildren().addAll(editNameLbl, editNameHbox);
		
        HBox editIDHbox = new HBox();
        editIDHbox.getChildren().add(editIDTxtField);
		
        VBox editIDVbox = new VBox();
        editIDVbox.setPadding(new Insets (10));
        editIDVbox.setSpacing(10);
        editIDVbox.getChildren().addAll(editIDLbl, editIDHbox);
        
        HBox editDOBHbox = new HBox();
        editDOBHbox.getChildren().add(editDOBCalendar);
        
        VBox editDOBVbox = new VBox();
        editDOBVbox.setPadding(new Insets (10));
        editDOBVbox.setSpacing(10);
        editDOBVbox.getChildren().addAll(editDOBLbl, editDOBHbox);
        
        VBox editStudentVbox = new VBox();
        editStudentVbox.setPadding(new Insets (20, 50, 0, 50));
        editStudentVbox.setSpacing(10);
        editStudentVbox.getChildren().addAll(editIDVbox, editNameVbox, editDOBVbox);
        
        
        VBox button1Vbox = new VBox();
        button1Vbox.setPadding(new Insets(60));
		button1Vbox.getChildren().addAll(addBtn, removeBtn);
        button1Vbox.setSpacing(30);
        
        VBox button2Vbox = new VBox();
		button2Vbox.setPadding(new Insets (60));
		button2Vbox.getChildren().addAll(addModuleBtn, removeModuleBtn);
        button2Vbox.setSpacing(30);
        
        VBox button3Vbox = new VBox();
		button3Vbox.setPadding(new Insets (60));
		button3Vbox.getChildren().addAll(addExamResultBtn, removeExamResultBtn);
        button3Vbox.setSpacing(30);
       
        HBox button4Hbox = new HBox();
		button4Hbox.setPadding(new Insets (20, 50, 0, 50));
		button4Hbox.getChildren().addAll(studentIDHbox, displayAllBtn, displayStudentBtn, displayHonorsBtn);
        button4Hbox.setSpacing(10);
        
        VBox button5Vbox = new VBox();
        button5Vbox.setPadding(new Insets(60));
		button5Vbox.getChildren().addAll(editStudentBtn);
        button5Vbox.setSpacing(30);
		
		HBox textAreaHbox = new HBox();
		textAreaHbox.setPadding(new Insets (20, 50, 0, 50));
		textAreaHbox.getChildren().addAll(listTextArea);
        textAreaHbox.setSpacing(10);
		
     
		HBox tab1 = new HBox();
		tab1.getChildren().addAll(entryVbox, button1Vbox);
		
		HBox tab2 = new HBox();
		tab2.getChildren().addAll(moduleEntryVbox, button2Vbox);
		
		HBox tab3 = new HBox();
		tab3.getChildren().addAll(examResultEntryVbox, button3Vbox);
		
		VBox tab4 = new VBox();
		tab4.getChildren().addAll(button4Hbox, textAreaHbox, quitHbox);
		
		HBox tab5 = new HBox();
		tab5.getChildren().addAll(editStudentVbox, button5Vbox);
		
        
		// Creating Background
		Background background = new Background(
                new BackgroundFill(
                        new LinearGradient(0, 0, 0, 1, true,
                                CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#4568DC")),
                                new Stop(1, Color.web("#B06AB3"))
                        ), CornerRadii.EMPTY, Insets.EMPTY
                ),
                new BackgroundFill(
                        new ImagePattern(
                                new Image("https://edencoding.com/resources/wp-content/uploads/2021/02/Stars_128.png"),
                                0, 0, 128, 128, false
                        ), CornerRadii.EMPTY, Insets.EMPTY
                ),
                new BackgroundFill(
                        new RadialGradient(
                                0, 0, 0.5, 0.5, 0.5, true,
                                CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#FFFFFF33")),
                                new Stop(1, Color.web("#00000033"))),
                        CornerRadii.EMPTY, Insets.EMPTY
                )
        );
        
		// Creating VBox with the background as content
		VBox tabABackground = new VBox();
        tabABackground.setBackground(background);
		
        VBox tabBBackground = new VBox();
        tabBBackground.setBackground(background);
        
        VBox tabCBackground = new VBox();
        tabCBackground.setBackground(background);
        
        VBox tabDBackground = new VBox();
        tabDBackground.setBackground(background);
		
        VBox tabEBackground = new VBox();
        tabEBackground.setBackground(background);
    
        // Adding Background and Content to tabs
        StackPane tabAContent = new StackPane(tabABackground, tab1);
  
        StackPane tabBContent = new StackPane(tabBBackground, tab2);
        
        StackPane tabCContent = new StackPane(tabCBackground, tab3);
        
        StackPane tabDContent = new StackPane(tabDBackground, tab4);
        
        StackPane tabEContent = new StackPane(tabEBackground, tab5);
        
              
        //Create Student Tab
		Tab tabA = new Tab("Tab A");
		
		tabA.setContent(tabAContent);
		tabA.setClosable(false);
		tabA.setText("Student ");
		tabPane.getTabs().add(tabA);
		
		// Create Module Tab
		Tab tabB = new Tab();  
		tabB.setContent(tabBContent);
		tabB.setText("Modules "); 
		tabB.setClosable(false);          
		tabPane.getTabs().add(tabB);    
		
		// Create Exam Result Tab
		Tab tabC = new Tab();  
		tabC.setContent(tabCContent);
		tabC.setText("Exam Results "); 
		tabC.setClosable(false);          
		tabPane.getTabs().add(tabC);  
		
		// Create Display Tab
		Tab tabD = new Tab();  
		tabD.setContent(tabDContent);
		tabD.setText("Display "); 
		tabD.setClosable(false);          
		tabPane.getTabs().add(tabD);  
		
		// Create Edit Tab
		Tab tabE = new Tab();  
		tabE.setContent(tabEContent);
		tabE.setText(" Edit "); 
		tabE.setClosable(false);          
		tabPane.getTabs().add(tabE); 
		
        
		
        // Display
        mainPane.setCenter(tabPane);      
     	mainPane.prefHeightProperty().bind(scene.heightProperty());      
     	mainPane.prefWidthProperty().bind(scene.widthProperty()); 
        root.getChildren().add(mainPane);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("https://img.icons8.com/office/344/fire-element.png"));
        primaryStage.show();
        
        // Close Connection to Database

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** Used to display a pop up window that will display the error when a verification has failed
	 * 
	 * @param title The type of error
	 * @param message A more detailed explanation of the error
	 */
	public void verify(String title, String message) { 
		// this is static so it can be used without instantiating an object of this class		
		// we can call this method from other classes
		
		Stage window = new Stage();
		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton = new Button("Close this window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		//Display window and wait for it to be closed before returning
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		}
	
}
