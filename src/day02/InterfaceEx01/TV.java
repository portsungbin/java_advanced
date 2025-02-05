package day02.InterfaceEx01;

public class TV implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("TV전원을 켭니다.");
    }

    @Override
    public void turnOff() { //인터페이스에서 선언된 전원 on/off TV 스펙에 맞추어구현
        System.out.println("TV 전원을 끕니다.");
    }
}
