package model;

/**
 * Stores order information.
 */
public class Order {

    public String orderId;
    public  double totalAmount;

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    // Returns the unique order identifier
public String getOrderId() {
    return orderId;
}
   
// Returns the final bill amount
public double getTotalAmount() {
    return totalAmount;
}
/**
 * Displays customer billing information.
 */
public void printBill() {
        System.out.println("\n========== BILL ==========");
        System.out.println("Order ID : " + orderId);
        System.out.println("Total Amount : ₹" + totalAmount);
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               " | Total Amount: ₹" + totalAmount;
    }
}
