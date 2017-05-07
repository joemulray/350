
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public abstract class Question implements Serializable {

    protected String prompt;
    protected String type;
    protected String self;
    protected Answers answer;

    /**
     * Default constructor
     */
    public Question() {
    }


    /**
     * @return
     */
    public void display() {
        // TODO implement here
    }

  

    public String getType(){
        return this.type;
    }

 
    public abstract void createAnswer();
    public abstract void create();

    public String getLength(){return "";}
    public void setType(String type){this.type = type;}
    public String getPrompt(){return this.prompt;}
    public List<String> getChoices(){ return new ArrayList<String>();}


    //Functions to impliment for a later homework.
    public String getQuestion() {return "";}
    public void setQuestion(String question) {}
    public void addQuestion(){}
}
