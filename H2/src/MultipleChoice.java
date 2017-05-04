
import java.util.*;

/**
 * 
 */
public class MultipleChoice extends Question {

    /**
     * Default constructor
     */
    public MultipleChoice() {
        this.self = "MultipleChoice";
    }

    /**
     * 
     */
    public List<String> choices = new ArrayList<String>();
    public int numChoices;


    /**
     * 
     */
    public void MultipleChoice() {
        // TODO implement here
    }


    /**
     * @param String 
     * @return
     */
    public void addChoice() {
    Scanner keyboard = new Scanner(System.in);


    System.out.println("Enter the number of choices you would like to add to your MC Quesiton:");
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
     * @param String 
     * @return
     */
    public void removeChoice(String choice) {
        // TODO implement here
    }


    public void create(){
	
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Enter the prompt or your multiple choice question:");
	this.prompt = keyboard.nextLine();

	
	System.out.println("Enter the number of choices for your Mutiple Choice question:");
	this.numChoices = keyboard.nextInt();

	keyboard.nextLine();

	for(int index = 1; index <= numChoices; index++){

		String option;
		System.out.println("Enter choice #" + index + ": ");
		option = keyboard.nextLine();
		
		this.choices.add(option);
	
	}


	}
    @Override
    public List<String> getChoices(){
        return this.choices;
    }

}
