package day06.gennericEx.ex1;

//<T>카트는 아무도 뭐라고 하지 않음 왜냐 카트는 인증받은 것이기 때문
//어떤 타입이 들어와도 대체되서 int나 boolean 등 어떤 타입이 들어와도 대체가 가능하다
public class Box<T> { // T는 Box의 인스턴스를 생성할때 어떤 참조타입으로 대체될 수 있는 타입매개변수
    private T item;
    private int count = 0;  //item의 수를 추적하는 필드(컨테이너)

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
