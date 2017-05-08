
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public abstract class Question implements Serializable {

    /**
     * attributes needed for 
     * quesitons and their answers.
     */

    private static final double serialVersionUID = -1L;
    protected String prompt;
    protected String type;
    protected String self;
    protected Answers answer;

    /**
     * Default constructor
     */
    public Question() {}




    /**
     * Function returns type of quesiton. 
     * @return type  returns the type of question created.
     */
    public String getType(){
        return this.type;
    }

    /**
     * abstract functions used for child classes.
     */
    public abstract void createAnswer();
    public abstract void create();
    public abstract void display();

    /**
     * General functions used by child classes, and start
     * to retrieve/set information.
     */
    public String getLength(){return "";}
    public void setType(String type){this.type = type;}
    public String getPrompt(){return this.prompt;}
    public List<String> getChoices(){ return new ArrayList<String>();}
    public void displayAnswer(){this.answer.display();}



    //Functions to impliment for a later homework.
    public String getQuestion() {return "";}
    public void setQuestion(String question) {}
    public void addQuestion(){}
    public Answers getAnswer(){return this.answer;}
}
