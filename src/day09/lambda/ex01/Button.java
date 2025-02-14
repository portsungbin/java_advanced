package day09.lambda.ex01;

public class Button {

    //정적 멤버 인터페이스
    @FunctionalInterface
    public static interface ClickListner {
        void onClick();
    }

    private ClickListner clickListner;

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }

    public void click() {
        this.clickListner.onClick();
    }
}
