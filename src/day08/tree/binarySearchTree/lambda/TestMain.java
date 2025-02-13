package day08.tree.binarySearchTree.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestMain {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from a thread");
//            }
//        };
//
//        Runnable runnable1 = () -> System.out.println("Hello from a thread"); //위에 코드랑 동일

        Function<String, Integer> stringLength = String::length;
        List<String> names = Arrays.asList("Alice","Bob","John","David");
        names.forEach(System.out::println);

    }
}
