
import java.util.*;

/**
 * 
 */
public class Essay extends Question {

    /**
     * Default constructor
     */
    public Essay() {
    }

    /**
     * 
     */
    public String length; 

    /**
     * 
     */
    public String type;
    public String prompt;
    /**
     * 
     */

    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getType() {
        // TODO implement here
        return "Essay";
    }

    /**
     * @param String 
     * @return
     */
    public void setLength(String len) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getLength() {
        // TODO implement here
        return "";
    }

    public void create(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Essay Question:");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter Essay Length:");
        this.length = keyboard.nextLine();

    }
    public void setType(String type){
        this.type = type;
    }

}
