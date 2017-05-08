
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
	
	System.out.println("Enter the prompt or your ranking question:");
	this.prompt = keyboard.nextLine();
	
	System.out.println("\nEnter the number of choices for your ranking question:");
	this.numChoices = keyboard.nextInt();
	
	keyboard.nextLine();	
	

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

        int count=1;

        System.out.println(getPrompt());
        for(String choice : getChoices()){
            System.out.println(" " + count + "). " + choice);
            count++;
        }
    }

}
