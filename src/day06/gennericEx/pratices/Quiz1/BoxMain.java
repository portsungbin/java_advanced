package day06.gennericEx.pratices.Quiz1;

public class BoxMain {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setMouse("로지텍마우스");
        System.out.println(stringBox.getMouse());
        System.out.println(stringBox.isOfTpye(String.class)); //타입확인하는방법

        Box<Integer> integerBox = new Box<>();
        integerBox.setMouse(2);
        System.out.println(integerBox.getMouse());
        System.out.println(stringBox.isOfTpye(Integer.class));
    }
}
