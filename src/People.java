public class People {

    protected int course;
    protected enum FacultyEnum {
        ФІ("ФІ"), ФЕН("ФЕН"), ФПВН("ФПВН"), ФПРН("ФПРН"), ФГН("ФГН"), ФОЗ("ФОЗ"), ФСНСТ("ФСНСТ");

        private final String fac;

        FacultyEnum(String fac) {
            this.fac = fac;
        }

        public String getFac() {
            return fac;
        }
    }
    protected String faculty;
    protected enum DepartmentEnum {
        ФІ("інформатики"), ФЕН("фінансів"), ФПВН("приватного права"), ФПРН("екології"), ФГН("історії"),
        ФОЗ("психології та педагогіки"), ФСНСТ("політології");

        private final String dep;

        DepartmentEnum(String dep) {
            this.dep = dep;
        }

        public String getDep() {
            return dep;
        }
    }
    protected String department;
    protected int group;
    protected String surname;
    protected String name;
    protected String patronymic;


    /** Student constructor
     * @param course
     * @param faculty
     * @param department
     * @param group
     * @param surname
     * @param name
     * @param patronymic
     */
    protected People(int course, String faculty, String department, int group, String surname, String name, String patronymic) {
        this.course = course;
        this.faculty = (FacultyEnum.valueOf(faculty)).getFac();
        this.department = (DepartmentEnum.valueOf(department)).getDep();
        this.group = group;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    /** Professor constructor
     * @param faculty
     * @param department
     * @param surname
     * @param name
     * @param patronymic
     */
    protected People(String faculty, String department, String surname, String name, String patronymic) {
        this.faculty = (FacultyEnum.valueOf(faculty)).getFac();
        this.department = (DepartmentEnum.valueOf(department)).getDep();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
}
