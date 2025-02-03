package day01.ex1;


public class Circle extends Shape{
    private double radius;

    public Circle(){}
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void calculationArea() {
        double a = radius * radius * Math.PI;
        setArea(a);
    }




}
