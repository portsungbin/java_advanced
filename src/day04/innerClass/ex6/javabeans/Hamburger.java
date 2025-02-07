package day04.innerClass.ex6.javabeans;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
// 메소드를 사용한 자바빈 으로 리팩토링
public class Hamburger {
    //필수 멤버
    private int bun;
    private int patty;


    //선택 멤버
    private int cheese;
    private int lettuce;
    private int tomato;
    private int bacon;



}
