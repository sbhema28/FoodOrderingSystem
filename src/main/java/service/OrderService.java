package service;

import exceptions.EmptyCartException;
import java.util.ArrayList;
import java.util.List;
import model.CartItem;
import model.Order;

/**
 * Handles order placement and billing.
 */
public class OrderService {
// Stores completed customer orders
private List<Order> orderHistory;

    public OrderService() {
        orderHistory = new ArrayList<>();
    }

    /**
     * Generate unique order ID.
     */
    public String generateOrderId() {
        return "ORD" + System.currentTimeMillis();
    }

    /**
     * Calculate total bill.
     */
    public double calculateFinalBill(ArrayList<CartItem> cartItems) {

        double total = 0;

        for (CartItem item : cartItems) {
            total += item.getAmount();
        }

        return total;
    }

    /**
     * Place order.
     */
    public Order placeOrder(ArrayList<CartItem> cartItems)
            throws EmptyCartException {

        if (cartItems == null || cartItems.isEmpty()) {
            throw new EmptyCartException(
                    "Cart is empty. Add items before checkout.");
        }

        String orderId = generateOrderId();

        double totalBill = calculateFinalBill(cartItems);

        Order order = new Order(orderId, totalBill);

        orderHistory.add(order);

        return order;
    }

    /**
     * Show order history.
     */
    public void showOrderHistory() {

        System.out.println("\n===== ORDER HISTORY =====");

        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }

        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}