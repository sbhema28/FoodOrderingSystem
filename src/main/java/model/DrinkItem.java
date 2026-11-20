package model;
/* A drink available in the restaurant. */
public class DrinkItem extends MenuItem {
    private String size;
    public DrinkItem(int id, String name, double price, String size) {
        super(id, name, price); this.size = size;
    }
    @Override
    public void displayDetails() {
        System.out.printf("%-5d %-20s Rs. %-8.2f %s%n", getId(), getName(), getPrice(), size);
    }
}
