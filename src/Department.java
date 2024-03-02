import java.util.Arrays;
import java.util.Objects;

public class Department {
    private Faculty faculty;
    private String name;
    private Professor[] professors = new Professor[0];
    private Student[] students = new Student[0];

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty f) {
        this.faculty = f;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addProfessor(Professor professor) {
        professors = Arrays.copyOf(professors, professors.length + 1);
        professors[professors.length - 1] = professor;
        professor.setDepartment(this);
    }

    public void addStudent(Student student) {
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
        student.setDepartment(this);
    }

    public void removeProfessor(String name, String sname) {
        removeProfessor(findProfessor(name, sname));
    }

    public void removeProfessor(Professor p) {
        if (p != null) {
            Utils.remove(p, professors);
            p.setDepartment(null);
        }
    }

    public Professor findProfessor(String name, String sname) {
        for (Professor p : professors) {
            if (p.getName().equals(name) && p.getSurname().equals(sname)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Arrays.equals(professors, that.professors);
    }

    //equals helper
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(professors);
        return result;
    }
}
