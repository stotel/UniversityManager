import java.util.Objects;

public class Professor extends Person {
    private Department department;
    private Faculty faculty;

    public Faculty getFaculty() {
        faculty = department.getFaculty();
        return faculty;
    }
    public Department getDepartment() { return department; }
    public void setDepartment(Department d){ department = d;}

    /** Professor constructor
     * @param surname
     * @param name
     */
    public Professor(String surname, String name) {
        super(name, surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getDepartment(), professor.getDepartment()) &&
                Objects.equals(getName(), professor.getName()) && Objects.equals(getSurname(), professor.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartment(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Викладач " + getSurname() + " " + getName() + " - факультет " + getFaculty() + " ; кафедра " + getDepartment();
    }
}
