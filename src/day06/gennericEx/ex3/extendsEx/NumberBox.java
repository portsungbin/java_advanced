package day06.gennericEx.ex3.extendsEx;

import java.util.List;

//Number 타입만 지원하는 제너릭 클래스
//Number를 확장하는 클래스만 NumberBox의 타입매개변수로 사용할 수 있다.
public class NumberBox <T extends Number>{
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
// 상한 제한 와일드카드(? extends T) 알려지지 않은 유형이 특정 타입 또는 그 하위클래스가
    public void printNumberList(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }
// 어떤 유형과도 함께 사용할 수 있도록 유연성 제공
    public void printList(List<?> list) {
        for (Object element : list) System.out.println(element);
    }

//하안 제한 와일드 카드 (? super T) 특정 타입 또는 그 상위 클래스 중 하나를 허용
    public void addNumbers(List<? super Integer> list) {
        list.add(10);
    }

}
