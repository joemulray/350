
import java.util.*;

/**
 * 
 */
public class TF extends MultipleChoice {

    /**
     * Default constructor
     */
    public TF() {
    }

    public void TF() {
        // TODO implement here
    }

    @Override
    public void create(){
	Scanner keyboard = new Scanner(System.in);	


	System.out.println("Enter your prompt or True False Question:");
	prompt = keyboard.nextLine();

    this.choices.add("T");
    this.choices.add("F");
	

    }

/*
    public void setType(String type){
        this.type = type;
    }
*/
}
