package day02.InterfaceEx01.Quiz3;

public abstract class Factory {
    private int openHour; //가동시각
    private int closeHour; //종료시각
    private String name;

    public Factory(String name, int openHour,int closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.name = name;
    }

    public String getFactoryName(){
        return name;
    }

    public int getWorkingTime(){
        return closeHour - openHour;
    }

    abstract int makeProducts(char skill);

    public int getOpenHour() {
        return openHour;
    }

    public void setOpenHour(int openHour) {
        this.openHour = openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(int closeHour) {
        this.closeHour = closeHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
