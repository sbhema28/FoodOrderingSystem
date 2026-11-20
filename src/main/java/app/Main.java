package app;
import java.util.Scanner;
import model.MenuItem;
import model.Order;
import service.MenuService;
import service.CartService;
import service.OrderService;
import exceptions.InvalidQuantityException;
import exceptions.EmptyCartException;
import util.InputHelper;
/* Main class. It displays options and connects the service classes. */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuService menu = new MenuService();
        CartService cart = new CartService();
        OrderService orders = new OrderService();
        boolean running = true;

        while (running) {
            System.out.println("\n====== FOOD ORDERING SYSTEM ======");
            System.out.println("1. View Menu");
            System.out.println("2. Search Item");
            System.out.println("3. Add Item to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Remove Item from Cart");
            System.out.println("6. Update Quantity");
            System.out.println("7. Place Order and Print Bill");
            System.out.println("8. View Order History");
            System.out.println("9. Exit");
            int choice = InputHelper.readNumber(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    menu.showMenu(); break;
                case 2:
                    System.out.print("Enter item name: ");
                    menu.searchItem(scanner.nextLine()); break;
                case 3:
                    menu.showMenu();
                    int id = InputHelper.readNumber(scanner, "Enter item ID: ");
                    MenuItem selected = menu.findItem(id);
                    if (selected == null) { System.out.println("Invalid item ID."); break; }
                    int quantity = InputHelper.readNumber(scanner, "Enter quantity: ");
                    try { cart.addItem(selected, quantity); }
                    catch (InvalidQuantityException e) { System.out.println("Error: " + e.getMessage()); }
                    break;
                case 4:
                    cart.showCart(); break;
                case 5:
                    int removeId = InputHelper.readNumber(scanner, "Enter item ID to remove: ");
                    cart.removeItem(removeId); break;
                case 6:
                    int updateId = InputHelper.readNumber(scanner, "Enter item ID: ");
                    int newQuantity = InputHelper.readNumber(scanner, "Enter new quantity: ");
                    try { cart.updateQuantity(updateId, newQuantity); }
                    catch (InvalidQuantityException e) { System.out.println("Error: " + e.getMessage()); }
                    break;
                case 7:
                    try {
                        Order order = orders.placeOrder(cart.getCartCopy());
                        if (order != null) { order.printBill(); cart.clearCart(); }
                    } catch (EmptyCartException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 8:
                    orders.showOrderHistory(); break;
                case 9:
                    running = false;
                    System.out.println("Thank you for visiting!"); break;
                default:
                    System.out.println("Choose a number between 1 and 9.");
            }
        }
        scanner.close();
    }
}
