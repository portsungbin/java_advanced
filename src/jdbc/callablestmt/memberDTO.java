package jdbc.callablestmt;

import lombok.Data;

import java.util.Date;

@Data
public class memberDTO {
    private int m_seq;
    private String m_userid;
    private String m_pwd;
    private String m_email;
    private String m_hp;
    private Date m_registdate;
}
