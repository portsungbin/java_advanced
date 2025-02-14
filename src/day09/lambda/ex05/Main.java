package day09.lambda.ex05;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.ordering(String::compareToIgnoreCase); //compareToIgnoreCase = 두 문자열을 대소문자 구분없이 비교하는 메서드
        person.ordering((a,b) -> a.compareToIgnoreCase(b)); //위에 코드와 같은 의미
    }
}
