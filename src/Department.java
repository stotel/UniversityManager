import java.util.Arrays;

public class Department {

    private String name;
    private Professor[] professors;

    public Department(String name) {
        this.name = name;
        this.professors = new Professor[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor[] getStaff() {
        return professors;
    }
    public void addProfessor(Professor professor) {
        professors = Arrays.copyOf(professors, professors.length+1);
        professors[professors.length-1]=professor;
    }

    public void removeProfessor(Professor professor) {
        //todo
    }

    public Professor findProfessor(String name) {
        for (Professor pro : professors) {
            if (pro.getName().equals(name)) {
                return pro;
            }
        }
        return null;
    }
}
