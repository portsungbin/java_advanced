package day01.ingeritence.ex01;

public class TVmain {

    public static void main(String[] args) {
        TV tv_remotecontrol1 = new TV(); //동일한 클래스 타입의 참조 변수를 생성해서 초기화
        TV tv_remotecontrol2 = new SmartTV(); // 부모타입으로 자식클래스 타입을 받아 초기화
        // TV클래스 타입의 참조변수 tv_remotecontral2 를 선언하고, SmartTV인스턴스를 생성하여, 이 인스턴스의 주소값을 참조변수 tv_remotecontral2 대입한다
        SmartTV smartTV_remotecontrol = new SmartTV();

        TV tv = new TV();
        SmartTV smart_control = (SmartTV) tv;

    }
}
