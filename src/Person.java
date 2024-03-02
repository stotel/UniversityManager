public class Person {
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

    public static void findPersonByGroup(int group) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Student std : Faculty.students) {
                if (std.getGroup() == group) {
                    System.out.println(std);
                }
            }
        }
    }

    public static void findPersonByCourse(int course) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Student std : Faculty.students) {
                if (std.getCourse() == course) {
                    System.out.println(std);
                }
            }
        }
    }

    public static void findPersonByName(String name, String surname) {
        for (Faculty fac : NaUKMA.University.faculties) {
            for (Student std : Faculty.students) {
                if (std.getName() == "name" && std.getSurname() == "surname") {
                    System.out.println(std);
                }
            }
        }
    }

}

