package day09.lambda.ex04;


public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        person.action(Computer::staticMethod); //누구나 다 사용할 수 있는 공용 컴퓨터라고 생각하면 됨
        person.action((x,y)-> Computer.staticMethod(x,y)); //람다식으로 위에 코드를 구현 위코드랑 같은 의미

        Computer computer = new Computer();
        person.action(computer::instanceMethod); //나의 컴퓨터라고 생각하면 됨
        person.action((x,y) -> computer.instanceMethod(x,y)); //람다식으로 위에 코드를 구현 위코드랑 같은 의미
    }
}
