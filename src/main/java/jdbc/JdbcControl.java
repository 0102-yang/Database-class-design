/*
 * @Author: Yang
 * @Copyright: Yang
 * @Date: 2021-01-06 21:05:15
 * @LastEditors: Yang
 * @LastEditTime: 2021-01-07 12:53:35
 * @FilePath: /idea/src/main/java/jdbc/JdbcControl.java
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author yang
 */
public class JdbcControl {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
            driver = resourceBundle.getString("driver");
            url = resourceBundle.getString("url");
            user = resourceBundle.getString("username");
            password = resourceBundle.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JdbcControl() {
    }

    public static Connection getConnection() {
        try {
            // 注册数据库的驱动
            Class.forName(driver);
            // 获取并返回数据库连接（里面内容依次是：主机名和端口、用户名、密码）
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭预处理对象
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭数据库连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
