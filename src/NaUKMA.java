import java.util.Arrays;
import java.util.Objects;

public class NaUKMA {
    private Faculty[] faculties = new Faculty[0];
    private Department[] departments;
    public Faculty[] getFaculties(){
        return faculties;
    }
    public Department[] getDepartments(){
        int len = 0;
        Department[] deps = new Department[len];
        for (Faculty f : faculties) {
            Department[] fd = f.getDepartments();
            System.arraycopy(fd, 0, deps, len, fd.length);
            len += fd.length;
        }
        departments = deps;
        return departments;
    }
    public void addFaculty(Faculty faculty) {
        faculties = Arrays.copyOf(faculties,faculties.length+1);
        faculties[faculties.length-1]=faculty;
    }
    public void addDepartment(Department department, String facName) {
        Faculty faculty = findFaculty(facName);
        if(faculty != null)
            faculty.addDepartment(department);
        else
            System.out.println("No faculty found, department was not added...");
    }
    public void addStudent(Student student, String facName){
        findFaculty(facName).addStudent(student);
    }
    public void addProfessor(Professor professor, String depName){
        for(Faculty f: faculties) {
            Department dep = f.findDepartment(depName);
            if (dep != null) {
                dep.addProfessor(professor);
                return;
            }
        }
    }
    public void removeFaculty(String name) {
        Faculty f = getFaculty(name);
        if (f != null)
            Utils.remove(f, faculties);
    }
    public void removeDepartment(String name) {
        Department d = getDepartment(name);
        if(d != null){
            d.getFaculty().removeDepartment(d);
        }
    }
    public void removeStudent(String name, String sname){
        Student s = getStudent(name, sname);
        if(s != null)
            s.getFaculty().removeStudent(s);
    }
    public void removeProfessor(String name, String sname){
        Professor p = getProfessor(name, sname);
        if (p != null)
            p.getDepartment().removeProfessor(p);
    }
    public Faculty getFaculty(String name){
        return findFaculty(name);
    }
    public Department getDepartment(String name){
        for(Faculty f: faculties) {
            Department d = f.findDepartment(name);
            if (d != null) {
                return d;
            }
        }
        return null;
    }

    public Student getStudent(String name, String sname){
        for(Faculty f: faculties) {
            Student s = f.findStudent(name, sname);
            if (s != null) {
                return s;
            }
        }
        return null;
    }
    //todo
    public Student getStudent(int group, boolean courseInstead){
        for(Faculty f: faculties) {
            Student s = (courseInstead)? null:null;
            if (s != null) {
                return s;
            }
        }
        return null;
    }
    public Professor getProfessor(String name, String sname){
        for(Faculty f: faculties) {
            for(Department d: f.getDepartments()){
                Professor p = d.findProfessor(name, sname);
                if(p != null) {
                    return p;
                }
            }
        }
        return null;
    }

    public Faculty findFaculty(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(name)) {
                return faculty;
            }
        }
        return null;
    }
}
