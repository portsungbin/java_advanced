package day01.ex3;

public class Bike extends Wheeler {
    int velocity;
    public Bike(String carName, int velocity, int wheelNumber) {
        this.wheelNumber = wheelNumber;
        this.carName = carName;
        this.velocity = velocity;
    }

    @Override
    public void speedUp(int speed) {

    }

    @Override
    public void speedDown(int speed) {

    }
}
