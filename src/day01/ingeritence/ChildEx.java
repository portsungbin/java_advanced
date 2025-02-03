package day01.ingeritence;

public class ChildEx {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.method1();
        parent.method2();

        Child child = (Child)parent;
        child.method3();




    }
}
