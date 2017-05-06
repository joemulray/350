
import java.util.*;
import java.io.Serializable;

/**
 * 
 */
public class Test extends Survey  implements Serializable{

    /**
     * Default constructor
     */
    public Test() {
    }

    /**
     * 
     */

    public Answers answerSheet = new Answers();


    /**
     * 
     */

    @Override
    public void addQuestion() {


    Scanner keyboard = new Scanner(System.in);
    String choice;

    System.out.println("1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new matching question");
    System.out.println("7) Exit");

    choice = keyboard.nextLine();

    switch(choice){
        case "1":
            TF TFQ = new TF();
            TFQ.setType(this.type);
            TFQ.create();
            this.Questions.add(TFQ);
            break;
        case "2":
            MultipleChoice MCQ = new MultipleChoice();
            MCQ.setType(this.type);
            MCQ.create();
            this.Questions.add(MCQ);
            break;
        case "3":
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.setType(this.type);
            SAQ.create();
            this.Questions.add(SAQ);
            break;
        case "4":
            Essay EQ = new Essay();
            EQ.setType(this.type);
            EQ.create();
            this.Questions.add(EQ);
            break;
        case "5":
            Ranking RQ = new Ranking();
            RQ.setType(this.type);
            RQ.create();
            this.Questions.add(RQ);
            break;
        case "6":
            Matching MQ = new Matching();
            MQ.setType(this.type);
            MQ.create();
            this.Questions.add(MQ);
            break;
        case "7":
            exit();

        default:
            System.out.println("Select a valid Option.");
            addQuestion();
            break;
        }

    }

    /**
     * @return
     */

}