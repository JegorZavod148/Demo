public class Main {

    public static void main(String[] args) {
        System.out.println("\n------------------");

        Dish dish1 = new Dish("Суп", 6.83, "Основні страви");
        Dish dish2 = new Dish("Піца", 10.50, "Закуски");
        Dish dish3 = new Dish("Морозиво", 3.44, "Десерти");

        Restaurant.addDish(dish1);
        Restaurant.addDish(dish2);
        Restaurant.addDish(dish3);

        Restaurant.displayMenu();

        System.out.println();
        System.out.println("Загальна кількість страв у меню: " + Restaurant.getTotalDishes());

        System.out.println("------------------");
    }
}