package day07.collection.listEx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// ArrayList가 느린 이유는 0번 인덱스에 새로운 객체가 추가되면서 기존 객체의 인덱스를 한칸씩 뒤로 미는 작업을 수행하기 때문이다.
public class LinkedListEx {
    public static void main(String[] args) {
        //ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<>();

        //LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<>();

        //시작시간, 끝 시간을 저장 변수 선언
        long StartTime;
        long endTime;

        //ArrayList 컬렉션에 저장하는 시간 측정
        StartTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }

        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린시간 " , (endTime-StartTime));

        StartTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린시간 " , (endTime-StartTime));

    }
}
