import java.util.ArrayList;
public class Restaurant {

    private static ArrayList<Dish> menu = new ArrayList<>();

    public static void addDish(Dish dish) {
        menu.add(dish);
        System.out.println("Страва \"" + dish.getName() + "\" додана до меню.");
    }

    public static int getTotalDishes() {
        return menu.size();
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("Меню ресторану:");
        for (Dish dish : menu) {
            dish.displayInfo();
        }
    }

}
