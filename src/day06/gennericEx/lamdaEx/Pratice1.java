package day06.gennericEx.lamdaEx;

import java.util.Arrays;
import java.util.List;

public class Pratice1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        names.forEach(name -> System.out.println(name));
    }
}
