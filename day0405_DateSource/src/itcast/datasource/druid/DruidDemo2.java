package itcast.datasource.druid;

import itcast.datasource.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnecetion();
            String sql = "insert into user values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"zhangsan");
            pstmt.setString(2,"123456");
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(pstmt,conn);
        }
    }
}
