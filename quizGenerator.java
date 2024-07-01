import java.util.*;
import java.util.List;

class Option {
    private String text;
    private boolean isCorrect;

    public Option(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}

class Question {
    private String text;
    private List<Option> options;

    public Question(String text, List<Option> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public List<Option> getOptions() {
        return options;
    }
}
class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
    public void createQuestions() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of questions you want to create: ");
        int numQuestions = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < numQuestions; i++) {
            System.out.print("Enter the question text: ");
            String questionText = sc.nextLine();

            List<Option> options = new ArrayList<>();
            System.out.print("Enter the number of options for this question: ");
            int numOptions = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int j = 0; j < numOptions; j++) {
                System.out.print("Enter option " + (j + 1));
                String optionText = sc.nextLine();

                System.out.print("Is this option correct? (true/false): ");
                boolean isCorrect = sc.nextBoolean();
                sc.nextLine(); // consume newline

                options.add(new Option(optionText, isCorrect));
            }

            questions.add(new Question(questionText, options));
        }
    }
    public void start() {
        Scanner sc = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getText());

            List<Option> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getText());
            }

            System.out.print("Your answer: ");
            int answer = sc.nextInt();

            if (options.get(answer - 1).isCorrect()) {
                score++;
            }
        }

        System.out.println("You scored " + score + " out of " + questions.size());
        sc.close();
    }
}
public class quizGenerator {
		public static void main(String[] args) {
	
	        Quiz quiz = new Quiz();
	        
	        quiz.createQuestions();
	        quiz.start();
	    }
	}

