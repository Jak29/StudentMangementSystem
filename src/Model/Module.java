package Model;

public class Module {
	private String name;
	private int id;
	
	public Module (int id, String name){
		this.name = name;
		this.id = id;
	}

	public Module(){} // a second constructor

	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	// How studnet information is displayed on list
	 public String toString()
	 {
       String s = name + ", " + id + "\n";
	   return s;
	 }
	
}
