package day01.ingeritence.ex02;

public class Driver {
    public void drive(Vehicle vehicle) {
//        Object obj = vehicle;
//        Vehicle v = (Vehicle) obj;
        if (vehicle instanceof Taxi || vehicle instanceof Bus) {
            vehicle.run();
        } else {
            System.out.println("운영자격이 해당하지 않습니다");
        }
    }
}
