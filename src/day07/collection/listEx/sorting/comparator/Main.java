package day07.collection.listEx.sorting.comparator;

import lombok.Data;

import java.util.*;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main {
    public static void main(String[] args) {

        @Data
        class User {
            String name;
            int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }


        }

        List<User> list = new ArrayList<>();
        list.add(new User("홍길동", 21));
        list.add(new User("임성빈", 24));
        list.add(new User("강창선", 25));
        list.add(new User("하이히", 24));

        Collections.sort(list, new Comparator<User>() { //정식버전
            @Override
            public int compare(User o1, User o2) {
                //return Integer.compare(o1.age, o2.age);
                return o1.name.compareTo(o2.name);
            }
        });
        //정렬 리스트 출력
        Collections.sort(list,(u1,u2)-> u1.name.compareTo(u2.name)); //나이순 정렬, 축약버전

        for (User user : list) System.out.println(user.name + " " + user.age + "살");

    }
}