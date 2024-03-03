import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class NaUKMA {

    private Faculty[] faculties = new Faculty[0];
    private Department[] departments;

    {
        addFaculty(new Faculty("ФІ"));
        Department depInit = new Department("Кафедра інформатики");
        Professor prfInit = new Professor("Кирієнко", "Оксана");
        Student stdInit1 = new Student(1, 5, "Гущін", "Іван");
        Student stdInit2 = new Student(1, 5, "Стецик", "Максим");
        Student stdInit3 = new Student(1, 5, "Рублевський", "Орест");

        faculties[0].addDepartment(depInit);
        faculties[0].addProfessor(prfInit);
        faculties[0].addStudent(stdInit1);
        faculties[0].addStudent(stdInit2);
        faculties[0].addStudent(stdInit3);

        depInit.addProfessor(prfInit);
        depInit.addStudent(stdInit1);
        depInit.addStudent(stdInit2);
        depInit.addStudent(stdInit3);
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public Department[] getDepartments() {
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
        faculties = Arrays.copyOf(faculties, faculties.length + 1);
        faculties[faculties.length - 1] = faculty;
    }

    public void addDepartment(Department department, String facName) {
        Faculty faculty = findFaculty(facName);
        if (faculty != null)
            faculty.addDepartment(department);
        else
            System.out.println("Факультету не знайдено - кафедру не додано...");
    }

    public void addStudent(Student student, String facName) {
        findFaculty(facName).addStudent(student);
    }

    public void addProfessor(Professor professor, String depName) {
        for (Faculty f : faculties) {
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
        else {
            System.out.println("Такого факультету не існує");
        }
    }

    public void removeDepartment(String name) {
        Department d = getDepartment(name);
        if (d != null) {
            d.getFaculty().removeDepartment(d);
        }
    }

    public void removeStudent(String name, String sname) {
        Student s = getStudent(name, sname);
        if (s != null)
            s.getFaculty().removeStudent(s);
    }

    public void removeProfessor(String name, String sname) {
        Professor p = getProfessor(name, sname);
        if (p != null)
            p.getDepartment().removeProfessor(p);
    }

    public void changeFaculty(Faculty faculty, String newName) {
        if (findFaculty(faculty.getName()) == null) {
            faculty.setName(newName);
        } else {
            System.out.println("Факультет з такою назвою вже існує");
        }
    }

    public void facultyActions() throws IOException {
        int choice = DataInput.getInt("Оберіть дію з факультетом: \n1. Створити \n2. Видалити \n3. Редагувати \n");
        switch (choice) {
            case 1:
                addFaculty(new Faculty(DataInput.getString("Введіть назву нового факультету: ")));
                break;
            case 2:
                removeFaculty(DataInput.getString("Введіть назву факультету для видалення: "));
                break;
            case 3:
                String oldName = DataInput.getString("Введіть стару назву факультету: ");
                String newName = DataInput.getString("Введіть нову назву факультету: ");
                Faculty faculty = findFaculty(oldName);
                if (faculty != null) {
                    changeFaculty(faculty, newName);
                }
        }
    }

    public Faculty getFaculty(String name) {
        return findFaculty(name);
    }

    public Department getDepartment(String name) {
        for (Faculty f : faculties) {
            Department d = f.findDepartment(name);
            if (d != null) {
                return d;
            }
        }
        return null;
    }

    public Student getStudent(String name, String sname) {
        for (Faculty f : faculties) {
            Student s = f.findStudent(name, sname);
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    //todo
    public Student getStudent(int group, boolean courseInstead) {
        for (Faculty f : faculties) {
            Student s = (courseInstead) ? null : null;
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    public Professor getProfessor(String name, String sname) {
        for (Faculty f : faculties) {
            for (Department d : f.getDepartments()) {
                Professor p = d.findProfessor(name, sname);
                if (p != null) {
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
