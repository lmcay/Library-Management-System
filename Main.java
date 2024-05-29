

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static Database database = new Database();
	
	public static void main(String[] args) {
		
		while(true) {
			displayMenu();
			
			System.out.print("\n\tEnter input >> "); String ans = input.nextLine();
			
			if(ans.equalsIgnoreCase("A")) { getStudentDetailsAddDB(); } 		// Gets Student details then add to Database
			else if (ans.equalsIgnoreCase("E")) { getStudentIdRMDB(); } 		// Gets Student Id then add to Database
			else if (ans.equalsIgnoreCase("B")) { getBookDetailsAddDB(); } 		// Gets Book details then add to Database
			else if (ans.equalsIgnoreCase("R")) { getBookIdRMDB(); } 			// Gets Book Id then add to Database
			else if (ans.equalsIgnoreCase("C")) { database.displayStudent(); } 	// Display Students
			else if (ans.equalsIgnoreCase("V")) { database.displayBook(); } 	// Display Books
			else if (ans.equalsIgnoreCase("D")) { database.displayStatus(); } 	// Display Book Status
			else if (ans.equalsIgnoreCase("X")) { break; } 						// If user wants to exit program
			else if (ans.equalsIgnoreCase("1")) { getBookIdBorrow(); } 			// Gets Book Id and Student Id user wants to borrow and borrow it
			else if (ans.equalsIgnoreCase("2")) { getBookIdReserve(); }  		// Gets Book Id and Student Id user wants to reserve and reserve it 
			else if (ans.equalsIgnoreCase("3")) { getBookIdReturn(); } 			// Gets Book Id and Student Id user wants to return it
			else if (ans.equalsIgnoreCase("F")) { getBookIdFind(); } 			// Gets Book Id user wants to find and display
			else { System.out.println("\n\tInput is not recognized. Please try again.\n"); }	// If input is not within the choices.
		}
		
		System.out.println("\n\tProgram Exit.");
	}
	
//	============================ *** Display Function *** ================================ //
	
	public static void displayMenu() {	
		System.out.println("==================================================================\n\t\tLibrary Management System\n==================================================================\n");
		System.out.println("\t[A] Add Student\t\t[E] Remove Student\n\t"
				+ "[B] Add Book\t\t[R] Remove Book\n\t"
				+ "[C] View Students\t[V] View Books\n\t"
				+ "[D] Show Status\t\t[X] Exit Program\n\t"
				+ "\n\t------------------------------------------\n\n\t"
				+ "[1] Borrow Book\t\t[2] Reserve Book\n\t"
				+ "[3] Return Book\t\t[F] Find Book\n\t");
		System.out.println("==================================================================");
	}
	
