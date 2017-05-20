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

    /**
     * survey variables needed for storing question and name
     */
    private static final double serialVersionUID = -1L;
    private String name;
    protected ArrayList<Question> Questions = new ArrayList<Question>();
    private Answers answer= new Answers();
    private ArrayList<Answers> userAnswer = new ArrayList<Answers>();
    protected String type;



    /**
     * Function adds a new survey question
     */
    public void addQuestion() {


    Scanner keyboard = new Scanner(System.in);
    String choice;

    //display menu 3
    System.out.println("\n1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new matching question");
    System.out.println("7) Quit");

    choice = keyboard.nextLine();


    //switch statement to create objets based on responce
    switch(choice){
        case "1":
            TF TFQ = new TF(); //create new true false question
            TFQ.setType(this.type);
            TFQ.create();
            this.Questions.add(TFQ);
            break;
        case "2":
            MultipleChoice MCQ = new MultipleChoice();
            MCQ.setType(this.type); //create new MC question
            MCQ.create();
            this.Questions.add(MCQ); //add question to list
            break;
        case "3":
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.setType(this.type); //create new SAQ question
            SAQ.create();
            this.Questions.add(SAQ);
            break;
        case "4":
            Essay EQ = new Essay(); //create new Essay question
            EQ.setType(this.type);
            EQ.create();
            this.Questions.add(EQ);
            break;
        case "5":
            Ranking RQ = new Ranking();
            RQ.setType(this.type); //create new Ranking question
            RQ.create();
            this.Questions.add(RQ);
            break;
        case "6":
            Matching MQ = new Matching();
            MQ.setType(this.type); //create new Matching question
            MQ.create();
            this.Questions.add(MQ);
            break;
        case "7":
            exit();

        default:
            //handle wrong input from user.
            System.out.println("\nSelect a valid Option.");
            addQuestion();
            break;
        }

    }


    //function returns question list
    public ArrayList<Question> getQuestions(){
       return this.Questions;
    }


    /**
     * Function to create a survey
     * gets number questions and sets attributes.
     */
    public void create(){

        int numQuestions;
        Scanner keyboard = new Scanner(System.in);

        if(getName() == null){
        setName();

        System.out.println("\n=========================================");
        System.out.println("           " +this.type + " : " +  this.name);
        System.out.println("=========================================\n");
        }


        System.out.println("\nHow many Questions would you like to have in for your "
            + this.type + "?:");

        //for each question call addQuestion
        try{

            numQuestions = keyboard.nextInt();

            for (int index = 0; index < numQuestions; index++){
                addQuestion();
            }

            //notify user
            System.out.println("\n" + this.type + " Created.");
            }

        catch(Exception e){
            //handle misinputted infomation
            System.out.println(e);
            System.out.println("Please enter a valid number of questions.");
            create();
        }
    }


    //Getter and Setter functions for Survey and Test
    public void setType(String type){this.type = type;}
    public String getType(){return this.type;}

    public void setName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter name for " + this.type + ": ");
        this.name = keyboard.nextLine();
    }

    public String getName(){return this.name;}

    public void exit(){
        System.out.println("Exiting....");
        System.exit(0);
    }

    
    /*FUNCTIONS BELOW FOR LATER IMPLIMENTATION*/
    public void record(String answer) {
    }

    /**
     * @return null
     */
    public void display() {

        int count = 1;
        for (Question question: Questions) {

            System.out.println(count + ")");
            question.display();
            
            count ++;
            System.out.println("\n");
        }

    }

    /**
     * @param number  
     * @return null
     * Function for next asssingment
     */
    public void editQuestion(int number) {
            String option, newPrompt;

            Scanner keyboard = new Scanner(System.in);


            Question editQ = this.Questions.get(number -1);
            System.out.println("Do you wish to modify the prompt? ");
            option = keyboard.nextLine();


            if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes") ){
                System.out.println(editQ.getPrompt());

                System.out.println("Enter a new prompt: ");
                newPrompt = keyboard.nextLine();

                editQ.setPrompt(newPrompt);

            }

            //if question is multiple choice prompt modify the choices
            if(editQ.getSelf().equals("MultipleChoice")){
            System.out.println("\nDo you wish to modify the choices? ");
                option = keyboard.nextLine();

            if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes") ){
                    
                editQ.editChoices();

                }
            }

            //if the type is a test. prompt change correct answer.
            if(this.type.equals("Test")){
                System.out.println("\nDo you wish to modify the correct answer? ");
                    option = keyboard.nextLine();

            if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes") ){

                editQ.createAnswer();
                }

            }        

        
        }

        public void take(){

        Scanner keyboard = new Scanner(System.in);
        String userAnswer;
        int count = 1;
        Answers responce;
        System.out.println("\n");


        for (Question question: Questions) {

            //creating variables for new questions

            System.out.println(count + ")");
            responce = question.takeAnswer();    
    

            //create answer add it to arraylist of survey or test.
            this.userAnswer.add(responce);


            System.out.println("\n");
            count ++; 

        } 
        }


}
