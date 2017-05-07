
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Ranking extends Matching implements Serializable {

    protected int numChoices;
    protected List<String> choices = new ArrayList<String>();

    /**
     * Default constructor
     */
    public Ranking(){
        this.self = "Ranking";
    }


    /**
     * @return
     */
    public void display() {}



    @Override
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

    @Override
    public void createAnswer(){
        //return this.answer;
    }

}
