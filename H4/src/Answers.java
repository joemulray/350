
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class Answers extends Test implements Serializable{

    /**
     * Variables to hold answer contents
     * needs to a list for ranking questions, etc.
     */
    private List<String> answer = new ArrayList<String>();
    private static final double serialVersionUID = -1L;
    /**
     * Default constructor
     */
    public Answers() {}

    /**
     * returns list of answers for a question
     * @return List<String>
     */
    public List<String> getAnswer() {
        return this.answer;
    }

    /**
     * returns list of answers for a question
     * @param resp responce from question when createing
     * new answer.
     */
    public void setAnswer(String resp){
        this.answer.add(resp);
    }

    /**
     * Function that displays all answers
     */
    public void display(){

        if(this.answer.size() > 0){
            for(String correct : answer){
                out.print(" " + correct);
            }
        }
        else
            out.print("Question will need Grading.");
    }

}
