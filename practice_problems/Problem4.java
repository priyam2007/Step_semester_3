import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4 {

    // Base class representing an examination question
    public abstract static class Question {
        private final String questionType;
        private final String questionText;
        private final String correctAnswer;
        private final String studentAnswer;
        private final int points;

        public Question(String questionType, String questionText, String correctAnswer, String studentAnswer, int points) {
            this.questionType = questionType;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String getQuestionType() {
            return questionType;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public String getStudentAnswer() {
            return studentAnswer;
        }

        public int getPoints() {
            return points;
        }

        // Abstract method overridden by subclasses for specific grading logic
        public abstract double evaluateScore();
    }

    // Multiple Choice Question (MCQ)
    public static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("MCQ", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            if (getStudentAnswer().equalsIgnoreCase(getCorrectAnswer())) {
                return getPoints();
            }
            return 0.0;
        }
    }

    // True/False Question (TF)
    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("TF", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            if (getStudentAnswer().equalsIgnoreCase(getCorrectAnswer())) {
                return getPoints();
            }
            return 0.0;
        }
    }

    // Essay Question (ESSAY)
    public static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            String[] keywords = getCorrectAnswer().split(",");
            int matchCount = 0;
            String studentLower = getStudentAnswer().toLowerCase();

            for (String keyword : keywords) {
                String trimmedKw = keyword.trim().toLowerCase();
                if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                    matchCount++;
                }
            }

            if (matchCount >= 2) {
                return getPoints() * 0.75;
            } else if (matchCount == 1) {
                return getPoints() * 0.50;
            } else {
                return 0.0;
            }
        }
    }

    // Factory method for creating Question instances
    public static Question createQuestion(String type, String text, String correct, String student, int points) {
        switch (type.trim().toUpperCase()) {
            case "MCQ":
                return new MultipleChoiceQuestion(text, correct, student, points);
            case "TF":
                return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY":
                return new EssayQuestion(text, correct, student, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            return;
        }
        String firstLine = sc.nextLine().trim();
        while (firstLine.isEmpty() && sc.hasNextLine()) {
            firstLine = sc.nextLine().trim();
        }
        if (firstLine.isEmpty()) {
            return;
        }
        int n = Integer.parseInt(firstLine);

        Pattern quotePattern = Pattern.compile("\"([^\"]*)\"");
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n && sc.hasNextLine(); i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            int firstQuote = line.indexOf('"');
            int lastQuote = line.lastIndexOf('"');
            String type = line.substring(0, firstQuote).trim();
            String pointsStr = line.substring(lastQuote + 1).trim();
            int points = Integer.parseInt(pointsStr);

            Matcher m = quotePattern.matcher(line);
            List<String> quotedParts = new ArrayList<>();
            while (m.find()) {
                quotedParts.add(m.group(1));
            }

            String questionText = quotedParts.get(0);
            String correctAnswer = quotedParts.get(1);
            String studentAnswer = quotedParts.get(2);

            questions.add(createQuestion(type, questionText, correctAnswer, studentAnswer, points));
        }

        double totalScore = 0.0;
        // Polymorphic processing: calling evaluateScore() uniformly
        for (Question q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf(Locale.US, "%s: %.2f%n", q.getQuestionType(), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", totalScore);

        sc.close();
    }
}
