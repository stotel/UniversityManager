import java.util.Objects;

public class Student extends Person {
    private int course;
    private int group;

    public int getCourse() { return course; }
    public int getGroup() { return group; }
    public void setFaculty(Faculty f){ faculty = f; }
    public void setDepartment(Department d){ department = d; }
    public void setCourse(int c){ course = c;}
    public void setGroup(int g){ group = g;}

    /** Student constructor
     * @param course
     * @param group
     * @param surname
     * @param name
     */
    public Student(int course, int group, String surname, String name) {
        super(name, surname);
        this.course = course;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getCourse() == student.getCourse() && getGroup() == student.getGroup() && Objects.equals(getName(), student.getName())
                && Objects.equals(getSurname(), student.getSurname())&& Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getGroup(), getFaculty(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Студент " + getSurname() + " " + getName() + " - курс: " + getCourse() + " ; факультет " + getFaculty() + " ; група: " + getGroup();
    }
}