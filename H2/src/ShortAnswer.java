
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class ShortAnswer extends Essay implements Serializable {

    /**
     * Default constructor
     */
    public ShortAnswer() {
        this.self = "ShortAnswer";
    }


    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    @Override
    public void create(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter prompt or your Short Answer question:");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter Short Answer Length:");
        this.length = keyboard.nextLine();

    }

    @Override
    public Answers createAnswer(){
        return this.answer;
    }

}
