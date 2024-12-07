import java.util.ArrayList;
class Library {

    static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
        System.out.println("Книга додана: " + book.getTitle());
    }

    public static void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Книга з назвою \"" + title + "\" видалена.");
    }

    public static void searchByAuthor(String author) {
        System.out.println("Книги автора \"" + author + "\":");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.bookInfo());
            }
        }
    }

    public static void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title))
                System.out.println("Знайдена книга: " + book.bookInfo());
            break;
        }
        System.out.println("Книга з назвою \"" + title + "\" не знайдена.");
    }

    public static int getBookCount() {
        return books.size();
    }
}
