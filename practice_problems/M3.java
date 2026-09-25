public class M3 {
    public static class Course {
        private String code;
        private String title;
        private int credits;
        private int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    public static void main(String[] args) {
        Course c1 = new Course("21CSC201J", "Data Structures", 4);
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(c1.getCode() + " total credits: " + c1.totalCredits());
        System.out.println(c2.getCode() + " total credits: " + c2.totalCredits());
    }
}
