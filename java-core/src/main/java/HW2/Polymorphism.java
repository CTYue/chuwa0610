package HW2;

public class Polymorphism {

    public class Animal {
        public void makeSound() {
            System.out.println("make sound");
        }

    }
    public class  dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("wangwang");
        }
    }
    public class  cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("miaomiao");
        }
    }
}
