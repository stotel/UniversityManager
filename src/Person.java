public class Person {

    Department department;
    Faculty faculty;
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Faculty getFaculty() { return faculty; }
    public Department getDepartment() { return department; }

    public static void findPersonByCourseAndDepartment(int course, String department) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Person stf : Faculty.staff) {
                if (stf instanceof Student && ((Student) (stf)).getCourse() == course && stf.getDepartment().equals(department)) {
                    System.out.println(stf);
                }
            }
        }
    }

    public static void findPersonByGroup(int group) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Person stf : Faculty.staff) {
                if (stf instanceof Student && ((Student) (stf)).getCourse() == group) {
                    System.out.println(stf);
                }
            }
        }
    }

    public static void findPersonByCourse(int course) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Person stf : Faculty.staff) {
                if (stf instanceof Student && ((Student) (stf)).getCourse() == course) {
                    System.out.println(stf);
                }
            }
        }
    }

    public static void findPersonByName(String name, String surname) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Person std : Faculty.staff) {
                if (std.getName() == "name" && std.getSurname() == "surname") {
                    System.out.println(std);
                }
            }
        }
    }

}

