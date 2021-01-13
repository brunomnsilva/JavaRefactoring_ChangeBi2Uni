package pt.pa.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final String vatNumber;

    private final float discountPercentage;

    private final List<Order> orders;

    public Customer(String name, String vatNumber, float discountPercentage) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.discountPercentage = discountPercentage;

        orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        order.setCustomer(this);
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void applyDiscount() {
        for(Order order : orders) {
            order.applyDiscount();
        }
    }

    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public float getTotalOrdersValue() {
        float total = 0f;

        for(Order order : orders) {
            total += order.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return String.format("Customer{%s | %s | %.2f%% | %s}", name, vatNumber, discountPercentage, orders.toString());
    }
}
