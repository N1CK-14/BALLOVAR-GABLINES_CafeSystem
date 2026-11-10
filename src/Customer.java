public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this("Unknown Customer", false);
    }

    public Customer(String name) {
        this(name, false);
    }

    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: Invalid points.");
        }
    }

    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int)(amountSpent / 50);
        } else {
            System.out.println("Error: Invalid amount.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Invalid customer name.");
            this.name = "Unknown Customer";
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            System.out.println("Error: Points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}