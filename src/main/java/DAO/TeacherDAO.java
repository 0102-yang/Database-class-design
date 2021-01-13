package DAO;

import utils.JdbcUtil.JdbcControl;
import bean.TeacherBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yang
 */
public class TeacherDAO {
    private static final Connection CONNECTION;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    static {
        CONNECTION = JdbcControl.getConnection();
    }

    public TeacherDAO() {
    }

    public TeacherBean searchTeacherById(String id) {
        String sql = "select * from teacher where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new TeacherBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcControl.closePreparedStatement(preparedStatement);
            JdbcControl.closeResultSet(resultSet);
        }

        return null;
    }

    public void insertTeacher(TeacherBean t) {
        String sql = "insert into teacher values(?,?,?,?,?)";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, t.getTeacherId());
            preparedStatement.setString(2, t.getDepartmentId());
            preparedStatement.setString(3, t.getName());
            preparedStatement.setString(4, t.getGender());
            preparedStatement.setInt(5, t.getAge());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcControl.closePreparedStatement(preparedStatement);
            JdbcControl.closeResultSet(resultSet);
        }
    }

    public void updateTeacherOldIdByNewId(String oldId, String newId) {
        String sql = "update teacher set teacher_id=? where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, oldId);
            preparedStatement.setString(2, newId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartmentIdOfTeacherById(String id, String departmentId) {
        String sql = "update teacher set department_id=? where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, departmentId);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherNameById(String id,String newName){
        String sql = "update teacher set teacher_name=? where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherAgeById(String id,int newAge){
        String sql = "update teacher set teacher_age=? where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setInt(1, newAge);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherGenderById(String id,String gender){
        String sql = "update teacher set teacher_gender=? where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, gender);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacherById(String id) {
        String sql = "delete from teacher where teacher_id=?";

        try {
            preparedStatement = CONNECTION.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcControl.closePreparedStatement(preparedStatement);
            JdbcControl.closeResultSet(resultSet);
        }
    }
}
