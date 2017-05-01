
import java.util.*;

/**
 * 
 */
public class Start {

    /**
     * Default constructor
     */
    public Start() {
    }



    /**
     * 
     */
    public void Start() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void menu() {
        // TODO implement here

	//variable declaration
	int choice; 
	Scanner keyboard = new Scanner(System.in);
	Test test = new Test();
	Survey survey = new Survey();
		

	//display menu options.
	System.out.println("1) Survey\n2) Test");
			
	choice = keyboard.nextInt();
		
	if(choice == 1){
	
	System.out.println("1) Create a new survey");
	System.out.println("2) Display a Survey");
	System.out.println("3) Load a Survey");
	System.out.println("4) Save a Survey");
	System.out.println("5) Quit");
	}
	
	else{
	System.out.println("1) Create a new Test");
	System.out.println("2) Display a new Test");
	System.out.println("3) Load a Test");
	System.out.println("4) Save a Test");
	System.out.println("5) Quit");
	
	}
		
	choice = keyboard.nextInt();
    test.addQuestion();
	}

    /**
     * @return
     */
    public void createTest() {
        // TODO implement here
    }

    /**
     * @param String Test 
     * @return
     */
    public void takeTest(String Test) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void createSurvey() {
        // TODO implement here
    }

    /**
     * @param String Survey 
     * @return
     */
    public void takeSurvey(String Survey) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void exit() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void editTest() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void editSurvey() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void save() {
        // TODO implement here
    }


}
