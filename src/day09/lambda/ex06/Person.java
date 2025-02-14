package day09.lambda.ex06;

public class Person {

    public Member getMember1(Creatable1 creatable1){
        String id = "ssg1";
        Member member = creatable1.create(id);
        return member;
    }

    public Member getMember2(Creatable2 creatable2){
        String id = "ssg1";
        String name = "신세계";
        Member member = creatable2.create(id, name);
        return member;
    }
}
