package DAO;

import utils.JdbcUtil.JdbcControl;
import bean.TeacherBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
    private Connection connection = JdbcControl.getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public TeacherDAO() {
    }

    public TeacherBean searchTeacherById(int id) {
        String sql = "select * from teacher where teacher_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                //TODO: 需要添加参数。
                return new TeacherBean();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean createTeacher(Object[] params) {
        // TODO
        return false;
    }
}
