package day06.gennericEx.pratices.Quiz1;

//1. 어떤 타입의 객체든 저장할 수 있는 제너릭 클래스 Box. 객체를 설정하고 가져오는 메소드를 구현하세요
// Box 클래스를 확장하여 값이 특정타입인지 확인 메서드
public class Box<T> {
    private T mouse;

    public T getMouse() {
        return mouse;
    }

    public void setMouse(T mouse) {
        this.mouse = mouse;
    }

    public boolean isOfTpye(Class<?> clazz) { //타입을 확인하게 만드는 메서드
        return clazz.isInstance(mouse);
    }
}
