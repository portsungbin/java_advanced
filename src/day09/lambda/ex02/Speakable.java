package day09.lambda.ex02;
// String 컨텐츠를 제공하면 컨텐츠를 읽어주는 speak() 메소드를 가지고 있는 함수형 인터페이스 입니다.
@FunctionalInterface
public interface Speakable {
    void speak(String contents);
}
