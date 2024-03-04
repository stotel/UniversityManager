import java.util.Objects;

public class Student extends Person {
    private int course;
    private int group;

    public int getCourse() { return course; }
    public int getGroup() { return group; }
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
    public String toString() {
        return "Студент " + sname + " " + name + " - курс: " + course + " ; факультет " + faculty + " ; кафедра " + department +  " ; група: " + group;
    }
}