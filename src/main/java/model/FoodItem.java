package model;
/* A food item available in the restaurant. */
public class FoodItem extends MenuItem {
    private String category;
    public FoodItem(int id, String name, double price, String category) {
        super(id, name, price); this.category = category;
    }
    @Override
    public void displayDetails() {
        System.out.printf("%-5d %-20s Rs. %-8.2f %s%n", getId(), getName(), getPrice(), category);
    }
}
