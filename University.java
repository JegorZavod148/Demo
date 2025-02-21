import java.util.ArrayList;

public class University {

    String name;
    ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    static class Department {

        String name;
        ArrayList<Student> students;

        public Department(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

    }

    static class Student {

        String name;
        int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
