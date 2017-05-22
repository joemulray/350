
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class ShortAnswer extends Essay implements Serializable {

    private static final double serialVersionUID = -1L;
    /**
     * Default constructor
     */


    public ShortAnswer() {
        this.self = "ShortAnswer";
    }


    /**
     * Function to create an Short Answer quesiton
     * overrides essay create function
     */
    @Override
    public void create(){

        //get prompt from user along with length requirements.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter prompt or your Short Answer question:");
        this.prompt = keyboard.nextLine();

        //gets length from user
        System.out.println("Enter Short Answer Length:");
        this.length = keyboard.nextLine();


        //get input from user on number of quesitons
        System.out.println("How many answers to your questiion.");
        try{
            this.number = keyboard.nextInt();
            while(this.number < 0){
                System.out.println("Please enter a valid number of choices.");
                this.number = keyboard.nextInt();
            }
        }
        catch(Exception e){
            this.number = 1;
        }

    }

    /**
     * Function to create a Short Answer correct quesiton
     * create answer object and store as question
     */
    @Override
    public void createAnswer(){

        //get user input from scanner 
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();

        //short answer needs grading no input on asnwer
        System.out.println("\nShort Answer Questions will require Grading.");

        this.answer = answer;
    }

    
    /**
     * Function to display a ShortAnswer
     * gets prompt and prints length requirements
     */
    @Override
    public void display() {
        System.out.println(getPrompt());
        System.out.println("Length: " + getLength() + "\n");
    }

}
