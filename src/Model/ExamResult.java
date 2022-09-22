package Model;

public class ExamResult {
	private String id;
	private String grade;
	
	public ExamResult (String id, String grade){
		this.id = id;
		this.grade = grade;
	}

	public ExamResult(){} // a second constructor

	public String getID() {
		return this.id;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// How Module information is displayed on list
	 public String toString()
	 {
       String s = id + ", " + grade + "\n";
	   return s;
	 }
	
}
