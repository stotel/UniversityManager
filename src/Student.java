public class Student extends Person {
    int course;
    int group;
    Faculty faculty;

    public int getCourse() { return course; }
    public Faculty getFaculty() { return faculty; }
    public int getGroup() { return group; }

    /** Student constructor
     * @param course
     * @param faculty
     * @param group
     * @param surname
     * @param name
     */
    public Student(int course, Faculty faculty, int group, String surname, String name) {
        super(name, surname);
        this.course = course;
        this.faculty = faculty;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Студент " + surname + " " + name + " - курс: " + course + " ; факультет " + faculty + " ; група: " + group;
    }
}