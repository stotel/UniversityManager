import java.util.Arrays;
import java.util.Objects;

public class Faculty {
    private String name;
    private Department[] departments = new Department[0];

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    // Methods for managing departments within the faculty
    public void addDepartment(Department department) {
        departments = Arrays.copyOf(departments,departments.length+1);
        departments[departments.length-1]=department;
        department.setFaculty(this);
    }
    public void removeDepartment(String depName) {
        removeDepartment(findDepartment(depName));
    }
    public void removeDepartment(Department dep) {
        if(dep != null) {
            Utils.remove(dep, departments);
            dep.setFaculty(null);
        }
    }


    public Department findDepartment(String name) {
        for (Department d : departments) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Arrays.equals(departments, faculty.departments) && Arrays.equals(students, faculty.students);
    }
    //equals helper
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(departments);
        //result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}