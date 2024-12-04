public class Main {

    public static void main(String[] args){
        System.out.println();

        Book book1 = new Book("Lord of the Rings", "J. Tolkien", 500);
        Book book2 = new Book("Crime and Punishment", "Dostoyevskiy", 315);
        Book book3 = new Book("Sherlock Holmes", "Arthur Conan Doyle", 400);

        book2.applyDiscount(10);

        System.out.println("BOOKS: ");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();

        System.out.println("----------------");

        Circle circle = new Circle(5);

        System.out.println("Радіус кола: "+circle.radius);
        System.out.println("Площа: "+circle.calculateArea());
        System.out.println("Довжина: "+circle.calculateCircumference());

    }

}

//git init
//git add README.md
//git commit -m "first commit"
//git remote add three https://github.com/JegorZavod148/Demo.git
//git push -u origin master
