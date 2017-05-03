
import java.util.*;

/**
 * 
 */
public abstract class Question {

    /**
     * Default constructor
     */
    public Question() {
    }

    /**
     * 
     */
    public int number;
    public String prompt;
    public String type;

    /**
     * @param int
     */
    public void Question(int number) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getQuestion() {
        // TODO implement here
        return "";
    }

    /**
     * @param String 
     * @return
     */
    public void setQuestion(String question) {
        // TODO implement here
    }

    public void addQuestion(){

    }

    public String getType(){
        System.out.println("Get type in Question called!");
        return this.type;
    }

}
