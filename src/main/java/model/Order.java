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

    // Returns unique order ID
public String getOrderId() {
    return orderId;
}

    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Prints the customer bill.
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
