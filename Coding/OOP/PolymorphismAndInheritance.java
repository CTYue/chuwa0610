package OOP;

/**
 * description: Polymorohism
 * date: 6/17/24 3:49 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class PolymorphismAndInheritance extends Encapsulation {
    public PolymorphismAndInheritance(String string, double aDouble) {
        super(string, aDouble);
    }

    // overload
    public String getName(String name){
        return name;
    }

    public String getName(String name, int age){
        return name;
    }

    @Override
    public String getNamePrice() {

        return "name price";
    }
}
