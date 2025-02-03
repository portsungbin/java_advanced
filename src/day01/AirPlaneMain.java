package day01;

public class AirPlaneMain {
    public static void main(String[] args) {
        //AirPlane 생성, 이륙, 날다, 착륙하다 수행
        AirPlane ap = new AirPlane();
        ap.takeOff();
        ap.fly();
        ap.land();
        //SuperAirPlane 생성, 이륙, 날다, 착륙 수행
        SuperAirPlane sap = new SuperAirPlane();
        sap.takeOff();
        sap.flyMode = SuperAirPlane.ADVANCED;
        sap.fly();
        sap.land();

    }
}
