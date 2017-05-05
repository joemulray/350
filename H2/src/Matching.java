import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Matching extends Question implements Serializable {

    /**
     * Default constructor
     */
    public Matching(){
        this.self = "Matching";
    }

    public int numChoices;
    public List<String> left = new ArrayList<String>();
    public List<String> right = new ArrayList<String>();

    /**
     * 
     */
    public void Matching() {
        // TODO implement here
    }

    public void create(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your Matching prompt or question");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter the number of choices you would like to add to your Matching Quesiton:");
        this.numChoices = keyboard.nextInt();

        keyboard.nextLine();

        for(int index = 1; index <= numChoices; index++){

            String option;
            System.out.println("Enter choice #" + index + ": ");
            option = keyboard.nextLine();
            this.left.add(option);
            System.out.println("Enter Matching choice:"); 
            option = keyboard.nextLine();
            this.right.add(option);
            }

    }


    @Override
    public String getPrompt(){return this.prompt;}

}
