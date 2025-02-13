package day07.collection.listEx.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Member> members = new HashSet<>();

        //회원 가입해서 정보를 저장
        members.add(new Member("홍길동",30));
        members.add(new Member("홍길순", 30));
        members.add(new Member("홍길순", 30));
        members.add(new Member("홍길자", 30));
        members.add(new Member("홍길막", 30));

        for (Member member : members) System.out.println(member.name);

        //객체를 반복자 Iterator 을 이용하여 처리
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            //객체를 하나씩 꺼내오기
            Member member = iterator.next();
            System.out.println(member.name + " " + member.age);
            iterator.remove();
            int size = members.size();
            System.out.println("현재 회원 수 : " + members.size());
        }
    }
}
