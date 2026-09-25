public class M5 {
    public static class Student {
        private String name;
        private double attendance;
        private static String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount = 0;

        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Rahul", 85.0);
        new Student("Sneha", 92.0);
        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}
