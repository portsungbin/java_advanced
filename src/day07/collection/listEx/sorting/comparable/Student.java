package day07.collection.listEx.sorting.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private int sno;
    private String name;

//학번 정렬 후 같은 학번일 경우 이름 순으로 오름차순
    @Override
    public int compareTo(Student o) {
//        if (this.sno > o.sno) return 1;
//        else if (this.sno == o.sno) return 0;
//        else return -1; //자리바꿈
//        return o.sno - this.sno; // 위에를 이해했다면 이렇게 -를 했을때 양수 또는 음수가 나오므로 리턴 값이 나옴
        if (this.sno > o.sno) {
            return 1;
        } else if (this.sno == o.sno) {
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

