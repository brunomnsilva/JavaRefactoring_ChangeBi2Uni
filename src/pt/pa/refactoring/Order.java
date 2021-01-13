package pt.pa.refactoring;

import java.util.Objects;

public class Order {

    private final String id;
    private String item;
    private float price;

    private Customer customer;

    public Order(String id, String item, float price) {
        if(id == null) throw new IllegalArgumentException("Id cannot be null.");

        this.id = id;
        this.item = item;
        this.price = price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void changeCustomer(Customer customer) {
        this.customer.getOrders().remove(this);
        this.customer = customer;
        this.customer.getOrders().add(this);
    }

    public void deleteOrder() {
        this.customer.getOrders().remove(this);
    }

    public void applyDiscount() {
        float discountPercentage = this.customer.getDiscountPercentage();
        this.price -= (this.price * discountPercentage/100);
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public float getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Order{%s | %s | %.2f€ }", id, item, price);
    }

}
