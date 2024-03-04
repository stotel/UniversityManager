import Utils.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Department {
    private Faculty faculty;
    private String name;
    private Professor[] professors = new Professor[0];
    private Student[] students = new Student[0];

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFaculty(Faculty f) {
        faculty = f;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor[] getProfessors() {
        return professors;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addProfessor(Professor professor) {
        professors = Arrays.copyOf(professors, professors.length + 1);
        professors[professors.length - 1] = professor;
        professor.setDepartment(this);
        //faculty.addProfessor(professor);
    }

    public void addStudent(Student student) {
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
        student.setDepartment(this);
        //faculty.addStudent(student);
    }

    public void removeProfessor(String name, String sname) {
        removeProfessor(findProfessor(name, sname));
    }

    public void removeProfessor(Professor p) {
        if (p != null) {
            Utils.remove(p, professors);
            p.setDepartment(null);
        } else {
            System.out.println("Такого викладача не існує");
        }
    }

    public void removeStudent(String name, String sname) {
        removeStudent(findStudent(name, sname));
    }

    public void removeStudent(Student s) {
        if (s != null) {
            Utils.remove(s, students);
            s.setDepartment(null);
        } else {
            System.out.println("Такого студента не існує");
        }
    }

    public void changeProfessor(String name, String sname) throws IOException {
        changeProfessor(findProfessor(name, sname));
    }

    public void changeProfessor(Professor prf) throws IOException {
        if (prf != null) {
            choiceOfChanges(prf);
        } else {
            System.out.println("Такого викладача не існує");
        }
    }

    public void changeStudent(String name, String sname) throws IOException {
        changeStudent(findStudent(name, sname));
    }

    public void changeStudent(Student std) throws IOException {
        if (std != null) {
            choiceOfChanges(std);
        } else {
            System.out.println("Такого студента не існує");
        }
    }

    private void choiceOfChanges(Person per) throws IOException {
        int choice = DataInput.getInt("Оберіть, що ви хочете змінити: \n1.Ім'я: \n2.Прізвище: \n3.Кафедру: \n");

        switch (choice) {
            case 1:
                per.setName(DataInput.getString("Введіть нове ім'я: "));
                break;
            case 2:
                per.setSurname(DataInput.getString("Введіть нове прізвище: "));
                break;
            case 3:
                Department newDep = getFaculty().findDepartment(DataInput.getString("Вкажіть, на яку кафедру перевести: "));
                if (newDep != null) {
                    if (per instanceof Student) {
                        removeStudent((Student) per);
                        newDep.addStudent((Student) per);
                    } else {
                        removeProfessor((Professor) per);
                        newDep.addProfessor((Professor) per);
                    }
                } else {
                    System.out.println("Такої кафедри не існує");
                }
                break;
            default:
                choiceOfChanges(per);
        }
    }

    public void staffActions() throws IOException {
        int action;
        int choice = DataInput.getInt("Оберіть, із ким працювати: \n1. Викладач \n2. Студент\n");
        switch (choice) {
            case 1:
                action = DataInput.getInt("Оберіть дію з людиною на кафедрі: \n1. Додати \n2. Видалити \n3. Редагувати \n");
                switch (action) {
                    case 1:
                        Professor newProf = new Professor(DataInput.getString("Введіть прізвище"), DataInput.getString("Введіть ім'я"));
                        addProfessor(newProf);
                        break;
                    case 2:
                        removeProfessor(DataInput.getString("Введіть ім'я викладача: "), DataInput.getString("Введіть прізвище викладача: "));
                        break;
                    case 3:
                        changeProfessor(DataInput.getString("Введіть ім'я викладача: "), DataInput.getString("Введіть прізвище викладача: "));
                        break;
                }
                break;
            case 2:
                action = DataInput.getInt("Оберіть дію з людиною на кафедрі: \n1. Додати \n2. Видалити \n3. Редагувати \n");
                switch (action) {
                    case 1:
                        Student newStud = new Student(DataInput.getInt("Введіть курс студента: "), DataInput.getInt("Введіть групу студента: "), DataInput.getString("Введіть прізвище студента"), DataInput.getString("Введіть ім'я студента"));
                        addStudent(newStud);
                        break;
                    case 2:
                        removeStudent(DataInput.getString("Введіть ім'я студента: "), DataInput.getString("Введіть прізвище студента: "));
                        break;
                    case 3:
                        changeStudent(DataInput.getString("Введіть ім'я студента: "), DataInput.getString("Введіть прізвище студента: "));
                        break;
                }
                break;
            default:
                staffActions();
        }

    }

    public Professor findProfessor(String name, String sname) {
        for (Professor p : professors) {
            if (p.getName().equals(name) && p.getSurname().equals(sname)) {
                return p;
            }
        }
        return null;
    }

    public Student findStudent(String name, String sname) {
        for (Student s : students) {
            if (s.getName().equals(name) && s.getSurname().equals(sname)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Arrays.equals(professors, that.professors);
    }

    //equals helper
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(professors);
        return result;
    }
}
