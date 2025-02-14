package day09.lambda.ex01;
//Person 클래스는 Workable을 매개변수로 갖는 action 메소드를 갖고 있다.
public class Person {

    public void action(Workable workable) {
        workable.work();
    }
}
