package day06.gennericEx.lamdaEx;
// Transformer 재너릭 함수형 인터페이스 정의
@FunctionalInterface
public interface Transformer<T, R> {    // T는 입력타입, R은 출력타입
    R transform(T input);
}
