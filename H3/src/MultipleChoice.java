
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
    this.numChoices = keyboard.nextInt();

    keyboard.nextLine();

    //cycle through number of choices, add new options.
    for(int index = 1; index <= numChoices; index++){

        String option;
        System.out.println("Enter choice #" + index + ": ");
        option = keyboard.nextLine();
        
        this.choices.add(option);
    
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


	try{

	System.out.println("\nEnter the number of choices for your Mutiple Choice question:");
	this.numChoices = keyboard.nextInt();

    keyboard.nextLine();

    //cycle through nunber of choices get responce for each question.
	for(int index = 1; index <= numChoices; index++){

		String option;
		System.out.println("Enter choice #" + index + ": ");
		option = keyboard.nextLine();
		
		this.choices.add(option);
	
	   }
    }
    catch(Exception e){
        //catch error from user, recall create
        System.out.println("Please enter a valid number of choices.");
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

        System.out.println("\nEnter the correct Answer for your MultipleChoice Question?:");
        
        //print available choices.
        for (String choice : getChoices()){
            System.out.println(count + ")" + choice);
            count++;
        }


        resp = keyboard.nextLine();
        answer.setAnswer(resp);

        //set attribute to question
        this.answer = answer;
    }

    /**
     * Function to display a MC
     * gets all of the choices and displays them
     */
    public void display(){

        System.out.println(getPrompt() + "\n");
        int count = 1;

        //for each choice, print choice increase counter.
        for (String choice: getChoices()) {
            System.out.print(" " + count + "). " + choice);
            count++;
        }

        System.out.println("");

    }

    //function to edit choices for a multiple choice question
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
            
            number = keyboard.nextInt();
            keyboard.nextLine();
            newChoice = keyboard.nextLine();

            this.choices.set(number -1, newChoice);

        }
        catch(Exception e){
            editChoices();
        }

    }

    /*Function for later homework assignment*/
    public void removeChoice(String choice) {}

    public Answers takeAnswer(){
        
        this.display();

        Scanner keyboard = new Scanner(System.in);
        Answers responce = new Answers();
        String resp;

        resp = keyboard.nextLine();

        responce.setAnswer(resp);

        return responce;

    }

}
