
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
    protected int number;

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

        //get user input
        Scanner keyboard = new Scanner(System.in);
        out.print("\nEnter prompt or your Essay question:");
        this.prompt = keyboard.nextLine();

        //get length of essay
        out.print("Enter Essay Length:");
        this.length = keyboard.nextLine();

        //get number of answers from user.
        out.print("How many answers to your questiion.");
        try{
            this.number = keyboard.nextInt();
            while(this.number < 0){
                out.print("Please enter a valid number of choices.");
                this.number = keyboard.nextInt();
            }
        }
        catch(Exception e){
            this.number = 1;
        }

    }


    /**
     * Function to create an essay
     * gets the prompt from user and length requirment if any.
     */
    public void createAnswer(){

        //create new answer for essay question
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();

        out.print("\nEssay Questions will require Grading.");


        this.answer = answer;
    }


    /**
     * Function to display an essay
     * by getting the prompt and printing the length requirement
     */
    public void display(){

        out.print(getPrompt());
        out.print(" Length: " + getLength() + "\n");
    }


    /**
     * Function to create an Essay answer
     * @return Answers returns answer object from user input
     */
    public Answers takeAnswer(){
        
        this.display();

        //declaring variables for input
        Scanner keyboard = new Scanner(System.in);
        Answers responce = new Answers();
        String resp;
        char letter = 'A';

        //displaying different prompt for different number of answers required
       if(this.number > 1){

            for(int index = 0; index < this.number; index ++){
            out.print(letter + ".)");
            resp = keyboard.nextLine();
            responce.setAnswer(resp);
            letter++;
            }
        }
        else{
            //else get regular input
            resp = keyboard.nextLine();
            responce.setAnswer(resp);
        }

        //return the answer
        return responce;

    }

}
