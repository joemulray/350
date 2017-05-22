
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Ranking extends Matching implements Serializable {

    /**
     * Variables for ranking class, includes choices.
     */
    protected int numChoices;
    protected List<String> choices = new ArrayList<String>();
    private static final double serialVersionUID = -1L;

    /**
     * Default constructor
     */
    public Ranking(){
        this.self = "Ranking";
    }

    /**
     * @return choices  returns the choices for a maching question
     * entered in by user.
     */
    @Override
    public List<String> getChoices(){
        return this.choices;
    }

    /**
     * Function to create a Ranking quesiton,
     * sets prompt and number of choices.
     */
    @Override
    public void create(){
	Scanner keyboard = new Scanner(System.in);
	
    //get prompt from user
	System.out.println("\nEnter the prompt or your ranking question:");
	this.prompt = keyboard.nextLine();
	   
    //get number of choices from user
	System.out.println("\nEnter the number of choices for your ranking question:");
    try{
	this.numChoices = keyboard.nextInt();
	}
    catch(Exception e){
        System.out.println("Please select a valid option.");
        create();
    }
	keyboard.nextLine();	
	
    //from each number of choices get specific prompt
	for(int index = 1; index <= numChoices; index++){

		String option;
		System.out.println("Enter choice #" + index + ": ");
		option = keyboard.nextLine();
		
		this.choices.add(option);
	
	}



    }

    /**
     * Function to create an Ranking answer
     * gets the prompt from user and answer to enter correct info for each choice.
     */
    @Override
    public void createAnswer(){
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();
        int count = 1;

        System.out.println("\nEnter the correct Answer for your Ranking Question?:");

        System.out.println("Total Ranking Choices: " + this.getChoices().size());

        //for each choice, get an answer for ranking quesitons each choice needs an answer.
        for(String choice : this.getChoices()){
            System.out.println(count + ": " + choice);
            resp = keyboard.nextLine(); 
            answer.setAnswer(resp);
            count ++;
        }
        
        this.answer = answer;
    }

    /**
     * Function to display a Ranking question
     * gets all of the choices and displays them along with prompt
     */
    @Override
    public void display() {

        char letter = 'A';

        System.out.println(getPrompt());
        for(String choice : getChoices()){
            System.out.println(" " + letter + ".) " + choice);
            letter++;
        }
    }

    /**
     * Function to take a Ranking answer
     * @return Answers returns answer object
     */
    @Override
    public Answers takeAnswer(){
    
        this.display();

        //declaring variables
        Answers responce = new Answers();
        char letter = 'A';
        Scanner keyboard = new Scanner(System.in);
        String resp;

        //for each choice get answer from user
        System.out.println("");
        for(String choice : this.getChoices()){
            System.out.print(letter + ".) " + choice + " : ");
            resp = keyboard.nextLine(); 
            responce.setAnswer(resp);
            letter ++;
        }

        return responce;
    }

}
