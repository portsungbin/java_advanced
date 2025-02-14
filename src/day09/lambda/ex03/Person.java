package day09.lambda.ex03;


//Person 클래스는 Calculable을 매개변수로 갖는 calculate 메소드를 갖고 있다.
//calculate 메소드는 Calculable 인터페이스를 매개변수로 갖는 메소드이다.
public class Person {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void action(Calculable calculable) {
        double result = calculable.calculate(20, 5);
        System.out.println("결과 : " + result);
    }
}
