public class Book {

    String title;
    String author;
    float price;

      public Book(String title, String author, float price){
          this.title = title;
          this.author = author;
          this.price = price;
      }

      public void applyDiscount(float discount){
          if (discount > 0 && discount <= 100) {
              price -= price * (discount / 100);
          }
          else {
              System.out.println("Такої знижки не може бути.");
          }
      }

      public void printInfo(){
          System.out.println();

          System.out.println("Назва: " + title);
          System.out.println("Автор: " + author);
          System.out.println("Ціна: $" + price);

          System.out.println();

      }



}

