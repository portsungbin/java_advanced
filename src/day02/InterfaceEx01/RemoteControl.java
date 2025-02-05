package day02.InterfaceEx01;

public interface RemoteControl {
    //가장큰 볼륭을 저장할 멤버
    public static final int max = 30; //상수값을 적으면 모든 필드는 상수처리 된다
    int min = 0;
    public abstract void turnOn();   //
    public abstract void turnOff();  // 바디{}


}
