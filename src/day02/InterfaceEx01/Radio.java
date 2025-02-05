package day02.InterfaceEx01;

public class Radio implements RemoteControl{

    private int volme;

    @Override
    public void turnOn() {
        System.out.println("라디오를 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("라디오를 끈다");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.max) {
            this.volme = RemoteControl.max;
            System.out.println("라디오의 볼륨을 최대값으로 설정했습니다");
        } else if (volume < RemoteControl.min) {
            this.volme = RemoteControl.min;
            System.out.println("라디오의 볼륨값을 최소값으로 설정했습니다");
        } else {
            this.volme = volume;
        }
        System.out.println("현재 Radio 볼륨은 : " + this.volme);
    }

    private int memoryVolume;
    //내가 사용했던 이전 볼륨을 기억했다가 쉿모드 해제 이후 다시 복원
    @Override
    public void setMute(boolean mute) {
        if (mute) {
            this.memoryVolume = this.volme;
            System.out.println("쉿모드 작동");
            setVolume(RemoteControl.min);
        } else {
            System.out.println("쉿모드 해제");
            setVolume(this.memoryVolume); //원래 볼륨 복원
        }
    }
}
