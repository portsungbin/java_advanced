package day07.collection.listEx.sorting.comparable;

import lombok.Data;

import java.util.*;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main {
    public static void main(String[] args) {

        @Data
        class User implements Comparable<User> {
            String name;
            int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }


            @Override
            public int compareTo(User o) {
                if (this.age > o.age) {
                    return 1;
                } else if (this.age == o.age) {
                    if (this.name.charAt(0) > o.name.charAt(0)) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }

            }
        }


        User mainUser1 = new User("임성빈", 27);
        User mainUser2 = new User("강창선", 29);
        User mainUser3 = new User("임성빈", 29);
        User mainUser4 = new User("강창선", 30);

        //list형태 정렬
        List<User> list = new ArrayList<>();
        list.add(mainUser1);
        list.add(mainUser2);
        list.add(mainUser3);
        list.add(mainUser4);
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("--------------------------------");
        //배열 형태 정렬
        User[] users = {mainUser1, mainUser2, mainUser3, mainUser4};
        Arrays.sort(users);
        Arrays.stream(users).forEach(System.out::println);

    }
}