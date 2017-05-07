
import java.util.*;
import java.io.Serializable;
/**
 * 
 */
public class TF extends MultipleChoice implements Serializable {

    public TF() {
        this.self = "TF";
    }


    @Override
    public void create(){
	Scanner keyboard = new Scanner(System.in);	


	System.out.println("Enter your prompt or True False Question:");
	prompt = keyboard.nextLine();

    this.choices.add("T");
    this.choices.add("F");
	
    if(getType().equals("Test"))
        System.out.println("This is a test");

    }

    @Override
    public void createAnswer(){
        
        String resp;
        Scanner keyboard = new Scanner(System.in);
        Answers answer = new Answers();

        System.out.println("Enter the correct Answer for your True False Question?:");
        System.out.println("1.) T\t 2.) F");

        resp = keyboard.nextLine();

        switch(resp){
            case "1":
                answer.setAnswer("T");
                break;
            case "2":
                answer.setAnswer("F");
                    break;
            default:
                System.out.println("Enter a valid asnwer.");
                createAnswer();
                break;
            }

             this.answer = answer;

    }

}
