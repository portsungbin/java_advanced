package day04.innerClass.ex1;

public class ABMain {
    public static void main(String[] args) {
        //A클래스 생성
        A a = new A();
        //B객체 생성
        A.B b = a.new B();
    }
}
