package day02.InterfaceEx01.Quiz2;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Chicken cheatableChicken = new Chicken(5);

		if (cheatableChicken instanceof Chicken) {
			cheatableChicken.fly();
		}

		for (int i = 1; i < 4; i++) {
			dog.run(i);
			chicken.run(i);
			cheatableChicken.run(i);

			System.out.println((i) + "시간 후");
			System.out.println("개의 이동거리" + dog.getDistance());
			System.out.println("닭의 이동거리" + chicken.getDistance());
			System.out.println("날으는 닭의 이동거리" + cheatableChicken.getDistance());
		}

	}
}










