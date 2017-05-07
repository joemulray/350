
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Essay extends Question implements Serializable {


    protected String length; 


    /**
     * Default constructor
     */
    public Essay() {
        this.self = "Essay";
    }

    /**
     * @param String 
     * @return
     */


    public void setLength(String len) {
       this.length = len;
    }

    /**
     * @return
     */
    @Override
    public String getLength() {
        // TODO implement here
        return this.length;
    }


    public void create(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Essay Question:");
        this.prompt = keyboard.nextLine();

        System.out.println("Enter Essay Length:");
        this.length = keyboard.nextLine();

    }

    public void createAnswer(){
        //return this.answer;
    }

}
