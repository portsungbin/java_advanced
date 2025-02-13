package day07.collection.listEx.board;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {
    private String subject;
    private String writer;
    private String content;

    public Board(String subject, String writer, String content) {
        this.subject = subject;
        this.writer = writer;
        this.content = content;
    }
}
