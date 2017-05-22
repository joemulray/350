import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Matching extends Question implements Serializable {
    
    /**
     * Variable declaration, stores, matching choices and number of choices.
     */

    private int numChoices;
    private List<String> choices = new ArrayList<String>();
    private static final double serialVersionUID = -1L;
    /**
     * Default constructor
     */
    public Matching(){
        this.self = "Matching";
    }


     /**
     * Function to create a matching question
     * gets the prompt from user and inputs matching arguments
     */
    public void create(){
        Scanner keyboard = new Scanner(System.in);

        //check if prompt is already set
        if(this.prompt == null){
        System.out.println("\nEnter your Matching prompt or question");
        this.prompt = keyboard.nextLine();
        }

        //get number of choices, handing input and recalling create on error.
        System.out.println("Enter the number of choices you would like to add to your Matching Quesiton:");
        try{
        this.numChoices = keyboard.nextInt();

        keyboard.nextLine();

        //cycle through number of choices wanted by user.
        for(int index = 1; index <= numChoices; index++){

            String option;
            System.out.println("Enter choice #" + index + ": ");
            option = keyboard.nextLine();
            this.choices.add(option);
            System.out.println("Enter Matching choice:"); 
            option = keyboard.nextLine();
            this.choices.add(option);
            }
        }
        catch(Exception e){
            //catch wrong input recall create again.
            System.out.println("\nPlease enter a valid number of choices\n");
            create();
        }

    }

    /**
     * @return choices  returns the choices for a maching question
     * entered in by user.
     */
    @Override
    public List<String> getChoices(){
        return this.choices;
    }


    /**
     * Function to create an answer to a matching question
     * prompts user and creates a answer object.
     */
    public void createAnswer(){
        
        //create new answer object and set vaues.
        char letter = 'A';
        Answers answer = new Answers();
        Scanner keyboard = new Scanner(System.in);
        String resp;
        System.out.println("\nEnter the correct Answer for your Matching Question?:");
        this.display();

        List<String> tempChoice = getChoices();

        //for each choice available only get maching answer values from right side.
        System.out.println("");
        for(int index=1; index<= (tempChoice.size() /2); index++){
            System.out.print(letter + "). ");
            resp = keyboard.nextLine();
            answer.setAnswer(resp);
            letter++;
        }

        this.answer = answer;
    }

    /**
     * Function to display a maching question
     * gets the prompt and prints available choices.
     */
    public void display(){
        //display matching question
        int count=0;
        char letter = 'A';
        List<String> choice = getChoices();
        System.out.println(getPrompt());


        //Stored into arraylist so printing should only be half size of array.
        for(int index = 1; index <= choice.size()/2; index++ ){
            System.out.println(" " + letter + ".) " + choice.get(count) + "\t" +
            index + ".)" + choice.get(count+1));
            count+=2;
            letter++;
        }
    }


    public Answers takeAnswer(){
    
        this.display();
        
        System.out.println("\n");
        Answers responce = new Answers();
        Scanner keyboard = new Scanner(System.in);
        String resp;
        char letter = 'A';
        List<String> choice = getChoices();

        for(int index = 1; index <= choice.size()/2; index++ ){
            System.out.print(letter + ".) ");
            resp = keyboard.nextLine();

            letter ++;
            responce.setAnswer(resp);
        }

        return responce;
    }
}
