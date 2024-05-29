
public abstract class Book {

    private String book_name, author, genre, status;
    private int bookId;

    public Book(String book_name, int bookId, String author, String status, String genre) {
        this.book_name = book_name;
        this.bookId = bookId;
        this.author = author;
        this.status = status;
        this.genre = genre;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookName(String book_name) {
        this.book_name = book_name;
    }

    public String getBookName() {
        return book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public abstract void displayBook();

}
