package service;
import java.util.HashMap;
import model.MenuItem;
import model.FoodItem;
import model.DrinkItem;
/* Displays and searches the restaurant menu. */
public class MenuService {
    private HashMap<Integer, MenuItem> menu = new HashMap<>();
    public MenuService() {
        // Add a few sample items to the menu.
        menu.put(1, new FoodItem(1, "Veg Burger", 90, "Fast Food"));
        menu.put(2, new FoodItem(2, "Paneer Pizza", 180, "Main Course"));
        menu.put(3, new FoodItem(3, "French Fries", 70, "Snacks"));
        menu.put(4, new FoodItem(4, "Veg Sandwich", 80, "Snacks"));
        menu.put(5, new DrinkItem(5, "Cold Coffee", 60, "Regular"));
        menu.put(6, new DrinkItem(6, "Lime Soda", 40, "Regular"));
    }
    public void showMenu() {
        System.out.println("\n------------- MENU -------------");
        System.out.printf("%-5s %-20s %-14s %s%n", "ID", "Item", "Price", "Type");
        for (MenuItem item : menu.values()) item.displayDetails();
    }
    public MenuItem findItem(int id) { return menu.get(id); }
    public void searchItem(String name) {
        boolean found = false;
        for (MenuItem item : menu.values()) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                item.displayDetails(); found = true;
            }
        }
        if (!found) System.out.println("Item not found.");
    }
}
