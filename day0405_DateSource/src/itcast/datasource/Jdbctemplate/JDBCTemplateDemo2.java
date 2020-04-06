package itcast.datasource.Jdbctemplate;

import itcast.datasource.pojo.user;
import itcast.datasource.util.DBUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo2 {
    private JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

    /**
     * 修改一条记录
     */
    @Test
    public void test1() {
        String sql = "update user set password = 123456 where id = 1";
        template.update(sql);
    }

    /**
     * 新增一条记录
     */
    @Test
    public void test2() {
        /*String sql = "insert into user(id,username,password) values(?,?,?)";
        int count = template.update(sql, 4, "lisi", "123456");*/
        String sql = "insert into user values(?,?,?)";
        template.update(sql, null, "lisi", "123456");
    }

    /**
     * 删除一条记录
     */
    @Test
    public void test3(){
        String sql = "delete from user where id = ?";
        template.update(sql,5);
    }

    /**
     * 查询id=1的数据，并将结果封装为Map集合    只能是一条数据
     */
    @Test
    public void test4(){
        String sql = "select * from user where id = ?";
        Map<String, Object> map = template.queryForMap(sql,1);
        /*String sql = "select * from user where id = ? or id = ?";
        Map<String, Object> map = template.queryForMap(sql,1,2);*/
        System.out.println(map);
        //两条数据时：报错Incorrect result size: expected 1, actual 2
        //结果--->{id=1, username=张三, password=123456}
    }

    /**
     *查询所有的数据，将其封装为list集合
     * queryForList---->先每一条数据封装成Map集合，，在将Map集合封装进List集合中
     */
    @Test
    public void test5(){
        String sql = "select * from user";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
            //结果
            //{id=1, username=张三, password=123456}
            //{id=2, username=李四, password=123}
            //{id=3, username=zhangsan, password=123}
        }
    }

    /**
     * 查询所有记录，将其封装成user对象(javabean)的list集合
     */
    @Test
    public void test6(){
        String sql = "select * from user";
        List<user> list = template.query(sql, new RowMapper<user>() {
            @Override
            public user mapRow(ResultSet resultSet, int i) throws SQLException {
                user u = new user();
                /*int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                u.setId(id);
                u.setUsername(username);
                u.setPasssword(password);*/
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPasssword(resultSet.getString("password"));
                return u;
            }
        });
        for (user u : list) {
            System.out.println(u);
        }
    }

    /**
     * test6的简化方法
     */
    @Test
    public void test6_2(){
        String sql = "select * from user";
        List<user> list = template.query(sql, new BeanPropertyRowMapper<user>(user.class));
        for (user u : list) {
            System.out.println(u);
        }
    }

    /**
     * 查询所有记录数
     * queryForObject---->一般用来执行聚合函数（sum、avg、count、max、min）
     */
    @Test
    public void test7(){
        String sql = "select count(id) from user";
        Long totle = template.queryForObject(sql, Long.class);
        System.out.println(totle);
    }
}
