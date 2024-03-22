import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String questionText, ArrayList<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizApp {
    private ArrayList<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            ArrayList<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz finished! Your score: " + score + " out of " + questions.size());
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();

        // Add questions to the quiz
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("A. Java");
        options1.add("B. Python");
        options1.add("C. C++");
        options1.add("D. JavaScript");
        Question question1 = new Question("What programming language is this quiz written in?", options1, 1);
        quizApp.addQuestion(question1);

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("A. 4");
        options2.add("B. 6");
        options2.add("C. 8");
        options2.add("D. 10");
        Question question2 = new Question("How many legs does a spider have?", options2, 3);
        quizApp.addQuestion(question2);

        // Start the quiz
        quizApp.startQuiz();
    }
}