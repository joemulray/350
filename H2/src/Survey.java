
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Survey extends Start implements Serializable {

    /**
     * Default constructor
     */
    public Survey() {
    }

    private String name;
    protected ArrayList<Question> Questions = new ArrayList<Question>();
    private Answers answer= new Answers();
    protected String type;



    /**
     * @return
     */
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
    public void takeSurvey() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void display() {

        int count = 1;
        int index;

        for(Question question : Questions ){
            System.out.println(count + ")");
            System.out.println(question.prompt);

            switch(question.self){
                case "Essay":
                case "ShortAnswer":
                    System.out.println("Length:" + question.getLength());
                    break;
                case "Matching":
                    System.out.println("Matching Will Impliment Later");
                    break;
                case "MultipleChoice":
                case "Ranking":
                case "TF":
                    index = 1;
                    //System.out.println(question.self + " Choices:");
                    for(String choice : question.getChoices()){
                        System.out.print("\t" + index + "." + choice);
                        index++;
                    }
                    break;

                default:
                    break;


            }
            System.out.println("");
            count ++;
        }
    }


    /**
     * @param int 
     * @return
     */
    public void editQuestion(int number) {
        // TODO implement here
    }

    public void getQuestion(int number){
        //TODO return question.
    }

    public void create(){

        int numQuestions;
        Scanner keyboard = new Scanner(System.in);

        setName();

        System.out.println("****************");
        System.out.println(this.type + " : " +  this.name);
        System.out.println("****************");

        System.out.println("How many Questions would you like to have in for your "
            + this.type + "?:");

        numQuestions = keyboard.nextInt();

        for (int index = 0; index < numQuestions; index++){

            addQuestion();
        }

        System.out.println(this.type + " Created.");
    }

    public void setType(String type){

        this.type = type;
    }

    
    public void record(String answer) {

    }

    public String getType(){return this.type;}

    public void setName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name for " + this.type + ":");
        this.name = keyboard.nextLine();
    }

    public String getName(){return this.name;}

    public void exit(){
        System.out.println("Exiting....");
        System.exit(0);
    }

}
