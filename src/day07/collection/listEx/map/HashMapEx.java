package day07.collection.listEx.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("최문규", 100);
        map.put("이동휘", 100);
        map.put("신민혁", 100);
        System.out.println(map.size());
        System.out.println("-------------");

        //키로 값을 얻기
        String key = "이동휘";
        int value = map.get(key);
        System.out.println();

        //키 Set 컬렉션을 얻고, 반복해서 값을 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyiter = keySet.iterator();
        while (keyiter.hasNext()) {
            String k = keyiter.next(); //가져오기
            Integer v = map.get(k); //받기
            System.out.println(k + ":" + v);
            String value1 = String.valueOf(map.remove(k));
            System.out.println("map사이트에서" + value1 + " 삭제하였습니다.");
        }

    }
}