//	============================ *** Validate Functions *** ================================ //

	// Gets the parameter for integer and the type of validation to use.
	public static void validate(int number, String type) throws Library_Validation {
		
		int code = 0;
		
		if(type.equals("age")) {	// If validation type is for age validation, then use age validation and age error messages.
			
			if(number < 7) {
				throw new Library_Validation(ErrorMessages.age_errormsgs[code]); // If age is less than 7, use our library validation.
			}
			
			if(number > 132) {
				code = 1;
				throw new Library_Validation(ErrorMessages.age_errormsgs[code]);  // If age is greater than 132, use our library validation.
			}
			
		} else if (type.equals("book")) {	// If validation type is for book validation, then use book validation and book error messages.
			
			if(number < 2000) {
				throw new Library_Validation(ErrorMessages.book_id[code]);	// If book number is less than 2000, use our library validation.
			}
			
			if(number > 3000) {
				code = 1;
				throw new Library_Validation(ErrorMessages.book_id[code]);	// If book number is greater than 3000, use our library validation.
			}
			
		} else if (type.equals("student")) {	// If validation type is for student validation, then use student validation and student error messages.
			
			String stud_id = Integer.toString(number); // Convert phone number to string to get its first index and length
			
			if(!stud_id.startsWith("1")) {
				throw new Library_Validation(ErrorMessages.student_id[code]);	// If student id doesn't start with 1, use our library validation.
			}
			
			if(stud_id.length() != 5) {	
				code = 1;
				throw new Library_Validation(ErrorMessages.student_id[code]);	// If student number length != 5, use our library validation.
			}
		}
	}
	
	public static int getValidAge() {	// Ask for user age and validates it. Once validated, return it for program use.
		
		int age;
		while(true) {
			try {
				System.out.print("\tEnter your Age     : "); age = input.nextInt();
				validate(age, "age");	// Use our custom exception function to validate user input.
				break;
			} catch (InputMismatchException e) {
				System.out.println("\tError : " + ErrorMessages.invalidDataType);	// If user inputs an invalid data type, catch it using inputMismatchException
			} catch (Library_Validation e) {
				System.out.println("\tError : " + e.getMessage());	// Display error type using our custom exception.
			} catch (Exception e) {
				System.out.println("Something went wrong."); 	// In case our program runs to a program we cannot handle.
			} finally {
				input.nextLine();
			}	
		}
		return age;
	}
	public static int getValidBookID() {	// Ask for user book id and validates it. Once validated, return it for program use.
		
		int book_id;
		
		while(true) {
			try {
				System.out.print("\tEnter Book ID      : "); book_id = input.nextInt();
				validate(book_id, "book");	// Use our custom exception function to validate user input.
				break;
			} catch (InputMismatchException e) {
				System.out.println("\tError : " + ErrorMessages.invalidDataType);	// If user inputs an invalid data type, catch it using inputMismatchException
			} catch (Library_Validation e) {
				System.out.println("\tError : " + e.getMessage());	// Display error type using our custom exception.
			} catch (Exception e) {
				System.out.println("Something went wrong.");	// In case our program runs to a program we cannot handle.
			}  finally {
				input.nextLine();
			}
		}
		
		return book_id;
	}
	
	
	public static int getValidStudentID() {	// Ask for user book id and validates it. Once validated, return it for program use.
		int stud_id;	
		while(true) {
			try {
				System.out.print("\tEnter Student ID   : "); stud_id = input.nextInt(); 
				validate(stud_id, "student");	// Use our custom exception function to validate user input.
				break;
			} catch (InputMismatchException e) {
				System.out.println("\tError : " + ErrorMessages.invalidDataType);	// If user inputs an invalid data type, catch it using inputMismatchException
			} catch (Library_Validation e) {
				System.out.println("\tError : " + e.getMessage());	// Display error type using our custom exception.
			} catch (Exception e) {
				System.out.println("Something went wrong.");	// In case our program runs to a program we cannot handle.
			}  finally {
				input.nextLine();
			}
		}
		return stud_id;
	}
	
	public static String getValidEmail() {	// Ask for user email and validates it. Once validated, return it for program use.
		String email;
		
		while(true) {
			System.out.print("\tEnter email        : "); email = input.nextLine();
			if(email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
				return email;
			} else {
				System.out.println("\tError : Please enter a valid email.");
			}
		}
        
    }
	
	public static String getGenre() {	// Ask for book genre and validates it. Once validated, return it for program use.
		String genre;
		while(true) {
			System.out.print("\tFiction|Non [F|N] : ");  genre = input.nextLine().toUpperCase();
			
			if (genre.equals("F") || genre.equals("N")) {	//Return F or N to be used for program use.
				
				return genre;
			} else {
				System.out.println("\tError : Invalid Input. Please try again.");
			}
		}
	}
	
