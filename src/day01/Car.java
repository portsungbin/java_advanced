package day01;

public class Car {

    int speed = 0;


    public final void stop() {
        System.out.println("차를 멈추세요");
        this.speed = 0;
    }

    public void speedUp() {
        this.speed++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }
}
