package day02.InterfaceEx01.ex02;

public class Driver {

    Vehicle v1 = new Bus();
    Vehicle v2 = new Bus();

    public void start() {
        v1.run();
        v2.run();
    }
}
