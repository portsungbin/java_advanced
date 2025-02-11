package day06.gennericEx.pratices.Quiz2;

//2. 어떤 타입 배열을 받아 요소를 출력하는 제너릭 메서드 printArray를 작성하세요
// Box 클래스를 확장하여 값이 특정타입인지 확인 메서드
public class GennericMethodEx {
    public static <T> void printArray(T[] array) {
        for (T t : array) System.out.print(t + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] mouse = {"로지텍", "삼성"};
        printArray(mouse);
        Integer[] graphics = {2080, 3080, 4080};
        printArray(graphics);

    }
}
