package day02.InterfaceEx01.Quiz3;

public class CarFactory extends Factory implements IWorkingTogether {
    public CarFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        switch (skill) {
            case 'A':
                return 3 * getWorkingTime();
            case 'B':
                return 2 * getWorkingTime();
            case 'C':
                return getWorkingTime();
            default:
                return 0;
        }
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return makeProducts('B');
    }
}
