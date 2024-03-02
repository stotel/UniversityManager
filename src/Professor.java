public class Professor extends Person {

    private String title;

    public Professor(String name, String title) {
        super(name); // Call parent constructor (Person)
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
