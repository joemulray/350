
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class TF extends MultipleChoice implements Serializable {

    public TF() {
        this.self = "TF";
    }


    @Override
    public void create(){
	Scanner keyboard = new Scanner(System.in);	


	System.out.println("Enter your prompt or True False Question:");
	prompt = keyboard.nextLine();

    this.choices.add("T");
    this.choices.add("F");
	
    if(getType().equals("Test"))
        System.out.println("This is a test");

    }

    public Answers createAnswer(){
        return this.answer;
    }

}
