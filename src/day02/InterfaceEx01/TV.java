package day02.InterfaceEx01;

public class TV implements RemoteControl {
    private int volume;
    @Override
    public void turnOn() {
        System.out.println("TV전원을 켭니다.");
    }

    @Override
    public void turnOff() { //인터페이스에서 선언된 전원 on/off TV 스펙에 맞추어구현
        System.out.println("TV 전원을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.max){
            this.volume = RemoteControl.max;
            System.out.println("현재 해당 제품의 불륨 최대값으로 셋팅 되었습니다.");
        } else if (volume < RemoteControl.min) {
            this.volume = RemoteControl.min;
            System.out.println("mute");
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV 볼륨은 : " + this.volume);
    }
}
