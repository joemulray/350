
import java.util.*;

/**
 * 
 */
public class Test extends Survey {

    /**
     * Default constructor
     */
    public Test() {
    }

    /**
     * 
     */
    public String name;
    public ArrayList<Question> Questions = new ArrayList<Question>();
    Answers answer= new Answers();
    Answers answerSheet = new Answers();
    public String type = "Test";


    /**
     * 
     */
    public void Test() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @param int 
     * @return
     */
    public void getQuestion(int number) {
        // TODO implement here
    }

    /**
     * @param int 
     * @return
     */
    public void editQuestion(int number) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addQuestion() {
        // TODO implement here
        
    Scanner keyboard = new Scanner(System.in);
    int choice;

	System.out.println("1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new multiple choice question");

	choice = keyboard.nextInt();

    switch(choice){
        case 1:
            TF TFQ = new TF();
            TFQ.create();
            TFQ.setType(this.type);
            this.Questions.add(TFQ);

            break;
        case 2:
            MultipleChoice MCQ = new MultipleChoice();
            MCQ.create();
            MCQ.setType(this.type);
            this.Questions.add(MCQ);
            break;
        case 3:
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.create();
            SAQ.setType(this.type);
            this.Questions.add(SAQ);
            break;
        case 4:
            Essay EQ = new Essay();
            EQ.create();
            EQ.setType(this.type);
            this.Questions.add(EQ);
            break;
        case 5:
            Ranking RQ = new Ranking();
            RQ.create();
            this.Questions.add(RQ);
            break;
        case 6:
            Matching MQ = new Matching();
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
     * @param String 
     * @return
     */
    public void Test(String name) {
        // TODO implement here
    }

    /**
     * @param String 
     * @return
     */
    public void record(String answer) {
        // TODO implement here
    }

}
