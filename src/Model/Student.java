package Model;

public class Student {
	private String name;
	private int id;
	private String dob;
	
	public Student (String name, int id, String dob){
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

	public Student(){} // a second constructor

	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDob() {
		return this.dob;
	}

	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	// How studnet information is displayed on list
	 public String toString()
	 {
       String s = name + ", " + id + ", " +  dob + "\n";
	   return s;
	 }
	
}
