import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void regReader(Reader reader) {
        readers.add(reader);
    }

    public void giveBook(Reader reader, Book book) {
        if (books.contains(book)) {
            reader.borrowBook(book);
        } else {
            System.out.println("The book's not available right now.");
        }
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
    }

    public void genreSearch(String genre) {
        for (Book book : books) {
            if (book.getInfo().contains(genre)) {
                    System.out.println(book.getInfo());
            }
        }
    }

    public void subjectSearch(String subject) {
        for (Book book : books) {
            if (book.getInfo().contains(subject)) {
                    System.out.println(book.getInfo());
            }
        }
    }


}
