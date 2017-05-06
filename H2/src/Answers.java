
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Answers implements Serializable{

    /**
     * 
     */
    private List<String> answer = new ArrayList<String>();


    /**
     * Default constructor
     */
    public Answers() {}

    /**
     * @param number
     * @return null
     */
    public List<String> getAnswer() {
        return this.answer;
    }

    public void setAnswer(ArrayList<String> answer){
        this.answer = answer;
    }

}
