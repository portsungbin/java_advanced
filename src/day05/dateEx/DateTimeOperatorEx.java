package day05.dateEx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//LocalDateTime 클래스는 시간을 조작 할 수 있는 기능 제공
public class DateTimeOperatorEx {
    public static void main(String[] args) {

        //1. 현재 시간 받아오기
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss"); //a는 오전,오후를 나타냄
        System.out.println("현재시간 : " + now.format(dtf));


        LocalDateTime result1 = now.plusYears(1);
        System.out.println("1년 후 현재시간 : " + result1.format(dtf));
        //1달 전
        LocalDateTime result2 = now.minusMonths(1);
        System.out.println("1달 후 현재시간 : " + result2.format(dtf));
        //1주일 후
        LocalDateTime result3 = now.plusWeeks(1);
        System.out.println("1주일 후 현재시간 : " + result3.format(dtf));
        //1일 후
        LocalDateTime result4 = now.plusDays(1);
        System.out.println("1일 후 현재시간 : " + result3.format(dtf));

        //LocalDateTime target = LocalDateTime.of(year,month,dayofMonth,hour,minute,second);
        LocalDateTime startDateTime = LocalDateTime.of(2025, 2, 10, 0,0,0);
        System.out.println("시작일 : " + startDateTime.format(dtf));
        LocalDateTime endDateTime = LocalDateTime.of(2025, 2, 11, 0, 0, 0);
        System.out.println("종료일 : " + endDateTime.format(dtf));

        if (startDateTime.isBefore(endDateTime)) {
            System.out.println("진행중");
        } else if (startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다.");
        } else if (startDateTime.isAfter(endDateTime)) {
            System.out.println("종료했습니다.");
        }

    }
}
