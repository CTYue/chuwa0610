package Interface;

public class Test {
    public static void main(String[] args) {
        DIMLImplementation dim = new DIMLImplementation();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.subtract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
