import java.util.Arrays;
public class NaUKMA {
    public class University {
        private Faculty[] faculties;
        // List of departments in the university
        private Department[] departments;
        public University() {
            this.faculties = new Faculty[0];
            this.departments = new Department[0];
        }

        // Methods for managing faculties
        public void addFaculty(Faculty faculty) {
            faculties = Arrays.copyOf(faculties,faculties.length+1);
            faculties[faculties.length-1]=faculty;
        }
        public void addDepartment(Department department) {
            departments = Arrays.copyOf(departments,departments.length+1);
            departments[departments.length-1]=department;
        }

        public void removeFaculty(Faculty faculty) {
            //todo
        }
        public void removeDepartment(Department department) {
            //todo
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
}
