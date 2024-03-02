public class Student extends Person {

    private int year;

    public Student(String name, int year) {
        super(name); // Call parent constructor (Person)
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
