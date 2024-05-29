
public class NonFiction extends Book {

	private String opinion, comment;

	public NonFiction(String book_name, int bookId, String author, String status, String genre, String opinion,
			String comment) {
		super(book_name, bookId, author, status, genre);
		this.opinion = opinion;
		this.comment = comment;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentt() {
		return comment;
	}

	@Override
	public void displayBook() {
		System.out.println("\tBook Name : " + getBookName());
		System.out.println("\tBook ID   : " + getBookId());
		System.out.println("\tAuthor    : " + getAuthor());
		System.out.println("\tStatus    : " + getStatus());
		System.out.println("\tGenre     : " + getGenre());
		System.out.println("\tOpinion   : " + opinion);
		System.out.println("\tComment   : " + comment);
	}

}
