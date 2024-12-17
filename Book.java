public class Book {

     String title;
     String author;
     int year;
     String isbn;
     boolean isAvailable;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getInfo() {
        return "Title: " + title + "\n Author: " + author + "\n Year: " + year + "\n Identity: " + isbn;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
