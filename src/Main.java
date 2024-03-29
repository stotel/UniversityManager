import Utils.*;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        NaUKMA uni = new NaUKMA();
        Student[] allStudents;
        Faculty f;
        Department d;
        while (true) {
            System.out.println("Оберіть дію:");
            System.out.println("1. Створити/видалити/редагувати факультет");
            System.out.println("2. Створити/видалити/редагувати кафедру факультета");
            System.out.println("3. Додати/видалити/редагувати студента/викладача до кафедри");
            System.out.println("4. Знайти студента/викладача за ПІБ, курсом або групою");
            System.out.println("5. Вивести всіх студентів впорядкованих за курсами");
            System.out.println("6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом");
            System.out.println("7. вивести всіх студентів кафедри впорядкованих за курсами");
            System.out.println("8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом");
            System.out.println("9. Вивести всіх студентів кафедри вказаного курсу");
            System.out.println("10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("0. Вихід");
            switch (DataInput.getInt("your option:")) {
                case 1:
                    uni.facultyActions();
                    break;
                case 2:
                    Faculty faculty = uni.findFaculty(DataInput.getString("Введіть назву факультета, з яким працюватемо: "));
                    if (faculty != null) {
                        faculty.departmentActions();
                    }
                    break;
                case 3:
                    Department department = uni.findDepartment(DataInput.getString("Введіть назву кафедри, з якою працюватемо: "));
                    if (department != null) {
                        department.staffActions();
                    }
                    break;
                case 4:
                    uni.findPerson();
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
                    Faculty fac = NaUKMA.findFaculty(DataInput.getString("факультет"));
                    System.out.println("Студенти:");
                    allStudents = findAllStudents();
                    sortPersonsByName(allStudents);
                    for(Student s:allStudents){
                        if(s.getFaculty()==fac){
                            System.out.println(s);//faculty
                        }
                    }
                    System.out.println("Викладчі:");
                    Professor[] professors = findAllProfessors();
                    sortPersonsByName(professors);
                    for(Professor s:professors){
                        if(s.getFaculty()==fac){
                            System.out.println(s);//faculty
                        }
                    }
                    break;
                case 7:
                    // Вивести всіх студентів кафедри впорядкованих за курсами
                    d = NaUKMA.findDepartment(DataInput.getString("кафедра"));
                        if(d!=null){
                            Student[] s = d.getStudents();//no faculty
                            sortStudentsByCourse(s);
                            for(Student i:s){
                                System.out.println(i);
                            }
                        }else{
                            System.out.println("кафедра не існує");
                        }
                    break;
                case 8:
                        d = NaUKMA.findDepartment(DataInput.getString("кафедра"));
                        if (d != null) {
                            System.out.println("Студенти:");
                            Person[] p = d.getStudents();//no faculty
                            sortPersonsByName(p);
                            for(Person i:p){
                                System.out.println(i);
                            }
                            System.out.println("Професори:");
                            Professor[] s = d.getProfessors();
                            sortPersonsByName(s);
                            for(Professor i:s){
                                System.out.println(i);
                            }
                        }else{
                            System.out.println("кафедра не існує");
                        }
                    // Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом
                    break;
                case 9:
                    // Вивести всіх студентів кафедри вказаного курсу
                    int course = DataInput.getInt("курс");
                        d = NaUKMA.findDepartment(DataInput.getString("кафедра"));
                        if (d != null) {
                            Student[] ss = d.getStudents();
                            for(Student i:ss){//no faculty
                                if(i.getCourse()==course){
                                    System.out.println(i);
                                }
                            }
                        }else{
                            System.out.println("кафедра не існує");
                        }
                    break;
                case 10:
                    // Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом
                    int course1 = DataInput.getInt("курс");
                    d = NaUKMA.findDepartment(DataInput.getString("кафедра"));
                        if (d != null) {
                            Student[] sss = d.getStudents();
                            sortPersonsByName(sss);//no faculty
                            for(Student i:sss){
                                if(i.getCourse()==course1){
                                    System.out.println(i);
                                }
                            }
                        }else{
                            System.out.println("кафедра не існує");
                        }
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
        for(Faculty f: NaUKMA.getInstance().getFaculties()){
            for(Department d:f.getDepartments()){
                for (Student i:d.getStudents()){
                    if(i != null) {
                        s = Arrays.copyOf(s, s.length + 1);
                        s[s.length - 1] = i;
                    }
                }
            }
        }
        return s;
    }
    public static Professor[] findAllProfessors(){
        Professor[] s = new Professor[0];
        for(Faculty f: NaUKMA.getInstance().getFaculties()){
            for(Department d:f.getDepartments()){
                for (Professor i:d.getProfessors()){
                    if(i!=null) {
                        s = Arrays.copyOf(s, s.length + 1);
                        s[s.length - 1] = i;
                    }
                }
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
    public static void sortPersonsByName(Person[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Person key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].getSurname()+arr[j].getName()).compareTo(key.getSurname()+key.getName()) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}