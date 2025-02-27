package jdbc.users;

import lombok.Data;

// 한 사용자의 정보를 담는 객체
@Data
public class User {
    private String userid;
    private String username;
    private String userpassword;
    private int age;
    private String email;

}
