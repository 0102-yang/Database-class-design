/*
 * @Author: Yang
 * @Copyright: Yang
 * @Date: 2021-01-02 23:30:45
 * @LastEditors: Yang
 * @LastEditTime: 2021-01-07 15:44:57
 * @FilePath: /idea/src/main/java/test/IdeaTest.java
 */
package test;

import jdbc.JdbcControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author yang
 * @date 2021/01/06
 */
public class IdeaTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcControl.getConnection();
        // 3.需要执行的sql语句（?是占位符，代表一个参数）
        String sql = "insert into student values(?,?,?,?)";
        // 4.获取预处理对象，并依次给参数赋值
        assert connection != null;
        PreparedStatement statement = connection.prepareCall(sql);
        statement.setString(1, "c01"); // 数据库字段类型是int，就是setInt；1代表第一个参数
        statement.setString(2, "s01");
        // 数据库字段类型是String，就是setString；2代表第二个参数
        statement.setString(3, "小明");
        statement.setInt(4,
                16); // 数据库字段类型是int，就是setInt；3代表第三个参数
        // 5.执行sql语句（执行了几条记录，就返回几）
        int i = statement.executeUpdate();
        System.out.println(i);
        // 6.关闭jdbc连接
        JdbcControl.closeStatement(statement);
        JdbcControl.closeConnection(connection);
    }
}
