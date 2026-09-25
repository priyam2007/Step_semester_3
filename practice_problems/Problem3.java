public class Problem3 {
    public static class NameTag {
        private final String firstName;
        private final String lastName;

        public NameTag(String fullName) {
            String[] parts = fullName.trim().split("\\s+");
            this.firstName = parts[0];
            this.lastName = parts.length > 1 ? parts[1] : "";
        }

        public String getNickname() {
            if (lastName.isEmpty()) {
                return firstName;
            }
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());
    }
}
