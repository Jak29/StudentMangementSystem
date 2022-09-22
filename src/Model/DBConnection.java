package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import View.Display;


public class DBConnection {
	
	
   private static final String URL = "jdbc:derby:..\\R00202208 JakCullinane\\derbyDB";
   private Display display = new Display();
   
   private Connection connection = null; // manages connection
 
   // Add Statements
   private PreparedStatement addStudent = null; 
   private PreparedStatement addModule = null;
   private PreparedStatement addExamResult = null;
   
   // Remove Statements
   private PreparedStatement removeStudent = null;
   private PreparedStatement removeStudentExamResult = null;
   private PreparedStatement removeModule = null;
   private PreparedStatement removeModuleExamResult = null;
   private PreparedStatement removeExamResult = null;
   
   // Select Statements
   private PreparedStatement selectAllStudents = null;
   private PreparedStatement selectStudent = null;
   private PreparedStatement selectStudentHonors = null;   
   
   // Edit Statements
   private PreparedStatement editStudent = null;
	
	
	public DBConnection(){
		// constructor
		try 
	      {
	         connection = DriverManager.getConnection( URL );
	         System.out.println("SUCCESSFULLY CONNECTED");
	         
	         // Select Statements
	         selectAllStudents = connection.prepareStatement( "SELECT * FROM STUDENT" );
	         selectStudent = connection.prepareStatement( "SELECT * FROM STUDENT WHERE ID = (?)" );
	         selectStudentHonors = connection.prepareStatement( "SELECT MODULE.NAME, EXAMRESULT.RESULT FROM MODULE INNER JOIN EXAMRESULT ON MODULE.ID = EXAMRESULT.MODULEID WHERE EXAMRESULT.STUDENTID = (?) AND EXAMRESULT.RESULT >= 70");
	         
	         // Add Statements
	         addStudent = connection.prepareStatement( "INSERT INTO STUDENT (ID, NAME, DATEOFBIRTH) VALUES ( ?, ?, ? )" );
	         addModule = connection.prepareStatement("INSERT INTO MODULE (ID, NAME) VALUES (?, ? )" );
	         addExamResult = connection.prepareStatement("INSERT INTO EXAMRESULT (MODULEID, STUDENTID, RESULT) VALUES (?, ?, ?)");
	         
	         // Remove Statements
	         removeStudent = connection.prepareStatement("DELETE FROM STUDENT WHERE ID = (?)");
	         removeStudentExamResult = connection.prepareStatement("DELETE FROM EXAMRESULT WHERE STUDENTID = (?)");
	         removeModule = connection.prepareStatement("DELETE FROM MODULE WHERE ID = (?)");
	         removeModuleExamResult = connection.prepareStatement("DELETE FROM EXAMRESULT WHERE MODULEID = (?)");
	         removeExamResult = connection.prepareStatement("DELETE FROM EXAMRESULT WHERE MODULEID = (?) AND STUDENTID = (?)");
	         
	         // Edit Statements
	         editStudent = connection.prepareStatement("UPDATE STUDENT SET NAME = ?, DATEOFBIRTH = ? WHERE ID = (?)");
	         
	      }
	      catch ( SQLException e )
	      {
	    	 e.printStackTrace();
	         System.exit( 1 );
	      }
	}
	
	/** Adds a student to the database
	 * 
	 * @param studentID Students id used as a unique identifier
	 * @param studentName Students name
	 * @param studentDOB Students date of birth
	 * 
	 */
	public void addStudent(int studentID, String studentName, String studentDOB) {
	    
	    try 
		    {
	    		// Adding the parameters to the add Statement
		    	addStudent.setInt( 1, studentID );
		    	addStudent.setString( 2, studentName );
		    	addStudent.setString( 3, studentDOB );
		 
		       // Executing add Statement
		       addStudent.executeUpdate(); 
		       System.out.println("Added Student Succesfully");
		       
		    } 
	    
	    catch ( SQLException sqlException )
		    {
	    		// If theres an error 
	    		sqlException.printStackTrace();
	    		display.verify("Error with inputs", "That ID has already been used");
		    }

	}
	
