public class Student extends People {

    public Student(int course, String faculty, String department, int group, String surname, String name, String patronymic) {
        super(course, faculty, department, group, surname, name, patronymic);
    }


    public int getCourse() {
        return course;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getGroup() {
        return group;
    }
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "Студент " + surname + " " + name + " " + patronymic + " - курс: " + course + " ; факультет " + faculty + " ; кафедра " + department + " ; група: " + group;
    }
}