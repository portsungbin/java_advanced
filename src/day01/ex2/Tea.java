package day01.ex2;

public class Tea extends Beverage {
    static int amount = 0;

    public Tea(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (name) {
            case "lemonTea" :
                setPrice(1500);
                break;
            case "ginsengTea" :
                setPrice(2000);
                break;
            case "redginsengTea" :
                setPrice(2500);
                break;
        }
    }
}
