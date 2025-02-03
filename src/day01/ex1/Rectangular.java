package day01.ex1;

public class Rectangular extends Shape{
    private double width;
    private double height;


    public Rectangular(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public void calculationArea() {
        double sum = width * height;
        setArea(sum);
    }
}
