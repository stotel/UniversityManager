import java.util.Objects;

public class Professor extends Person {

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
