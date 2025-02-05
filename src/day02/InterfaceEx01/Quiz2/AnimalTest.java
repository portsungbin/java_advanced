package day02.InterfaceEx01.Quiz2;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Chicken cheatableChicken = new Chicken(5);

		if (cheatableChicken instanceof Chicken) {
			cheatableChicken.fly();
		}

		for (int i = 0; i < 3; i++) {
			dog.run(i+1);
			chicken.run(i+1);
			cheatableChicken.run(i+1);

			System.out.println((i+1) + "시간 후");
			System.out.println("개의 이동거리" + dog.getDistance());
			System.out.println("닭의 이동거리" + chicken.getDistance());
			System.out.println("날으는 닭의 이동거리" + cheatableChicken.getDistance());
		}

	}
}










