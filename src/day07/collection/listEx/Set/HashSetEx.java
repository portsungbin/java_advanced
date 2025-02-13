package day07.collection.listEx.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Java");
        set.add("Programmin");
        set.add("perfect");
        set.add("Spring");

        //저장된 객체 수 확인
        int size = set.size();  //같은 이름을 가진 string객체를 중복 저장하지 않았다
        System.out.println(size);
    }
}
