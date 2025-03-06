package jdbc.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CallableStmtEx04 {
    Connection conn = null;
    CallableStatement cs = null;



    public CallableStmtEx04() throws SQLException{
        // 1. connection 얻어오기
        conn = DBUtil.getConnection();
        conn.setAutoCommit(false);


        // 2. callableStatement 객체를 이용하여 호출할 프로시저 연결
        cs = conn.prepareCall("{call SP_MEMBER_LIST()}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()){
            memberDTO memberDTO = new memberDTO();
            memberDTO.setM_seq(rs.getInt("m_seq"));
            memberDTO.setM_userid(rs.getString("m_userid"));
            memberDTO.setM_pwd(rs.getString("m_pwd"));
            memberDTO.setM_email(rs.getString("m_email"));
            memberDTO.setM_hp(rs.getString("m_hp"));
            memberDTO.setM_registdate(rs.getDate("m_registdate"));
            System.out.println(memberDTO);
        }


        // 4. out 파라미터에 저장된 프로시저의 수행결과에 대한 외부 변수 등록

        // 5. 쿼리 수행
        // flag의 값은 resultSet 객체의 경우는 true, 갱신카운트 또는 결과가 없는 flase 리턴 됨




        if(cs != null) cs.close();
        if(rs != null) rs.close();
        if(conn != null) conn.close();

    }

    public static void main(String[] args) throws SQLException {
        new CallableStmtEx04();
    }



}
