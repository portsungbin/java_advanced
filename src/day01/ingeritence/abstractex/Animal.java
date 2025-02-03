package day01.ingeritence.abstractex;

public abstract class Animal {
    public abstract void sound();    //추상메서드

    public void breathe() {
        System.out.println("동물은 숨을 쉽니다.");
    }
}
