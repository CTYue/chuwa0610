package Interface;

public class DIMLImplementation implements DIML {
    /**
     *   只需要override add, subtract 是default方法，不override也不会报错。
     *   但是如果不override add, 就会报错
     */
    public int add(int a, int b) {
        return a + b;
    }
}
