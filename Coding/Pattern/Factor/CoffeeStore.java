package Pattern.Factor;

public class CoffeeStore {
   public  Coffee orderCoffee(String type){
       Factory factory = new Factory();
       return factory.createCoffee(type);
   }




}