	/** Adds a module to the database
	 * 
	 * @param studentID Students id used as a unique identifier
	 * @param studentName Students name
	 * 
	 */
	public void addModule(int moduleID, String moduleName) {

	    try 
		    {
	    		// Adding the parameters to the add Statement
		    	addModule.setInt( 1, moduleID );
		    	addModule.setString( 2, moduleName );
		 
		    	// Executing add Statement
		    	addModule.executeUpdate(); 
		    	System.out.println("Added Module Succesfully");
		    	
		    } 

	    catch ( SQLException sqlException )
		    {
	    		// If theres an error 
	    		sqlException.printStackTrace();
	    		display.verify("Error with inputs", "That ID has already been used");
		    }
	    
	}
	
	/** Adds an exam result to the database
	 * 
	 * @param moduleID Module id used as a unique identifier
	 * @param studentID Student id used as a unique identifier
	 * @param examResult The grade achieved by the student in the module
	 * 
	 */
	public void addExamResult(int moduleID, int studentID, int examResult) {
		
	    try 
		    {
	    		// Adding the parameters to the add Statement
		    	addExamResult.setInt( 1, moduleID );
		    	addExamResult.setInt( 2, studentID );
		    	addExamResult.setInt( 3, examResult);
		    	
		    	// Executing add Statement
		    	addExamResult.executeUpdate(); 
		    	System.out.println("Added Exam Result Succesfully");
		    }
	    
	    catch ( SQLException sqlException )
		    {
	    		// If theres an error 
	    		sqlException.printStackTrace();
	    		display.verify("Error with inputs", "That ExamResult has already been created");
		    }
	    
	}
	
	/** Removes a student from the database
	 * 
	 * @param studentID Students unique id
	 * 
	 */
	public void removeStudent(int studentID) {
		
		try {
			// Remove the students exam results
			removeStudentExamResult(studentID);
			
			// Adding the parameter to the remove Statement
			removeStudent.setInt( 1, studentID);
			
			// Executing remove Statement
			removeStudent.executeUpdate();
			System.out.println("Removed Student Succesfully");
			
		} catch ( SQLException sqlException) {
			// If theres an error 
			sqlException.printStackTrace();
			display.verify("Error with inputs", "That student doesn't exist");
		}
		
	}
	
	/** Remove the exam results of a student, used when deleting a student
	 * 
	 * @param studentID Students unique id
	 */
	public void removeStudentExamResult(int studentID) {
		
		try {
			// Adding the parameter to the remove Statement
			removeStudentExamResult.setInt( 1, studentID);
			
			// Executing remove Statement
			removeStudentExamResult.executeUpdate();
			System.out.println("Removed ExamResult Succesfully");
			
		} catch ( SQLException sqlException) {
			// If theres an error 
			sqlException.printStackTrace();
		}
		
	}
	
	/** Removes a student from the database
	 * 
	 * @param moduleID Modules unique id
	 */
	public void removeModule(int moduleID) {
			
			try {
				// Remove the students exam results
				removeModuleExamResult(moduleID);
				
				// Adding the parameter to the remove Statement
				removeModule.setInt( 1, moduleID);
				
				// Executing remove Statement
				removeModule.executeUpdate();
				System.out.println("Removed Module Succesfully");
				
			} catch ( SQLException sqlException) {
				// If theres an error
				sqlException.printStackTrace();
				display.verify("Error with inputs", "That module doesn't exist");
			}
			
		}
	
	/** Remove the exam results of a module, used when deleting a module
	 * 
	 * @param moduleID Modules unique id
	 */
	public void removeModuleExamResult(int moduleID) {
			
			try {
				// Adding the parameter to the remove Statement
				removeModuleExamResult.setInt( 1, moduleID);
				
				// Executing remove Statement
				removeModuleExamResult.executeUpdate();
				System.out.println("Removed ExamResult Succesfully");
				
			} catch ( SQLException sqlException) {
				// If theres an error
				sqlException.printStackTrace();
			}
			
		}
	
	/**
	 * 
	 * @param moduleID
	 * @param studentID
	 */
	public void removeExamResult(int moduleID, int studentID) {
		
		try {
			// Adding the parameters to the remove Statement
			removeExamResult.setInt( 1, moduleID);
			removeExamResult.setInt( 2, studentID);
			
			// Executing remove Statement
			removeExamResult.executeUpdate();
			System.out.println("Removed ExamResult Succesfully");
			
		} catch ( SQLException sqlException) {
			// If theres an error
			sqlException.printStackTrace();
			display.verify("Error with inputs", "That exam result doesn't exist");
		}
		
	}
		
