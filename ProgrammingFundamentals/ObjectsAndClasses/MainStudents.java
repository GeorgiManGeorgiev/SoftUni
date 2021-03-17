package B_FM.ObjectsAndClasses;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class MainStudents {

    static class Student {

        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }


    static Student findStudent(String firstName, String lastName, List<Student> students) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String input = scanner.next();

        while (!input.equals("end")) {

            String firstName = input;
            String lastName = scanner.next();
            int age = scanner.nextInt();
            String homeTown = scanner.next();

            Student student = new Student(firstName, lastName, age, homeTown);


            Student existingStudent = findStudent(firstName, lastName, students);
            if (existingStudent != null) {
                existingStudent.setAge(age);
                existingStudent.setHomeTown(homeTown);
            }else {

                students.add(student);
            }

            input = scanner.next();
        }

        String cityName = scanner.next();

        for (Student student : students) {
            if (student.getHomeTown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge());
            }
        }
    }
}
