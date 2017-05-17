
import java.util.*;
import java.io.Serializable;

/**
 * 
 */
public class Test extends Survey  implements Serializable{

    private static final double serialVersionUID = -1L;
    /**
     * Default constructor
     */
    public Test() {}

    //AnswerSheet variable
    public Answers answerSheet = new Answers();


    /**
     * 
     */

    /**
     * Function to create a Test Question
     * overrides a survey create
     */
    @Override
    public void addQuestion() {


    Scanner keyboard = new Scanner(System.in);
    String choice;

    System.out.println("\n1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new matching question");
    System.out.println("7) Quit");

    choice = keyboard.nextLine();

    switch(choice){
        case "1":
            TF TFQ = new TF(); 
            TFQ.setType(this.type); //create new true false question
            TFQ.create();
            TFQ.createAnswer(); //gets correct answer
            this.Questions.add(TFQ); 
            break;
        case "2":
            MultipleChoice MCQ = new MultipleChoice(); //create new MC question
            MCQ.setType(this.type);
            MCQ.create();
            MCQ.createAnswer();
            this.Questions.add(MCQ);
            break;
        case "3":
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.setType(this.type);//create new SAQ question
            SAQ.create();
            SAQ.createAnswer();
            this.Questions.add(SAQ);
            break;
        case "4":
            Essay EQ = new Essay();
            EQ.setType(this.type); //create new Essay question
            EQ.create();
            EQ.createAnswer();
            this.Questions.add(EQ);
            break;
        case "5":
            Ranking RQ = new Ranking();
            RQ.setType(this.type);//create new Ranking question
            RQ.create();
            RQ.createAnswer();
            this.Questions.add(RQ);
            break;
        case "6":
            Matching MQ = new Matching();
            MQ.setType(this.type);
            MQ.create(); //create new Matching question
            MQ.createAnswer();
            this.Questions.add(MQ);
            break;
        case "7":
            exit();

        default:
            //handle unwanted input
            System.out.println("\nSelect a valid Option.");
            addQuestion();
            break;
        }

    }

    /**
     * @return
     */

    //For later assingments function.
    public void createAnwerSheet(){}

}