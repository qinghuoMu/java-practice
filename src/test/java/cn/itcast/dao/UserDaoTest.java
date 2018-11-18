package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 初始化userDao
        this.userDao = new UserDaoImpl(sqlSession);

    }

    @Test
    public void queryUserById() throws Exception {
        User user =this.userDao.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() throws Exception {
        List<User> users = userDao.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setName("柳岩");
        user.setPassword("123456");
        user.setuserName("liuyan");
        user.setSex(3);
        user.setBirthday(new Date());
        this.userDao.save(user);

    }

    @Test
    public void update() throws Exception {
        // 查询
        User user = this.userDao.queryUserById(8l);
        // 更新
        user.setAge(28);
        user.setPassword("111111");
        this.userDao.update(user);

    }

    @Test
    public void deleteById() throws Exception {
            this.userDao.deleteById(7l);
    }

}