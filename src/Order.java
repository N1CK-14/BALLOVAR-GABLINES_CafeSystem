public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        item1 = null;
        item2 = null;
        item3 = null;
        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        } else if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getDescription() + ".");
            return false;
        } else if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;
        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;
        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;
        }

        return false;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher > 0) {
            total -= voucher;
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printHeader();
        printItems();

        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;
        double total = computeTotal();

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", discount);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    public void printReceipt(double voucher) {
        printHeader();
        printItems();

        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;
        double total = computeTotal(voucher);

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", discount);
        }

        if (voucher > 0) {
            System.out.printf("Voucher: -%.2f%n", voucher);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    private void printHeader() {
        System.out.println("\nOrder #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
    }

    private void printItems() {
        printItem(item1);
        printItem(item2);
        printItem(item3);
    }

    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("  %-48s %.2f%n",
                    item.getDescription(), item.computePrice());
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer != null) {
            this.customer = customer;
        } else {
            System.out.println("Error: Customer cannot be null.");
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId != null && !orderId.trim().isEmpty()) {
            this.orderId = orderId;
        } else {
            System.out.println("Error: Invalid order ID.");
        }
    }

    public int getItemCount() {
        return itemCount;
    }
}
