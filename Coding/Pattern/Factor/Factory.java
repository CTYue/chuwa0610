package Pattern.Factor;

public class Factory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("Dont have this tpye of coffee" + type);
        }

        coffee.addMilk();
        coffee.addSuger();
        return coffee;

    }
}
