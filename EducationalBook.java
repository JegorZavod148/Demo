public class EducationalBook extends Book {
    String subject;
    String level;

    public EducationalBook(String title, String author, int year, String isbn, String subject, String level) {
        super(title, author, year, isbn);
        this.subject = subject;
        this.level = level;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Subject: " + subject + "\n Level: " + level;
    }
}