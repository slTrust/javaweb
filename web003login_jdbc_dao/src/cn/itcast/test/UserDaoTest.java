package cn.itcast.test;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;
public class UserDaoTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("111");
        UserDao dao = new UserDao();
        User loginuser = dao.login(user);
        System.out.println(loginuser);
    }

}
