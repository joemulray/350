
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class MultipleChoice extends Question implements Serializable {

    /**
     * Variables used to store MC choices and 
     * number of choices entered,
     */
    protected List<String> choices = new ArrayList<String>();
    protected int numChoices;
    private static final double serialVersionUID = -1L;
    private int numAnswers;
    private int number;

    /**
     * Default constructor
     */
    public MultipleChoice() {
        this.self = "MultipleChoice";
    }


    /**
     * Function to add choices to existing question
     * used more in editing questions.
     */
    public void addChoice() {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the number of choices you would like to add to your MC Quesiton:");

    try{
        this.numChoices = keyboard.nextInt();
        keyboard.nextLine();
    //cycle through number of choices, add new options.
    for(int index = 1; index <= numChoices; index++){

        String option;
        System.out.println("Enter choice #" + index + ": ");
        option = keyboard.nextLine();
        
        this.choices.add(option);
        
        }

        System.out.println("How many answers to your questiion.");
            this.number = keyboard.nextInt();
            }
        catch(Exception e){
            create();
            }
        }

    /**
     * Function to create an Multiple Choice quesiton
     * and choices with question. 
     */
    public void create(){
	
	Scanner keyboard = new Scanner(System.in);
	
    //Handling incorrect input to recall create again
    if(this.prompt == null){
	System.out.println("\nEnter the prompt or your multiple choice question:");
	this.prompt = keyboard.nextLine();
    }   

        System.out.println("\nEnter the number of choices for your Mutiple Choice question:");
    	try{

    	this.numChoices = keyboard.nextInt();
        keyboard.nextLine();

        //cycle through nunber of choices get responce for each question.
    	for(int index = 1; index <= numChoices; index++){

    		String option;
    		System.out.println("Enter choice #" + index + ": ");
    		option = keyboard.nextLine();
    		
    		this.choices.add(option);
    	   }

        System.out.println("\nHow many answers to your questiion.");
        this.number = keyboard.nextInt();
            
        }
        catch(Exception e){
         create();
        }

	}

    /**
     * @return choices  returns choices for a MC quesiton
     */
    @Override
    public List<String> getChoices(){
        return this.choices;
    }


    /**
     * Function to create an MC answer
     * gets the prompt from user and answer to enter correct info.
     */
     public void createAnswer(){

        int count = 1;
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();
        char letter = 'A';

        System.out.println("\nEnter the correct Answer for your MultipleChoice Question?:");
        
        //print available choices.
        for (String choice : getChoices()){
            System.out.println(count + ")" + choice);
            count++;
        }

        System.out.println("");
        if(number > 1){
            for(int index = 0; index < number ; index ++){
            System.out.print(letter + ".) ");
            resp = keyboard.nextLine();
            answer.setAnswer(resp);
            letter ++;
            }
        }
        else{

            resp = keyboard.nextLine();
            answer.setAnswer(resp);
        }
        //set attribute to question
        this.answer = answer;
    }

    /**
     * Function to display a MC
     * gets all of the choices and displays them
     */
    public void display(){

        System.out.println(getPrompt());
        int count = 1;

        //for each choice, print choice increase counter.
        for (String choice: getChoices()) {
            System.out.print(" " + count + "). " + choice);
            count++;
        }

        System.out.println("");

    }

    /**
     * Function to edit choices for a multiple choice question
     */
    @Override
    public void editChoices(){

    Scanner keyboard = new Scanner(System.in);
    int count = 1, number;
    String newChoice;

        //for each choice, print choice increase counter.
        for (String choice: getChoices()) {
            System.out.print(" " + count + "). " + choice);
            count++;
        }

        System.out.print("\nEnter choice: ");
        try{
            //try to get user input
            number = keyboard.nextInt();
            keyboard.nextLine();
            newChoice = keyboard.nextLine();

            this.choices.set(number -1, newChoice);

        }
        catch(Exception e){
            editChoices(); //recall editchocies on error
        }

    }


    /**
     * Function to take a MC answer
     * gets the prompt and prompts input for answer
     */
    public Answers takeAnswer(){
            
        //display prompt
        this.display();

        Scanner keyboard = new Scanner(System.in);
        Answers responce = new Answers();
        String resp;
        char letter = 'A';

        //differnt menu if more then one option
        if(this.number > 1){

            System.out.println("");
            //for each number of answers get input
            for(int index = 0; index < this.number; index ++){
            System.out.print(letter + ".) ");
            resp = keyboard.nextLine();
            responce.setAnswer(resp);
            letter++;
            }
        }
        else{
            //get input
            resp = keyboard.nextLine();
            responce.setAnswer(resp);
        }

        return responce;

        }

}
