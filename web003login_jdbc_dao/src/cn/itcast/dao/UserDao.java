package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/*
操作数据库的 User表
*/
public class UserDao {
    // 声明 JDBCTemplate对象 公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){
       try {
           // 1. 编写sql
           String sql = "select * from user where username = ? and password = ?";
           // 2. 调用query
           User user = template.queryForObject( sql ,
                   new BeanPropertyRowMapper<User>(User.class),
                   loginUser.getUsername(),loginUser.getPassword());
           return user;
       }catch (DataAccessException e){
            e.printStackTrace(); // 记录日志
            return null;
       }
    }

}
