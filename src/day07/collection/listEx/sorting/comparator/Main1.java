package day07.collection.listEx.sorting.comparator;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main1 {
    public static void main(String[] args) {


        class User {
            private String name;
            private int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        List<User> list = new ArrayList<>();
        list.add(new User("홍길동", 21));
        list.add(new User("임성빈", 24));
        list.add(new User("강창선", 25));
        list.add(new User("하이히", 24));

        Collections.sort(list, Comparator.comparing(User::getAge)); // 나이순으로 정렬하겠다.
            for (User user : list) System.out.println(user.name + " " + user.age + "살"); //출력

        System.out.println("--------------------------------------");

        Collections.sort(list, Comparator.comparing(User::getName)); // 이름순으로 정렬하겠다.
        for (User user : list) System.out.println(user.name + " " + user.age + "살");

        System.out.println("--------------------------------------");

        Collections.sort(list, Comparator.comparing(User::getAge).thenComparing(User::getName)); // 두가지 다 정렬을 하겠다. 나이를 기준으로 이름 정렬 나이가 같으면 이름으로 정렬임
        for (User user : list) System.out.println(user.name + " " + user.age + "살");



    }
}