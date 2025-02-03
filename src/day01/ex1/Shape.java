package day01.ex1;

public abstract class Shape {
    private double area;
    private String name;

    public Shape(){}

    public Shape(String name) {
        this.name = name;
    }

    public abstract void calculationArea();

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void print() {
        System.out.println(name + "원의 면적은 " + area);
    }

}
