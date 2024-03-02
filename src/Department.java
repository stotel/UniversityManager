import java.util.Arrays;

public class Department {

    private String name;
    private Person[] depStaff = new Person[0];

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getStaff() {
        return depStaff;
    }
    public void addProfessor(Professor professor) {
        depStaff = Arrays.copyOf(depStaff, depStaff.length+1);
        depStaff[depStaff.length-1]=professor;
    }

    public void removeProfessor(Professor professor) {
        //todo
    }

//    public Professor findProfessor(String name) {
//        for (Person pro : depStaff) {
//            if (pro.getName().equals(name)) {
//                return pro;
//            }
//        }
//        return null;
//    }
}
