public class Professor extends People {

    public Professor(String faculty, String department, String surname, String name, String patronymic) {
        super(faculty, department, surname, name, patronymic);
    }


    public String getFaculty() {
        return faculty;
    }
    public String getDepartment() {
        return department;
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
        return "Викладач " + surname + " " + name + " " + patronymic + " - факультет " + faculty + " ; кафедра " + department;
    }
}
