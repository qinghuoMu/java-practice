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
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    private UserMapper userMapper;
    SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 初始化userMapper
        this.userMapper = sqlSession.getMapper(UserMapper.class);

    }
    @Test
    public void testCache(){
        User user1 = this.userMapper.queryUserById(1l);
        System.out.println(user1);
        System.out.println("=================第二次查询======================");
        User user2 = this.userMapper.queryUserById(1l);
        System.out.println(user2);
    }

    @Test
    public void queryUserListByIds() {

        Long[] ids = new Long[]{1l,2l,3l,4l};
        //long[] ids1=new long[]{1,2,3,4};
        List<User> users = userMapper.queryUserListByIds(ids);
        for (User user : users) {
            System.out.println(user);

        }

    }
    @Test
    public void updateUserSelective() {
        User user = userMapper.queryUserById(13l);
        user.setuserName(null);
        user.setAge(13);
        user.setPassword("12");
        user.setSex(2);
        userMapper.updateUserSelective(user);
        sqlSession.commit();


    }
    @Test
    public void queryUserListlikeUsernameAndAge() {
        List<User> users = userMapper.queryUserListlikeUsernameAndAge("",0);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void queryUserListLikeQueryNameOrAge() {
        List<User> users = userMapper.queryUserListLikeQueryNameOrAge("",21);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSqlLikeUsername() {
        List<User> users = userMapper.queryUserListLikeUserName("");
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testQueryUserByLikeUsername(){
        List<User> users = userMapper.queryUserByLikeUsername("zhang");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testHashMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username","zhangsan");
        map.put("password","123456");
        System.out.println(userMapper.loginUp(map));
    }
    @Test
    public void testQueryUserByUsernameAndPassword(){
        System.out.println(userMapper.queryUserByUsernameAndPassword("zhangsan","123456"));
    }
    @Test
    public void testQuerUserByTableName(){
        List<User> users = this.userMapper.queryUserByTableName("tb_user");

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() throws Exception {
        User user =this.userMapper.queryUserById(1l);
        System.out.println(user);

    }

    @Test
    public void queryUserAll() throws Exception {
        List<User> users = userMapper.queryUserAll();
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
        this.userMapper.save(user);
        sqlSession.commit();
    }

    @Test
    public void update() throws Exception {
        // 查询
        User user = this.userMapper.queryUserById(4l);
        // 更新
        user.setAge(28);
        user.setPassword("111111");
        this.userMapper.update(user);
        sqlSession.commit();
    }

    @Test
    public void deleteById() throws Exception {
            this.userMapper.deleteById(12l);
        sqlSession.commit();
    }


}