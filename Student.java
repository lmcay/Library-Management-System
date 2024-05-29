

public class Student extends Person {


	private String email;
	private int age, borrowedBookID, reservedBookID;
	
	private boolean borrowed, reserved;
	
	public Student(String name, int id, String email, int age) {
		super(name, id);
		this.email = email;
		this.age = age;
		this.borrowed = false;
		this.reserved = false;
		this.borrowedBookID = 0;
		this.reservedBookID = 0;
	}
	
	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return email; }
	
	public void setAge(int age) { this.age = age; }
	public int getAgeo() { return age; }
	
	public void setBorrowed(boolean borrowed) {this.borrowed = borrowed; }
	public boolean isBorrowed() { return borrowed; }
	
	public void setReserved(boolean reserved) {this.reserved = reserved; }
	public boolean isReserved() { return reserved; }
	
	public void setBorrowedBookID(int borrowedBookID) { this.borrowedBookID = borrowedBookID; }
	public int getBorrowedBookID() { return borrowedBookID; }
	
	public void setReservedBookID(int reservedBookID) { this.reservedBookID = reservedBookID; }
	public int getReservedBookID() { return reservedBookID; }
	
	@Override
	public void display() {
		System.out.println("\tStudent name : " + getName());
		System.out.println("\tEmail        : " + email);
		System.out.println("\tStudent ID   : " + getStudID());
		System.out.println("\tAge          : " + age);
	}

	

}
