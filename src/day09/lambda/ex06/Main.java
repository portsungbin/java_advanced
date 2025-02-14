package day09.lambda.ex06;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        Member m1 = person.getMember1(Member::new);
        System.out.println(m1);
        Member m2 = person.getMember2(Member::new);
        System.out.println(m2);
    }
}
//생성자 참조는 함수형인터페이스의 매개변수 개수에 따라 실행되는 Member생성자가 다름을 확인함