import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Matching extends Question implements Serializable {

    private int numChoices;
    private List<String> left = new ArrayList<String>();
    private List<String> right = new ArrayList<String>();

    /**
     * Default constructor
     */
    public Matching(){
        this.self = "Matching";
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

    public Answers createAnswer(){
        return this.answer;
    }
}
