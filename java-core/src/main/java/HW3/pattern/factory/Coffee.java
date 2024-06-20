package HW3.pattern.factory;

public abstract class Coffee { //abstract class
    public abstract String getName();

    public void addSugar() {
        System.out.println("add suger");
    }

    public void addMilk() {
        System.out.println("add milk");
    }
}
