
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

    /**
     * 
     */
    public String type; 
    //List<String> choices = new ArrayList();
    public String prompt;

    /**
     * 
     */
    public void TF() {
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
        return "";
    }

    public void create(){
	Scanner keyboard = new Scanner(System.in);	


	System.out.println("Enter your prompt or True False Question:");
	prompt = keyboard.nextLine();
	
	

    }


    public void setType(String type){
        this.type = type;
    }

}
