public class CafeApp {

    public static void main(String[] args) {

        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");

        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);

        Meal chickenAdobo = new Meal("Chicken Adobo", 98, "M-01", true, 2);

        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        Order order1 = new Order("1001", ana);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        order1.addItem(cookie);

        order1.printReceipt();

        Order order2 = new Order("1002", ben);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        order2.printReceipt(20);

        chickenAdobo.setExtraSides(-2);
    }
}
