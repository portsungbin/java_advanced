package day01;

public class Phone {
    public String model;
    public String color;


    //public Phone(){}

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("Phone (medel, color) 생성자 실행");
    }

    //메소드
    public void bell() {
        System.out.println("벨이 띠링띠링 울린다.");
    }

    public final void volumeUp() {
        System.out.println("볼륭을 줄입니다.");
    }


}
