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
    protected String name;
    protected ArrayList<Question> Questions = new ArrayList<Question>();
    protected String type;
    protected ArrayList<ArrayList<Answers>> allTaken = new ArrayList<ArrayList<Answers>>();


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

        displayName();
        }


        System.out.println("\nHow many Questions would you like to have in for your "
            + this.type + "?");

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


    /**
     * @return null
     */
    public void display() {

        int count = 1;
        //for each question call questions display function
        for (Question question: Questions) {

            //keep count of question numbers
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


        public void grade(){}

        public void take(){

        //create list of users answers
        ArrayList<Answers> userAnswer = new ArrayList<Answers>();
        Scanner keyboard = new Scanner(System.in);
        int count = 1;
        Answers responce;
        System.out.println("\n");


        //for each question get answer
        for (Question question: Questions) {

            //creating variables for new questions

            System.out.println(count + ")");
            responce = question.takeAnswer();    
    

            //create answer add it to arraylist of survey or test.
            userAnswer.add(responce);


            System.out.println("\n");
            count ++; 

        }

        //add the arraylist to list of responces for survey
        allTaken.add(userAnswer);
        }

        public void tabulate(){

            //if there are no responces, just return
            if(allTaken.size() == 0){
                System.out.println("\nNo responces for this Test.");
                return;
            }

            displayName();
            //print number of responces taken for the test or survey
            System.out.println("NUMBER OF RESPONCES: " + allTaken.size() + "\n");
            int count = 1;
            //for each question in the SOT
            for(int index = 0; index < Questions.size(); index++){  

                System.out.println(count + ".) ");
                Questions.get(index).display();
                System.out.println("");
            
                //use hashmap to store answers as key and int as number of appearances.
                HashMap<List<String>, Integer> hmap = new HashMap<List<String>, Integer>(); 

                //for each list of answers in the responces
                for(ArrayList<Answers> savedResponces : allTaken){

                        List<String> temp = savedResponces.get(index).getAnswer();

                        //check if hashmap already contains the key if it does add one to index
                        if(hmap.containsKey(temp)){

                            //add one to index otherwise just set as one
                            Integer number = hmap.get(temp) + 1;
                            hmap.put(temp, number);

                        }
                        else
                        hmap.put(temp, 1);

                }

                //cycle through the hashmap of answers for current question
                for (Map.Entry<List<String> ,Integer> entry : hmap.entrySet()) {

                  //get the key and value informations
                  List<String> key = entry.getKey();
                  Integer value = entry.getValue();

                  //display the keys and values
                  System.out.print(" " + key + " ");
                  System.out.println(": " + value);

                }

                System.out.println("\n");
                count++;

            }

        }

        public void displayName(){

        System.out.println("\n=========================================");
        System.out.println("           " +this.type + " : " +  this.name);
        System.out.println("=========================================\n");

        }


}
