package day02.InterfaceEx01;

public interface RemoteControl {
    //가장큰 볼륭을 저장할 멤버
    //상수선언
    //가장큰 불륨저장 30
    //가장작은 볼륨저장 0
    public static final int max = 30; //상수값을 적으면 모든 필드는 상수처리 된다
    int min = 0;

    public abstract void turnOn();   //
    public abstract void turnOff();  // 바디{}

    //볼륨설정
    public abstract void setVolume(int volume);

}
