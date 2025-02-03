package day01;

public class SuperAirPlane extends AirPlane {

    public static final int NORMAL = 1; //상수 변하지 않는값
    public static final int ADVANCED = 2;

    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if (flyMode == ADVANCED) {
            System.out.println("초음속 비행");
        }else {
            super.fly();
        }

    }
}
