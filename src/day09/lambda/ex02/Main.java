package day09.lambda.ex02;

public class Main {
    public static void main(String[] args) {
        //황가람은 가수 입니다.. 출력
        //"저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다." 말합니다. 출력
        //"반딧불" 노래를 부릅니다.
        Person person = new Person("황가람", "가수", "저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다.", "반딧불");
        person.action(((name, job) -> System.out.println(name + "은 " + job + "입니다.")));
        person.action2((contents) -> System.out.println(contents + " 말합니다."));
        person.action3((songtitle) -> System.out.println(songtitle + "노래를 부릅니다."));
        System.out.println();
        //조수미는 오페라가수 입니다. 출력
        //"저를 오랫동안 사랑해주셔서 감사합니다." 말합니다. 출력
        //"밤의 아리아" 노래를 부릅니다.
        Person person1 = new Person("황가람", "가수", "저를 오랫동안 사랑해주셔서 감사합니다.", "반딧불");
        person1.action(((name, job) -> System.out.println(name + "은 " + job + "입니다.")));
        person1.action2((contents) -> System.out.println(contents + " 말합니다."));
        person1.action3((songtitle) -> System.out.println(songtitle + "노래를 부릅니다."));

    }
}
