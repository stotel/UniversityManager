public class Professor extends Person {
    Department department;
    Faculty faculty;

    public Faculty getFaculty() { return faculty; }
    public Department getDepartment() { return department; }

    /** Professor constructor
     * @param faculty
     * @param department
     * @param surname
     * @param name
     */
    public Professor(Faculty faculty, Department department, String surname, String name) {
        super(name, surname);
        this.faculty = faculty;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Викладач " + surname + " " + name + " - факультет " + faculty + " ; кафедра " + department;
    }
}
