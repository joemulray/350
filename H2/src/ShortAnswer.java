
import java.util.*;

/**
 * 
 */
public class ShortAnswer extends Essay {

    /**
     * Default constructor
     */
    public ShortAnswer() {
    }

    /**
     * 
     */
    public String prompt;
    public String type;

    /**
     * 
     */
    public String limit;


    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @param String 
     * @return
     */
    public void setLimit(String limit) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getType() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getLimit() {
        // TODO implement here
        return this.type;
    }

    public void create(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter prompt or your Short Answer question:");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter Short Answer Length:");
        this.length = keyboard.nextLine();
    }

    public void setType(String type){
        this.type = type;
    }

}
