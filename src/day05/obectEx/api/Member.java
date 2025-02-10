package day05.obectEx.api;

import java.util.Objects;

//객체의 동등비교
public class Member extends Object{
    //String id;
    String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {  //object의 equals()메소드 재정의
//        if (object instanceof Member target) {  //object Member 타입인지 검사하고 타입변환 후 target변수에 대입
//            if (name.equals(target.name)) { //id 문자열이 같은지 비교 같으면 같은회원
//                return true;
//            }
//        }
//        return false;   //같지 않으면 false 리턴
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return true;
        Member member = (Member) object;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); //name 필드의 해시코드를 반환한다.
    }
}
