public class Person {

    protected Department department;
    protected Faculty faculty;
    protected String name;
    protected String sname;

    public Person(String name, String sname) {
        this.name = name;
        this.sname = sname;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Department getDepartment() {
        return department;
    }

    public String getSurname() {
        return sname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String sname) {
        this.sname = sname;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

