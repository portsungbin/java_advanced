package day01;

class AA{}
class BB extends AA{}
class DD extends BB{}
class CC extends AA{}
class EE extends CC{}

public class PromotionMain1 {
    BB b = new BB();
    CC c = new CC();
    DD d = new DD();
    EE e = new EE();

    AA a1 = b; //자동 프로모션 (자동 타입변환)
    AA a2 = c; //상속 관계에 있음
    AA a3 = d;
    AA a4 = e;

    BB b1 = d;
    CC c1 = e;

    //BB b2 = e;    //안됨 컴파일에러(상속 관계에 있지 않다.)
    //CC c2 = d;
}
