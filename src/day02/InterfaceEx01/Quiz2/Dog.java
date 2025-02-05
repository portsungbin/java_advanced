package day02.InterfaceEx01.Quiz2;

public class Dog extends Animal{

    public Dog(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance(getSpeed() * hours / 2.0);
    }

}
