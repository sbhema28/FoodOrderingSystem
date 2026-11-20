package service;
import java.util.ArrayList;
import model.CartItem;
import model.MenuItem;
import exceptions.InvalidQuantityException;
/* Handles adding, removing and updating cart items. */
public class CartService {
    private ArrayList<CartItem> cart = new ArrayList<>();
    public void addItem(MenuItem item, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) throw new InvalidQuantityException("Quantity must be greater than zero.");
        for (CartItem cartItem : cart) {
            if (cartItem.getItem().getId() == item.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                System.out.println("Quantity updated in cart."); return;
            }
        }
        cart.add(new CartItem(item, quantity));
        System.out.println("Item added to cart.");
    }
    public void removeItem(int id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getItem().getId() == id) {
                cart.remove(i); System.out.println("Item removed."); return;
            }
        }
        System.out.println("Item is not in the cart.");
    }
    public void updateQuantity(int id, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) throw new InvalidQuantityException("Quantity must be greater than zero.");
        for (CartItem item : cart) {
            if (item.getItem().getId() == id) {
                item.setQuantity(quantity); System.out.println("Quantity updated."); return;
            }
        }
        System.out.println("Item is not in the cart.");
    }
    public void showCart() {
        if (cart.isEmpty()) { System.out.println("Your cart is empty."); return; }
        System.out.println("\n------------- YOUR CART -------------");
        for (CartItem item : cart)
            System.out.printf("%-20s x %-3d Rs. %.2f%n", item.getItem().getName(),
                    item.getQuantity(), item.getAmount());
        System.out.printf("Total: Rs. %.2f%n", getTotal());
    }
    public double getTotal() {
        double total = 0;
        for (CartItem item : cart) total += item.getAmount();
        return total;
    }
    public ArrayList<CartItem> getCartCopy() {
        ArrayList<CartItem> copy = new ArrayList<>();
        for (CartItem item : cart) copy.add(new CartItem(item.getItem(), item.getQuantity()));
        return copy;
    }
    public void clearCart() { cart.clear(); }
}
