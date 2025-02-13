package day07.collection.listEx.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        Student 철수 = new Student(250123, "김철수");
        Student 영희 = new Student(250123, "최영희");
        Student 짱구 = new Student(230867, "신짱구");
        Student 도리 = new Student(230867, "박도리");

        List<Student> list = new ArrayList<>();
        list.add(철수);
        list.add(영희);
        list.add(짱구);
        list.add(도리);
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
