package day02.InterfaceEx01;

public interface RemoteControlMain {
    public static void main(String[] args) {
        RemoteControl remoteControl;
        remoteControl = new TV();   //인터페이스 자신을 구현한 구현객체(TV)를 담을 수 있다.
        remoteControl.turnOn(); //TV의 전원ON
        remoteControl = new Radio();    //변수에 Radio교체(대입)
        remoteControl.turnOn(); //변수를 이용하여 라디오 전원ON

        //상수는 구현 객체와 관련이 없는 인터페이스의 멤버이므로 인터페이스로 바로 접근하여 상수값을 읽는다.
        System.out.println("리모컨의 최대볼륭 : " + RemoteControl.max);
        System.out.println("리모컨의 최소볼륭 : " + RemoteControl.min);



    }
}
