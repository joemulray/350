
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

        System.out.println("Questions was called");

    }

}