	/** Gets all the students in the database
	 * 
	 * @return Returns a list of student objects which will represent all the students in the database
	 */
	public List<Student> getAllStudents()
	   {
	      List< Student > results = null;
	      ResultSet resultSet = null;
	      
	      try 
		      {
	    	  	// Executing select Statement
		         resultSet = selectAllStudents.executeQuery(); 
		         results = new ArrayList< Student >();
		         
		         // Adding the student to the list
		         while ( resultSet.next() )
		         {
		            results.add( new Student(
		               resultSet.getString( "NAME" ),
		               resultSet.getInt("ID"),
		               resultSet.getString("DATEOFBIRTH")
		            		));
		         } // end while
		         
		      }
	      
	      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace();         
		      } // end catch
	      finally
		      {
		         try 
			         {
			            resultSet.close();
			         } // end try
		         catch ( SQLException sqlException )
			         {
			            sqlException.printStackTrace();         
			         } // end catch
		      } // end finally
	      
	      // return students
	      return results;
	   }
	
	/** Get a specific student
	 * 
	 * @param studentID The id of the student you want to get
	 * @return return the student
	 */
		public List<String> getStudent(int studentID) {
			
			List<String> results = null;
			ResultSet resultSet = null;
		      
	      try 
		      {
	    	  	 // Adding parameter to select Statement
	    	  	 selectStudent.setInt( 1, studentID);
	    	  	 
	    	  	 // Executing select Statement
		         resultSet = selectStudent.executeQuery(); 
		         results = new ArrayList<String>();
		         
		         // Adding the student to the list
		         while ( resultSet.next() )
		         {
		        	 results.add(resultSet.getString( "NAME" ) + ", "+ String.valueOf(resultSet.getInt( "ID" )+ ", "+ String.valueOf(resultSet.getString( "DATEOFBIRTH" )+"\n")));
		         } 
		         
		      } // end try
		      
	      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace();    
		         display.verify("Error with inputs", "That student doesn't exist");
		      } // end catch
	      finally
		      {
		         try 
			         {
			            resultSet.close();
			         } // end try
		         catch ( SQLException sqlException )
			         {
			            sqlException.printStackTrace();         
			         } // end catch
		      } // end finally
	      
	      return results;
		}
		
		/** Get the modules and the result where a student achieved 70 or more
		 * 
		 * @param studentID The id of the student you want to get
		 * @return
		 */
		public List<String> getStudentHonors(int studentID) {
			
			List< String > results = null;
			ResultSet resultSet = null;
		      
		      try 
			      {
		    	  	 // Adding parameter to select Statement
		    	  	 selectStudentHonors.setInt( 1, studentID);
		    	  	 
		    	  	 // Executing select Statement
			         resultSet = selectStudentHonors.executeQuery(); 
			         results = new ArrayList<>();
			         
			         // Adding the student to the list
			         while ( resultSet.next() )
			         {
			            results.add(resultSet.getString( "NAME" ) + ": "+ String.valueOf(resultSet.getInt( "RESULT" )+"\n"));
			         } 
			         
			      } // end try
		      
		      catch ( SQLException sqlException )
			      {
			         sqlException.printStackTrace();         
			      } // end catch
		      finally
			      {
			         try 
				         {
				            resultSet.close();
				         } // end try
			         catch ( SQLException sqlException )
				         {
				            sqlException.printStackTrace();         
				         } // end catch
			      } // end finally
		      
		      return results;
		}

		/** Edit the details of a student
		 * 
		 * @param studentID The id of the student whos details you want to change
		 * @param studentName New name for student
		 * @param studentDOB New date of birth for student
		 */
		public void editStudent(int studentID, String studentName, String studentDOB) {
		    
		    try 
			    {
		    		// Adding parameters to edit Statement
			    	editStudent.setString( 1, studentName );
			    	editStudent.setString( 2, studentDOB );
			    	editStudent.setInt( 3, studentID );
			 
			    	// Executing edit  Statement
			       editStudent.executeUpdate(); 
			       System.out.println("Edit Student Succesfully");
			       
			    } // end try
		    catch ( SQLException sqlException )
			    {
		    		sqlException.printStackTrace();
		    		display.verify("Error with inputs", "That student doesn't exist");
			    } // end catch
    		
		}

	
	
	   /** Close the connection to the database
	    * 
	    */
	   public void close()
	   {
	      try 
	      {
	         connection.close();
	      } // end try
	      catch ( SQLException sqlException )
	      {
	         sqlException.printStackTrace();
	      } // end catch
	   } // end method close
	
}