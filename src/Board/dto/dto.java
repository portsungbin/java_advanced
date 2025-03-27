package Board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dto {
    private int board_id;
    private String board_title;
    private String board_writer;
    private String board_content;
    private Date board_date;
}
