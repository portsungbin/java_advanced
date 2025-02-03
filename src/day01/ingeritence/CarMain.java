package day01.ingeritence;


public class CarMain {
    public static void main(String[] args) {
        Car mycer = new Car();

        //자동차에 타이어를 장착
        mycer.tire = new Tire();
        mycer.run();

        //HankookTire 교환
        mycer.tire = new HankookTire();
        mycer.run();

        //KumhoTire 교환
        mycer.tire = new KumhoTire();
        mycer.run();


    }
}
