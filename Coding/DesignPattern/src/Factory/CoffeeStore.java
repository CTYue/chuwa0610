package Factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        CoffeeFactory factory = new CoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
