package itcast.datasource.c3p0;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        /*try {
            //1、创建数据库连接对象，不传参数时使用默认的数据源配置  一般都是使用空参的
            DataSource ds = new ComboPooledDataSource();
            //2、获取连接对象
            for (int i = 0; i <=10; i++) {
                Connection conn = ds.getConnection();
                System.out.println(i+"---"+conn);
                if(i == 5){
                    conn.close();//归还连接到连接池中
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        testNameConfig();

    }
    public static void testNameConfig() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i+"--"+connection);

        }
    }
}
