package day03.Quiz1;

public class Main{

    public static void main(String[] args) {
        B b = new B();

        C c = new C();

        action(b);
        action(c);

    }

public static void action(A a) {
    if (a instanceof C) {
        ((C)a).method2();
    }else {
        a.method1();
    }
}
}