//	=================== *** Additional Functions and Database Functions Implementation ***============================
	

	public static void getStudentDetailsAddDB() { // Gets students details like student name, student id, etc then instantiate object and add it to database.
		int stud_id;
		
		System.out.println("\n\t*** Adding Student ***\n");
		System.out.print("\tEnter Student Name : "); String name = input.nextLine();
		
		while(true) {
			stud_id = getValidStudentID();	// Validate and get student id
			Student s = database.getStudentID(database.getStudentList(), stud_id);	// Check if the provided id matches a student id from the student array list.
			
			if(s == null) {	// If object fails to find a student that matches the given id, then successfully assign that unique id for that student.
				break;
			} else {	// If there exist a student with the provided student id, prompt the user to enter another input.
				System.out.println("\tError : A student already has that ID. Please try again.");
			}
		}
		
		String email = getValidEmail(); // Validate and get email
		int age = getValidAge();		// Validate and get age
		
		Student student = new Student(name, stud_id, email, age);	// Instantiate a student object
		database.addStudent(student);		// Use our database function to add the passed in argument of student object
		
		System.out.println("\n\t ***Successfully Added Student\t***\n");
	}
	
	public static void getStudentIdRMDB() {	// Gets student Id, then use it to remove a student from the database.
		
		System.out.println("\n\t***Removing Student ***\n");
		
		int stud_id = getValidStudentID();	// Validate and get student id
		database.removeStudent(stud_id);	// Use our database function to remove the passed in argument of student id.
		
		System.out.println();
	}
	
	public static void getBookDetailsAddDB() {	// Gets books details like book name, author, etc then instantiate object and add it to database.
		
		int book_id;
		String status = "Available";	// Adding a book to database sets its status to available.
		
		System.out.println("\n\t *** Adding Book ***\n");
		System.out.print("\tEnter Book Name    : "); String book_name = input.nextLine();
		
		while(true) {
			book_id = getValidBookID();		// Validates and get book_id
			Book book = database.getBookID(database.getBookList(), book_id); // Check if the provided id matches a book id from the book array list.
			
			if(book == null) { // If object fails to find a book that matches the given id, then successfully assign that unique id for that book.
				break;
			} else {		// If there exist a book with the provided student id, prompt the user to enter another input.
				System.out.println("\tError : A book already has that ID. Please try again.");
			}
		}
		
		System.out.print("\tEnter Author       : "); String author = input.nextLine();
		String genre = getGenre();	// Validates and gets genre
		
		if(genre.equals("F")) {		//If genre is Fiction, get its unique properties
			System.out.print("\tEnter Supernatural : "); String supernatural = input.nextLine();
			System.out.print("\tEnter Book Cover   : "); String cover = input.nextLine();
			Fiction book = new Fiction(book_name, book_id, author, status, "Fiction", supernatural, cover);	// Instantiate a Fiction Book Object
			database.addBook(book);	// Add the fiction book object to the database.
		} else {	// Else if genre is non fiction, get its unique properties
			System.out.print("\tEnter Opinion      : "); String opinion = input.nextLine();
			System.out.print("\tEnter Comment      : "); String comment = input.nextLine();
			NonFiction book = new NonFiction(book_name, book_id, author, status, "Non-Fiction",opinion, comment);	// Instantiate a Non-Fiction Book Object
			database.addBook(book); 	// Add the fiction book object to the database.
		}	

		System.out.println("\n\t ***Successfully Added Book ***\n");
	}
	
	public static void getBookIdRMDB() {	// Gets book ID and use database functions to remove it
		
		System.out.println("\n\t***Removing Book\t***\n");
		
		int book_id = getValidBookID();		// Gets and validate book id
		database.removeBook(book_id);		// Use database function to remove the passed book id argument
		
		System.out.println();
	}
	
	
	public static void getBookIdBorrow() {		// Gets Book && Student ID and to use database functions to borrow a book
		
		System.out.println("\n\t*** Borrowing Book ***\n");
		
		int stud_id = getValidStudentID();			// Gets and validate student id	
		int book_id = getValidBookID();				// Gets and validate book id
		database.borrowBook(stud_id, book_id);		// Pass in student and book id as arguments and use the borrow book function from the database.
		
		System.out.println();
	}

	public static void getBookIdReserve() {		// Gets Book && Student ID and to use database functions to reserve a book
		
		System.out.println("\n\t ***Reserving Book***\n");
		
		int stud_id = getValidStudentID();			// Gets and validate student id	
		int book_id = getValidBookID();				// Gets and validate book id
		database.reserveBook(stud_id, book_id);		// Pass in student and book id as arguments and use the reserve book function from the database.
		
		System.out.println();
	}
	
	public static void getBookIdReturn() {		// Gets Book && Student ID and to use database functions to return a book
		
		System.out.println("\n\t*** Returning Book***\n");
		
		int stud_id = getValidStudentID();			// Gets and validate student id	
		int book_id = getValidBookID();				// Gets and validate book id
		database.returnBook(stud_id, book_id);		// Pass in student and book id as arguments and use the return book function from the database.
		
		System.out.println();
	}
	
	public static void getBookIdFind() {	// Gets book ID and use database functions to find it
		
		System.out.println("\n\t*** Finding Book***\n");
		
		int book_id = getValidBookID();		// Gets and validate book id
		database.findBook(book_id);			// Pass book id as argument and use the find book function from the database.
		
		System.out.println();
	}
	
	
	
	
	
	

}
