package model;
/* Stores one selected menu item and its quantity. */
public class CartItem {
    private MenuItem item;
    private int quantity;
    public CartItem(MenuItem item, int quantity) { this.item = item; this.quantity = quantity; }
    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getAmount() { return item.getPrice() * quantity; }
}
