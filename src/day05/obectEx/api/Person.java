package day05.obectEx.api;

import lombok.Data;

//데이터 전달을 위한 역활 : DTO (Data Transfer Object) 반복적으로 사용되는 코드를 줄이기 위해 java14 record 도입
//DTO : 한사람의 정보를 담는 행 데이터베이스 : row, 클래스단위 : DTO, 정보의 단위 : record
// 정보의 단위 : record , row(행)
@Data //toString, setter, getter 다 만들어줌
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    public String name() {
//        return this.name;
//    }
//    public int age() {
//        return this.age;
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
