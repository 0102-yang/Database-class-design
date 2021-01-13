package bean;

/**
 * @author yang
 */
public class TeacherBean {
    private String teacherId;
    private String departmentId;
    private String name;
    private String gender;
    private int age;

    @Override
    public String toString() {
        return "TeacherBean{" +
                "teacherId='" + teacherId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public TeacherBean(String teacherId, String departmentId, String name, String gender, int age) {
        this.teacherId = teacherId;
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
