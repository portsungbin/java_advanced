package day01.ex2;

public class Coffee extends Beverage{
    static int amount = 0;

    public Coffee(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (name) {
            case "Amricano" :
                setPrice(1500);
                break;
            case "CafeLatte" :
                setPrice(2500);
                break;
            case "Cappuccino" :
                setPrice(3000);
                break;
        }
    }
}
