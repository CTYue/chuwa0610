package HW4.coding.new_features.lambda;

public interface Foo {
    String aMethod(String str);

    default String defaultBar(){
        String s = "default bar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon(){
        String s = "default common from bar";
        System.out.println(s);
        return s;
    }
}
