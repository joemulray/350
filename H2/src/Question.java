
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

    public String prompt;
    public String type;
    public String self;

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
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public List<String> getChoices(){
        return new ArrayList<String>();
    }

    public String getLength(){
        return "";
    }

}
