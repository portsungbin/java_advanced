package day01.ex2_1;

public abstract class Beverage {
    String name;
    int price;

    public Beverage(String name) {
        this.name = name;
    }

    public abstract void calcPrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print() {
        System.out.println("번째 판매 음료는 " + name + "이며, 가격은 " + price);
    }

}
