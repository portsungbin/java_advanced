package day05.api.dateEx;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarEx {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1; //0월부터 계산해서 +1을 해서 1월부터 출력
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        int ampm = now.get(Calendar.AM_PM);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        System.out.println(year +" "+ month +" "+ day + " " + week + " " + ampm + " " + hour + " " + minute + " " + second);

        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String id : availableIDs) {
            System.out.println(id);
        }

    }
}
