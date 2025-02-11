package day06.gennericEx.ex1;

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("인형1");
        stringBox.setItem("기차장난감");
        stringBox.setItem("곰돌이 인형");
        System.out.println(stringBox.getItem());

        System.out.println(stringBox.getCount());
    }
}
