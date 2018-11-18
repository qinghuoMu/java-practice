package cn.itcast.jdbc;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接conn
        String user="root";
        String url="jdbc:mysql://127.0.0.1:3306/mybatis";
        String pwd="root";
        Connection connection = DriverManager.getConnection(url, user, pwd);
        //获取statement
        String sql="select * from tb_user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setLong(1,1l);
        ResultSet resultSet = preparedStatement.executeQuery();
        //获得结果集
        //遍历结果集
        while(resultSet.next()){
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("age"));
        }
         resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
