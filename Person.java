

public abstract class Person {
	private String name;
	private int stud_id;
	
	public Person(String name, int stud_id) {
		this.name = name;
		this.stud_id = stud_id;
	}
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setStudID(int stud_id) { this.stud_id = stud_id; }
	public int getStudID() { return stud_id; }
	
	public abstract void display();
	
}
