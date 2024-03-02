import java.util.Arrays;

public class Faculty {

    private String name;
    private static Department[] departments = new Department[0];
    public static Student[] students = new Student[0];

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    // Methods for managing departments within the faculty
    public void addDepartment(Department department) {
        departments = Arrays.copyOf(departments,departments.length+1);
        departments[departments.length-1]=department;
    }
    public void addStudent(Student student) {
        students = Arrays.copyOf(students,students.length+1);
        students[students.length-1]=student;
    }

    public void removeDepartment(Department department) {
        //todo
    }
    public void removeStudent(Department student) {
        //todo
    }

    public void changeDepartment(Department department) {
        //todo
    }

    public Department findDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }
}