package day02.InterfaceEx01.Quiz2;

public abstract class Animal {
    private int speed; //속도
    private double distance; //이동거리

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getDistance() {
        return distance;
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    abstract void run(int hours);



}
