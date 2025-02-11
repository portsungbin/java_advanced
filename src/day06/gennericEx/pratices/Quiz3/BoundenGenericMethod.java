package day06.gennericEx.pratices.Quiz3;
// 3. Compareable<T>를 확장시키는 타입의 두객체를 비교하는
// 제너릭 메소드 ComparTo 를 작성하세요. 이 메서드를 이용하여 두 숫자를 비교하세요
public class BoundenGenericMethod {

    public static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(BoundenGenericMethod.min(5, 10));
    }
}
