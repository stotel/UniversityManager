import java.util.Arrays;
public class NaUKMA {
    public static class University {
        // List of faculties in the university
        public static Faculty[] faculties = new Faculty[0];

        // Methods for managing faculties
        public static void addFaculty(Faculty faculty) {
            faculties = Arrays.copyOf(faculties,faculties.length+1);
            faculties[faculties.length-1]=faculty;
        }

        public static void removeFaculty(Faculty faculty) {
            //todo
        }

        public static void changeFaculty(Faculty faculty) {
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
