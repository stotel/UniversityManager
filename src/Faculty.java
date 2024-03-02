import java.util.Arrays;
import java.util.Objects;

public class Faculty {
    private String name;
    private Department[] departments = new Department[0];
    private Student[] students = new Student[0];

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
        department.setFaculty(this);
    }
    public void addStudent(Student student) {
        students = Arrays.copyOf(students,students.length+1);
        students[students.length-1]=student;
        student.setFaculty(this);
    }

    public void removeDepartment(String depName) {
        removeDepartment(findDepartment(depName));
    }
    public void removeDepartment(Department dep) {
        if(dep != null) {
            Utils.remove(dep, departments);
            dep.setFaculty(null);
        }
    }
    public void removeStudent(String name, String sname) {
        removeStudent(findStudent(name, sname));
    }
    public void removeStudent(Student student) {
        if(student != null) {
            Utils.remove(student, students);
            student.setFaculty(null);
        }
    }

    public Department findDepartment(String name) {
        for (Department d : departments) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    public Student findStudent(String name, String sname) {
        for (Student s : students) {
            if (s.getName().equals(name) && s.getSurname().equals(sname)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Arrays.equals(departments, faculty.departments) && Arrays.equals(students, faculty.students);
    }
    //equals helper
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(departments);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}