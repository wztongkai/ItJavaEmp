package itcast.datasource.Jdbctemplate;

import itcast.datasource.util.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo1 {
  public static void main(String[] args) {
    // 创建JdbcTemplate对象
    JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
    String sql = "update user set password = 123 where id = ?";
    int count = template.update(sql, 3); // 3-->给？ 号赋值
    System.out.println(count);
  }
}
