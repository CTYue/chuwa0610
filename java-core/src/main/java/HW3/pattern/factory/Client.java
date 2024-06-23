package HW3.pattern.factory;

public  class Client { //  abstract class
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());
        /** output is
         * add milk
         * add suger
         * LatteCoffee
         */
    }
}
