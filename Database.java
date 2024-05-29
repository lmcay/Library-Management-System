
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	static Scanner input = new Scanner(System.in);

	public Database() {

		NonFiction b1 = new NonFiction("On the Origin of Species 1", 2019, "Charles Darwin", "Available", "Non-Fiction",
				"Great Book!", "Very entertaining");
		bookList.add(b1);
		NonFiction b2 = new NonFiction("The Diary of a Young Girl", 2020, "Anne Frank", "Available", "Non-Fiction",
				"Excellent Material!", "Life Lessons");
		bookList.add(b2);
		NonFiction b3 = new NonFiction("A Brief History of Time", 2021, "Stephen Hawking", "Available", "Non-Fiction",
				"Superb Knowledge!", "Very knowledgeable");
		bookList.add(b3);
		NonFiction b4 = new NonFiction("A Room of One�s Own", 2022, "Virginia Woolf", "Available", "Non-Fiction",
				"Good Read", "Recommended Book!");
		bookList.add(b4);
		NonFiction b5 = new NonFiction("The Waste Land", 2023, "TS Eliot", "Available", "Non-Fiction", "Excellent!",
				"Very interesting");
		bookList.add(b5);

		Fiction b6 = new Fiction("Alice in Wonderland", 2024, "Lewis Carrol", "Available", "Fiction",
				"Wonderland Adventures", "Softcover");
		bookList.add(b6);
		Fiction b7 = new Fiction("Hamlet", 2025, "William Shakespeare", "Available", "Fiction", "Ghostly Apparitions",
				"Hardbound");
		bookList.add(b7);
		Fiction b8 = new Fiction("Pride and Prejudice", 2026, "Jane Austen", "Available", "Fiction",
				"Social Conventions", "Softcover");
		bookList.add(b8);
		Fiction b9 = new Fiction("To Kill a Mockingbird", 2027, "Harper Lee", "Available", "Fiction",
				"Symbolic Boo Radley", "Hardbound");
		bookList.add(b9);
		Fiction b10 = new Fiction("A Tale of Two Cities", 2028, "Charles Dickens", "Available", "Fiction",
				"Resurrection Theme", "Softcover");
		bookList.add(b10);

		Student s1 = new Student("Alliyah", 12455, "alliyah@yahoo.com", 24);
		studentList.add(s1);
		Student s2 = new Student("Luis", 12456, "luis@yahoo.com", 19);
		studentList.add(s2);
		Student s3 = new Student("Suarez", 12457, "suarez@yahoo.com", 31);
		studentList.add(s3);

	}

	public ArrayList<Student> getStudentList() { // Access ArrayList of Students from Main Class
		return studentList;
	}

	public ArrayList<Book> getBookList() { // Access ArrayList of Books from the Main Class
		return bookList;
	}

	public Book getBookID(ArrayList<Book> book_list, int id) { // Contains the Parameter of book list and book ID from
																// other class
		for (Book book : bookList) { // Get Book from Book array list using getting its Book ID.
			if (book.getBookId() == id) {
				return book;
			}
		}
		return null; // If there is no match, return null
	}

	public Student getStudentID(ArrayList<Student> student_list, int id) { // Contains the Parameter of student list and
																			// student ID from the other class
		for (Student student : studentList) { // Get Student from Student array list using getting its Student ID.
			if (student.getStudID() == id) {
				return student;
			}
		}
		return null; // If there is no match, return null
	}

	public void addBook(Book book) { // Contains the book object parameter obtained from the Main Class, then add its
										// object to the book array list
		bookList.add(book);
	}

	public void removeBook(int bookId) { // Contains the book id parameter obtained from the Main Class.
		Book book = getBookID(bookList, bookId); // Checks if the given book id matches the object book id from the
													// array list

		if (book != null && book.getStatus() == "Available") { // If book object has been found and its status is
																// Available, then remove it.
			bookList.remove(book);
			System.out.println("\tSuccesfully removed book : " + book.getBookName() + "!");
		} else if (book != null && book.getStatus() != "Available") { // If book object has been found but its been
																		// borrowed/reserved, deny permission to delete.
			System.out.println("\tError : Unable to remove book. Book has been " + book.getStatus());
		} else {
			System.out.println("\tError : Book is not on the system."); // If book object wasn't found in the list, then
																		// its not on the system.
		}

	}

	public void addStudent(Student student) { // Contains the student object parameter obtained from the Main Class,
												// then add its object to the student array list
		studentList.add(student);
	}

	public void removeStudent(int stud_id) { // Contains the student id parameter obtained from the Main
		Student student = getStudentID(studentList, stud_id); // Checks if the given student id matches the object
																// student id from the array list

		if (student != null && (!student.isBorrowed() && !student.isReserved())) { // If student object has been found
																					// and student haven't borrowed nor
																					// reserved a book, delete it.
			studentList.remove(student);
			System.out.println("\tSuccesfully removed Student : " + student.getName());
		} else if (student != null && (student.isBorrowed() || student.isReserved())) { // If student object is found
																						// and has borrowed/reserved a
																						// book, deny permission to
																						// delete.
			System.out.println("\tError : Cannot Remove student. Student have a pending \n\tstatus in the system.");
		} else {
			System.out.println("\tError : Student is not on the system."); // If student object wasn't found in the
																			// list, then its not on the system.
		}
	}

	public void displayStudent() {
		System.out.println("\n\t*** Displaying Students ***\n\t");
		for (Student student : studentList) { // Use a for loop to iterate over the student array list.
			student.display(); // Once student object is obtained, use its method of display to display all its
								// properties.
			System.out.println();
		}
		back();
	}

	public void displayBook() {

		System.out.println("\n\t*** Displaying Books ***\n\t");
		for (Book book : bookList) { // Use a for loop to iterate over the book array list.
			book.displayBook(); // Once book object is obtained, use its method of display to display all its
								// properties.
			System.out.println();
		}
		back();
	}

	public void borrowBook(int student_id, int book_id) { // Contains the parameter of student id and book id obtained
															// from the Main Class.

		Student student = getStudentID(studentList, student_id); // Gets student object
		Book book = getBookID(bookList, book_id); // Gets book object

		// If Student and Book is found, and student haven't borrowed nor reserved a
		// book, and book status is Available, permit to borrow a book.
		if (student != null && student.isBorrowed() == false && student.isReserved() == false && book != null
				&& book.getStatus().equals("Available")) {

			student.setBorrowed(true); // Set student borrowed to true
			student.setBorrowedBookID(book_id); // Set the borrowed book id
			book.setStatus("Borrowed"); // Change status to borrowed
			System.out.println("\n   *** Successfully Borrowed Book : " + book.getBookName() + " ***");

		} else if (student != null && book != null && !book.getStatus().equals("Available")) { // If book has been
																								// reserved or borrowed,
																								// deny permission to
																								// borrow.
			System.out.println("\tBook has been " + book.getStatus() + ". Book is not available");
		} else if (student == null) {
			System.out.println("\tError : Student is not on the system.."); // If student object isn't found, then
																			// student is not on the system.
		} else if (book == null) {
			System.out.println("\tError : Book is not on the system."); // If book object isn't found, then student is
																		// not on the system.
		} else {
			System.out.println("\tOnly one book per person. Thank you for your understanding."); // If student has
																									// borrowed or
																									// reserved a book
																									// before, then deny
																									// permission to
																									// borrow.
		}

	}

	public void reserveBook(int student_id, int book_id) { // Contains the parameter of student id and book id obtained
															// from the Main Class.

		Student student = getStudentID(studentList, student_id); // Gets student object
		Book book = getBookID(bookList, book_id); // Gets book object

		// If Student and Book is found, and student haven't borrowed nor reserved a
		// book, and book status is Available, permit to reserve a book.
		if (student != null && student.isBorrowed() == false && student.isReserved() == false && book != null
				&& book.getStatus().equals("Available")) {

			student.setReserved(true); // Set student reserved to true
			student.setReservedBookID(book_id); // Set the reserved book id
			book.setStatus("Reserved"); // Change status to reserved
			System.out.println("\n   *** Successfully Reserved Book : " + book.getBookName() + " ***");

		} else if (student != null && book != null && !book.getStatus().equals("Available")) { // If book has been
																								// reserved or borrowed,
																								// deny permission to
																								// reserve.
			System.out.println("\tBook has been " + book.getStatus() + ". Book is not available");
		} else if (student == null) {
			System.out.println("\tError : Student is not on the system.."); // If student object isn't found, then
																			// student is not on the system.
		} else if (book == null) {
			System.out.println("\tError : Book is not on the system."); // If book object isn't found, then student is
																		// not on the system.
		} else {
			System.out.println("\tOnly one book per person. Thank you for your understanding."); // If student has
																									// borrowed or
																									// reserved a book
																									// before, then deny
																									// permission to
																									// reserve.
		}

	}

	public void returnBook(int student_id, int book_id) { // Contains the parameter of student id and book id obtained
															// from the Main Class.

		Student student = getStudentID(studentList, student_id); // Gets student object
		Book book = getBookID(bookList, book_id); // Gets book object

		// If object and student is found, and student has borrowed or reserved, then
		// allow student to return a book
		if (student != null && book != null && (student.isBorrowed() || student.isReserved())
				&& (student.getBorrowedBookID() == book.getBookId()
						|| student.getReservedBookID() == book.getBookId())) {

			student.setReserved(false); // Set reserve to false
			student.setBorrowed(false); // Set borrowed to false
			student.setBorrowedBookID(0); // Set borrowed book id to 0
			student.setReservedBookID(0); // Set reserved book id to 0

			// Can be placed on an if else, but this way, everything resets, either borrowed
			// or reserved, to avoid extra conditions.

			book.setStatus("Available");
			System.out.println("\n   *** Successfully Returned Book " + book.getBookName() + " ***");

		} else if (student != null && book != null && (!student.isBorrowed() && !student.isReserved())) {

			// If user tries to return a book by a student that hasn't borrowed nor
			// reserved, deny permission
			System.out.println("\tError : " + student.getName() + " has not borrowed or reserved a book.");
		} else if (student == null) {
			System.out.println("\tError : Student is not on the system."); // If student object isn't found, then
																			// student is not on the system.
		} else if (book == null) {
			System.out.println("\tError : Book is not on the system."); // If book object isn't found, then student is
																		// not on the system.
		} else {
			System.out.println(
					"\tError : Unable to return book. Either book wasn't \n\tborrowed/reserved or student did not asked for \n\tthe given book.");
		}

	}

	public void displayStatus() {

		System.out.println("\n\t*** Displaying Books Status ***\n\t");

		for (Book book : bookList) { // Gets every book object from the book list.
			System.out.println("\tBook Name     : " + book.getBookName()); // Use the book object to get the author.
			System.out.println("\tBook Status   : " + book.getStatus()); // Use the book object to get the status.
			for (Student student : studentList) { // Loop the book object through the student list.

				// Check is student has borrowed and the book status is Borrowed. Then, check if
				// student borrowed book is equals to the book object id.
				// This condition is to get the student who borrowed the book.
				if (student.isBorrowed() && book.getStatus().equals("Borrowed")
						&& student.getBorrowedBookID() == book.getBookId()) { // To Fix
					System.out.println("\tBorrowed by   : " + student.getName() + " ");
				}

				// Check is student has reserved and the book status is Reserved. Then, check if
				// student reserved book is equals to the book object id.
				// This condition is to get the student who reserved the book.
				if (student.isReserved() && book.getStatus().equals("Reserved")
						&& student.getReservedBookID() == book.getBookId()) { // To Fix
					System.out.println("\tReserved by   : " + student.getName() + " ");
				}
			}
			System.out.println(); // For spacing

		}

		back();
	}

	public void findBook(int book_id) { // Contains the parameter book id obtained from the main class

		Book book = getBookID(bookList, book_id); // Gets the book object
		if (book != null) {
			System.out.println("\n\t*** Book Found ***\n"); // If book object is found, display its properties.
			book.displayBook();
			System.out.println();
		} else {
			System.out.println("\tError : Book is not on the system.\n"); // If book object isn't found, the
		}

		back();
	}

	public void back() { // A method to create break stops and doesn't continue looping over and over
							// again.
		while (true) {
			System.out.print("\tEnter 0 to go back : ");
			String x = input.nextLine();
			if (x.equals("0")) {
				System.out.println();
				break;
			} else {
				System.out.println("\tError: Input not recognized. Please try again.");
			}
		}
	}
}
