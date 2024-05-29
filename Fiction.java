
public class Fiction extends Book {

	private String supernatural, cover;

	public Fiction(String book_name, int bookId, String author, String status, String genre, String supernatural,
			String cover) {
		super(book_name, bookId, author, status, genre);
		this.supernatural = supernatural;
		this.cover = cover;
	}

	public void setSupernatural(String supernatural) {
		this.supernatural = supernatural;
	}

	public String getSupernatural() {
		return supernatural;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCover() {
		return cover;
	}

	@Override
	public void displayBook() {
		System.out.println("\tBook Name : " + getBookName());
		System.out.println("\tBook ID   : " + getBookId());
		System.out.println("\tAuthor    : " + getAuthor());
		System.out.println("\tStatus    : " + getStatus());
		System.out.println("\tGenre     : " + getGenre());
		System.out.println("\tSupernatural : " + supernatural);
		System.out.println("\tBook Cover   : " + cover);
	}

}
