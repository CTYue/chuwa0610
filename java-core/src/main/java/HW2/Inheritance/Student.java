package HW2.Inheritance;

public class Student extends Person {
    private String studentId;

    // 构造函数
    public Student(String name, int age, String studentId) {
        super(name, age); // 调用父类的构造函数
        this.studentId = studentId;
    }

    // 公有的 getter 方法
    public String getStudentId() {
        return studentId;
    }

    // 重写 displayInfo 方法
    @Override
    public void displayInfo() {
        super.displayInfo(); // 调用父类的 displayInfo 方法
        System.out.println("Student ID: " + studentId);
    }
}
