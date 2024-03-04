import Utils.*;

import java.io.IOException;
import java.util.Arrays;

public class NaUKMA {
    private static NaUKMA instance;
    public static NaUKMA getInstance(){
        return instance;
    }

    private Faculty[] faculties = new Faculty[0];

    public NaUKMA(){
        instance = this;
    }
    {
        addFaculty(new Faculty("ФІ"));
        Department depInit1 = new Department("Кафедра інформатики");
        Department depInit2 = new Department("Кафедра пустоти");
        Professor prfInit = new Professor("Кирієнко", "Оксана");
        Student stdInit1 = new Student(4, 5, "Гущін", "Іван");
        Student stdInit2 = new Student(2, 5, "Стецик", "Максим");
        Student stdInit3 = new Student(1, 5, "Рублевський", "Орест");
        Student stdInit4 = new Student(3, 5, "Гущ", "Наві");
        Student stdInit5 = new Student(2, 5, "Кроп", "Марк");
        Student stdInit6 = new Student(4, 5, "Паруга", "Віка");

        faculties[0].addDepartment(depInit1);
        faculties[0].addDepartment(depInit2);
        faculties[0].addProfessor(prfInit,"Кафедра інформатики");
        faculties[0].addStudent(stdInit1,"Кафедра інформатики");
        faculties[0].addStudent(stdInit2,"Кафедра інформатики");
        faculties[0].addStudent(stdInit3,"Кафедра інформатики");
        faculties[0].addStudent(stdInit4,"Кафедра пустоти");
        faculties[0].addStudent(stdInit5,"Кафедра пустоти");
        faculties[0].addStudent(stdInit6,"Кафедра пустоти");
    }

    public Faculty[] getFaculties() {
        return faculties;
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

    public void addStudent(Student student, String facName,String depName) {
        Faculty f = findFaculty(facName);
        if (f != null) {
            f.addStudent(student,depName);
        } else {
            System.out.println("Такого факультету не існує");
        }
    }

    public void addProfessor(Professor professor, String facName,String depName) {
        Faculty f = findFaculty(facName);
        if (f != null) {
            f.addProfessor(professor,depName);
        } else {
            System.out.println("Такого факультету не існує");
        }
    }

    public void removeFaculty(String name) {
        Faculty f = getFaculty(name);
        if (f != null) {
            Utils.remove(f, faculties);
        } else {
            System.out.println("Такого факультету не існує");
        }
    }

    public void removeDepartment(String name) {
        Department d = findDepartment(name);
        if (d != null) {
            d.getFaculty().removeDepartment(d);
        }
    }

    public void removeStudent(String name, String sname) {
        Student s = getStudent(name, sname);
        if (s != null) {
            s.getFaculty().removeStudent(s,s.getDepartment().getName());
        }
    }

    public void removeProfessor(String name, String sname) {
        Professor p = getProfessor(name, sname);
        if (p != null) {
            p.getFaculty().removeProfessor(p,p.getDepartment().getName());
        }
    }

    public void changeFaculty(Faculty faculty, String newName) {
        if (faculty != null && findFaculty(newName) == null) {
            faculty.setName(newName);
        } else if (faculty == null) {
            System.out.println("Такого факультету не існує");
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
                changeFaculty(findFaculty(oldName), newName);
                break;
            default:
                facultyActions();
        }
    }

    public void printPersonWithName(String name, String sname) {
        Person found = getStudent(name, sname);
        if (found == null) {
            found = getProfessor(name, sname);
        }

        System.out.println(found);
    }

    public Person[] printPeopleWithCourse(int course) {
        Person[] found = new Person[20];
        int counter = 0;

        for (Faculty f: faculties) {
            for (Department d: f.getDepartments()) {
                for (Student s: d.getStudents()) {
                    if (s.getCourse() == course) {
                        System.out.println(s);
                        found[counter++] = s;
                    }
                }
            }
        }

        return found;
    }

    public void printPeopleWithGroup(int group) {
        for (Faculty f: faculties) {
            for (Department d: f.getDepartments()) {
                for (Student s: d.getStudents()) {
                    if (s.getGroup() == group) {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    public void findPerson() throws IOException {
        int choice = DataInput.getInt("Як шукати людину? \n1.Ім'я та прізвище \n2.Курс \n3.Група \n");

        switch (choice) {
            case 1:
                printPersonWithName(DataInput.getString("Введіть ім'я: "), DataInput.getString("Введіть прізвище"));
                break;
            case 2:
                printPeopleWithCourse(DataInput.getInt("Введіть курс: "));
                break;
            case 3:
                printPeopleWithGroup(DataInput.getInt("Введіть групу: "));
                break;
            default:
                findPerson();
        }
    }

    public Faculty getFaculty(String name) {
        return findFaculty(name);
    }

    public Department findDepartment(String name) {
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
