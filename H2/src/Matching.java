import java.util.*;

/**
 * 
 */
public class Matching extends Question {

    /**
     * Default constructor
     */
    public Matching(){
        this.self = "Matching";
    }

    public int numChoices;
    public List<String> choices = new ArrayList<String>();
    public String side;

    /**
     * 
     */
    public void Matching() {
        // TODO implement here
    }

    public void create(){
        
        System.out.println("Enter your Matching prompt or question");

    }
    
    @Override
    public List<String> getChoices(){return this.choices;}

    public String getPrompt(){return this.prompt;}

}
