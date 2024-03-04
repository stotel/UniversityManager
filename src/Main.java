import Utils.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        NaUKMA uni = new NaUKMA();
        Student[] allStudents;
        while (true) {
            System.out.println("Оберіть дію:");
            System.out.println("1. Створити/видалити/редагувати факультет");
            System.out.println("2. Створити/видалити/редагувати кафедру факультета");
            System.out.println("3. Додати/видалити/редагувати студента/викладача до кафедри");
            System.out.println("4. Знайти студента/викладача за ПІБ, курсом або групою");
            System.out.println("5. Вивести всіх студентів впорядкованих за курсами");
            System.out.println("6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом");
            System.out.println("7. Вивести всіх студентів кафедри впорядкованих за курсами");
            System.out.println("8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом");
            System.out.println("9. Вивести всіх студентів кафедри вказаного курсу");
            System.out.println("10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("0. Вихід");
            switch (DataInput.getInt("your option:")) {
                case 1:
                    NaUKMA.facultyActions();
                    break;
                case 2:
                    Faculty faculty = NaUKMA.findFaculty(DataInput.getString("Введіть назву факультета, в середині якого працюватемо: "));
                    if (faculty != null) {
                        faculty.departmentActions();
                    }
                    break;
                case 3:
                    Department department = NaUKMA.findDepartment(DataInput.getString("Введіть назву кафедри, в середині якої працюватемо: "));
                    if (department != null) {
                        department.staffActions();
                    }
                    break;
                case 4:
                    // Знайти студента/викладача за ПІБ, курсом або групою
                    break;
                case 5:
                    // Вивести всіх студентів впорядкованих за курсами
                    allStudents = findAllStudents();
                    sortStudentsByCourse(allStudents);
                    for(Student s:allStudents){
                        System.out.println(s);
                    }
                    break;
                case 6:
                    // Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом
                    System.out.println("Студенти:");
                    allStudents = findAllStudents();
                    sortStudentsByName(allStudents);
                    for(Student s:allStudents){
                        System.out.println(s);
                    }
                    break;
                case 7:
                    // Вивести всіх студентів кафедри впорядкованих за курсами
                    break;
                case 8:
                    // Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом
                    break;
                case 9:
                    // Вивести всіх студентів кафедри вказаного курсу
                    break;
                case 10:
                    // Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом
                    break;
                case 0:
                    System.out.println("До побачення!");
                    return;
                default:
                    System.out.println("incorrect variant!");
                    break;
            }
        }
    }
    public static Student[] findAllStudents(){
        Student[] s = new Student[0];
        for(Faculty f: NaUKMA.getFaculties()){
            for(Department d:f.getDepartments()){
                Utils.append(s,d.getStudents());
            }
        }
        return s;
    }
    public static void sortStudentsByCourse(Student[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getCourse() > key.getCourse()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void sortStudentsByName(Student[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].getName()+arr[j].getSurname()).compareTo(key.getName()+key.getSurname()) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}