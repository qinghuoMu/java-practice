package cn.itcast.dao;

import cn.itcast.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class OrderMapperTest {
    private OrderMapper orderMapper;
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
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);

    }
    @Test
    public void queryOrderLazy() {
        Order order = orderMapper.queryOrderLazy("20140921001");
        System.out.println("======================");
        System.out.println(order.getOrderNumber());
        System.out.println("======================");
        System.out.println(order.getUser());
    }
    @Test
    public void queryOrderAndUserAndOrderdetailAndItemByOrderNum() {
        Order order = orderMapper.queryOrderAndUserAndOrderdetailAndItemByOrderNum("20140921001");
        System.out.println(order);
    }
    @Test
    public void queryOrderAndUserByOrderNum() {
        Order order =orderMapper.queryOrderAndUserByOrderNum("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderAndUserAndOrderdetailByOrderNum() {
        Order order = orderMapper.queryOrderAndUserAndOrderdetailByOrderNum("20140921001");
        System.out.println(order);

    }

}