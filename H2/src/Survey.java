
import java.util.*;

/**
 * 
 */
public class Survey extends Question {

    /**
     * Default constructor
     */
    public Survey() {
    }

    public String name;
    public ArrayList<Question> Questions = new ArrayList<Question>();
    Answers answer= new Answers();
    public String type = "Survey";






    /**
     * 
     */
    public void Survey() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addQuestion() {


    Scanner keyboard = new Scanner(System.in);
    int choice;

    System.out.println("1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new matching question");

    choice = keyboard.nextInt();

    switch(choice){
        case 1:
            TF TFQ = new TF();
            TFQ.setType(this.type);
            TFQ.create();
            this.Questions.add(TFQ);
            break;
        case 2:
            MultipleChoice MCQ = new MultipleChoice();
            MCQ.setType(this.type);
            MCQ.create();
            this.Questions.add(MCQ);
            break;
        case 3:
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.setType(this.type);
            SAQ.create();
            this.Questions.add(SAQ);
            break;
        case 4:
            Essay EQ = new Essay();
            EQ.setType(this.type);
            EQ.create();
            this.Questions.add(EQ);
            break;
        case 5:
            Ranking RQ = new Ranking();
            RQ.setType(this.type);
            RQ.create();
            this.Questions.add(RQ);
            break;
        case 6:
            Matching MQ = new Matching();
            MQ.setType(this.type);
            MQ.create();
            this.Questions.add(MQ);
            break;
        default:
            System.out.println("Select a valid Question.");
            addQuestion();
            break;
        }

    }

    /**
     * @return
     */
    public void takeSurvey() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @param String 
     * @return
     */
    public void Survey(String nsmr) {
        // TODO implement here
    }

    /**
     * @param int 
     * @return
     */
    public void editQuestion(int number) {
        // TODO implement here
    }


    public void create(){

        int numQuestions;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("********");
        System.out.println("Survey");
        System.out.println("********");

        System.out.println("How many Questions would you like to have in for your Survey?:");
        numQuestions = keyboard.nextInt();

        for (int index = 0; index < numQuestions; index++){

            addQuestion();
        }

        System.out.println("Survey Created.");
    }


}
