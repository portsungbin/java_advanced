package day01.ex1;


public class TestShape {
	public static void main(String[] args) {

		Shape[] shapes = new Shape[2];

		shapes[0] = new Rectangular("직사각형", 10, 20);
		shapes[1] = new Circle("원", 10);

		// 반복문을 사용하여 모든 도형의 면적을 계산하고 출력
		for (Shape shape : shapes) {
			shape.calculationArea(); // 면적 계산
			shape.print();           // 결과 출력
		}
	}
}