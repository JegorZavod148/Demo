import java.util.ArrayList;
import java.util.List;
public class Reader {

    String name;
    String id;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Reader(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
        } else {
            System.out.println("The book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
        } else {
            System.out.println("This book's already here.");
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}