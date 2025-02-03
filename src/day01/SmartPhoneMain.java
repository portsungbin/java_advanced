package day01;

public class SmartPhoneMain {
    public static void main(String[] args) {

        SmartPhone myPhone = new SmartPhone("갤럭시", "흰색");
        //폰으로부터 상속받은 필드 읽어서 출력
        System.out.println(myPhone.model);
        //스마트폰의 필드 읽어서 출력
        System.out.println(myPhone.wifi);
        //폰으로부터 상속받은 메소드 호출
        myPhone.bell();
        //스마트폰으로부터 상속받은 메소드 호출
        myPhone.setWifi(true);
    }
}
