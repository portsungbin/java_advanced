package day01.package2;

import day01.package1.A;

public class D extends A {
//D클래스는 A클래스아 다른 패키지에 있지만 A의 자식이므로 A의 protected 필드, 생성자, 메소드는 접근이 가능
//하지만, new 연산자를 사용해서 생성자 직접 호출은 안되지만 ,자식 생성자 안에서 super()로 A의 생성자를 호출만 가능

    public D() {
        super(); //A생성자 호출
    }

    public void method1() {
        this.field1 = "value";
        this.method1();
    }

    public void method2() {
        //A a= new A();   //직접 객체 생성해서 사용하는 것은 안됨 protected의 한계
    }

}
