package day09.lambda.ex01;

public class BottonEx {
    public static void main(String[] args) {
        Button button = new Button();

        //버튼이 누르면 "버튼이 클릭되었습니다." 람다식
        button.setClickListner(() -> {
            System.out.println("버튼이 클릭되었습니다.");
        });

        //button.click(); //"버튼이 클릭되었습니다."
        button.click();

        Button canclebutton = new Button();
        canclebutton.setClickListner(() -> System.out.println("취소 버튼이 클릭 되었습니다"));
        canclebutton.click();

    }
}
