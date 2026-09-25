public class Problem4 {
    public static class TrafficLight {
        private final String id;
        private String color;

        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED";
        }

        public String getColor() {
            return color;
        }

        public String getId() {
            return id;
        }

        public String next() {
            switch (color) {
                case "RED":
                    color = "GREEN";
                    break;
                case "GREEN":
                    color = "YELLOW";
                    break;
                case "YELLOW":
                    color = "RED";
                    break;
                default:
                    color = "RED";
                    break;
            }
            return color;
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
    }
}
