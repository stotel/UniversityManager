import java.util.Objects;

public class Professor extends Person {

    public void setFaculty(Faculty f){ faculty = f;}

    public void setDepartment(Department d){ department = d;}

    /** Professor constructor
     * @param surname
     * @param name
     */
    public Professor(String surname, String name) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Викладач " + sname + " " + name + " - факультет " + faculty + " ; кафедра " + department;
    }
}
