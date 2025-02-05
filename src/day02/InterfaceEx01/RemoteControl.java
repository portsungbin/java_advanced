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

    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("쉿 모드로 전환됩니다.");
            setVolume(min);
        }else {
            System.out.println("쉿 모드가 해제되었습니다.");
        }
    }

    //배터리 교체 가능을 정적메소드를 통하여 구현 changeBattery() 객체없이 호출가능(클래스를 호출하는 변수명)

    public static void changeBattery(){
        System.out.println("건전지를 교체합니다.");
    }



}
