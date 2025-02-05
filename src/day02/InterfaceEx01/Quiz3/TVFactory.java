package day02.InterfaceEx01.Quiz3;

public class TVFactory extends Factory implements IWorkingTogether {
    public TVFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        switch (skill) {
            case 'A':
                return 8 * getWorkingTime();
            case 'B':
                return 5 * getWorkingTime();
            case 'C':
                return 3 * getWorkingTime();
            default:
                return 1;
        }
    }


    @Override
    public int workTogether(IWorkingTogether partner) {
        return makeProducts('C');
    }
}
