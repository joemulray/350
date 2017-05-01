
import java.util.*;

/**
 * 
 */
public class Ranking extends Matching {

    /**
     * Default constructor
     */
    public Ranking(){
    }

    /**
     * 
     */
    public String type;
    public String prompt;
    public int numChoices;
    public List<String> choices = new ArrayList<String>();

    /**
     * 
     */
    public void Ranking() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getType() {
        // TODO implement here
        return this.type;
    }
    public void create(){
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Enter the prompt or your ranking question:");
	this.prompt = keyboard.nextLine();
	
	System.out.println("Enter the number of choices for your ranking question:");
	this.numChoices = keyboard.nextInt();
	
	keyboard.nextLine();	
	

	for(int index = 1; index <= numChoices; index++){

		String option;
		System.out.println("Enter choice #" + index + ": ");
		option = keyboard.nextLine();
		
		this.choices.add(option);
	
	}



    }

    public void setType(String type){
        this.type = type;
    }

}
