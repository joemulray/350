
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Essay extends Question implements Serializable {

    /**
     * Variables to hold length of essay.
     */
    protected String length;
    private static final double serialVersionUID = -1L;

    /**
     * Default constructor
     */
    public Essay() {
        this.self = "Essay";
    }



    /**
     * @param len  Setter if wanted to change
     * length of essay.
     */
    public void setLength(String len) {
       this.length = len;
    }

    /**
     * @return length of Essays
     */
    @Override
    public String getLength() {
        return this.length;
    }

    /**
     * Function to create an essay
     * gets the prompt from user and length requirment if any.
     */
    public void create(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter prompt or your Essay question:");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter Essay Length:");
        this.length = keyboard.nextLine();

    }


    /**
     * Function to create an essay
     * gets the prompt from user and length requirment if any.
     */
    public void createAnswer(){
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();

        System.out.println("Enter the correct Answer for your Essay Question?:");

        resp = keyboard.nextLine();
        answer.setAnswer(resp);

        this.answer = answer;
    }

    /**
     * Function to display an essay
     * by getting the prompt and printing the length requirement
     */
    public void display(){

        System.out.println(getPrompt());
        System.out.println(" Length: " + getLength() + "\n");
    }

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
