package Boardrpt;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public Board() {
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        return "##########\n" +
                "번호: " + bno + "\n" +
                "제목: " + btitle + "\n" +
                "내용: " + bcontent + "\n" +
                "작성자: " + bwriter + "\n" +
                "날짜: " + (bdate != null ? sdf.format(bdate) : "null");
    }

}

