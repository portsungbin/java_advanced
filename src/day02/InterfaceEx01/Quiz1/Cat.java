package day02.InterfaceEx01.Quiz1;

public class Cat extends Tail implements Animal, Pet {

    public Cat(int length) {
        super(length);
    }
    @Override
    public void cry() {
        System.out.println("냐옹");
    }

    @Override
    public void play() {
        System.out.println("잘 논다.");
    }

    public void printTailLength() {
        System.out.println("꼬리 길이 : " + length);
    }

}
