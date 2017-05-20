
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class TF extends MultipleChoice implements Serializable {

    private static final double serialVersionUID = -1L;

    /**
     * Default Constructor
     */

    public TF() {
        this.self = "TF";
    }

    /**
     * Function to create an TF quesiton
     * overrides MC option, uses this function
     */
    @Override
    public void create(){
	Scanner keyboard = new Scanner(System.in);	


	System.out.println("\nEnter your prompt or True False Question:");
	prompt = keyboard.nextLine();

    //add only two available choices to list already know two choices.
    this.choices.add("T");
    this.choices.add("F");

    }



    /**
     * Function to create an TF answer
     * gets the prompt from user and asks for correct answer.
     */
    @Override
    public void createAnswer(){
            
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();

        System.out.println("Enter the correct Answer for your True False Question?:");
        System.out.println("1.) T\t 2.) F");

        //get responce from user, add to answer not checking values
        resp = keyboard.nextLine();
        answer.setAnswer(resp);

        this.answer = answer;

    }

    /**
     * Function to display a TF
     * gets the two choices and prints them along with prompt
     */
    @Override
    public void display(){
        System.out.println(getPrompt());
        int count = 1;
        for (String choice: getChoices()) {
            System.out.print(" "+count + "). " + choice +"\n");
            count++;
        }
    }

    @Override
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
