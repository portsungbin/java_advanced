package day02.InterfaceEx01.ex02;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.start();

        driver.v1 = new Taxi();
        driver.v2 = new Taxi();

        driver.start();

    }
}
