public class Dish {

    String name;
    double price;
    String category;

    public Dish(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("Назва: " + name + "\nЦіна: $" + price + "\nКатегорія: " + category);
    }

}
