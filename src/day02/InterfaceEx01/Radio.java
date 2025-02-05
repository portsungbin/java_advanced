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
}
