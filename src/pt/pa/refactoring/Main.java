package pt.pa.refactoring;

public class Main {

    public static void main(String[] args) {

        Customer johhny = new Customer("Johhny B Good", "123456789", 10);
        Customer beatrice = new Customer("Beatrice Lovejoy", "987654321", 15);

        Order order1 = new Order("AXF1", "Asics Gel Dedicate 7", 69.90f);
        Order order2 = new Order("BTG6", "Yonex ezone 98", 180);

        Order order3 = new Order("HIH3", "MSV Heptatwist 1.25 roll 200m", 65.3f);
        Order order4 = new Order("KSY6", "Technifibre Tennis Ballpack", 8.5f);

        johhny.placeOrder(order1);
        johhny.placeOrder(order2);
        beatrice.placeOrder(order3);
        beatrice.placeOrder(order4);

        System.out.println(johhny);
        System.out.println(beatrice);

        System.out.println("----- Total costs -----");
        printTotals(johhny);
        printTotals(beatrice);

        System.out.println("----- Change customer of order -----");
        order3.changeCustomer(johhny);

        System.out.println(johhny);
        System.out.println(beatrice);

        System.out.println("----- Total costs -----");
        printTotals(johhny);
        printTotals(beatrice);

        System.out.println("----- Total costs after Applying discounts -----");
        johhny.applyDiscount();
        beatrice.applyDiscount();
        printTotals(johhny);
        printTotals(beatrice);

    }

    private static final void printTotals(Customer c) {
        System.out.println(String.format("%s --> %.2f€", c.getName(), c.getTotalOrdersValue()));
    }
}
