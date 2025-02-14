package day09.lambda.ex01;

public class WorkMain {
    public static void main(String[] args) {
        Person person = new Person();

        person.action(() -> {
            System.out.println("9시까지 출근을 합니다");
            System.out.println("화이팅");
            System.out.println("6시 퇴근");
                }
        );

        person.action(() -> System.out.println("주말엔 축구~"));

    }
}
