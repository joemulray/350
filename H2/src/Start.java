
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

	int choice, option;
	Scanner keyboard = new Scanner(System.in);


	System.out.println("********");
    System.out.println("Welcome");
    System.out.println("********");

	System.out.println("1) Survey\n2) Test");
			
	choice = keyboard.nextInt();
		
	if(choice == 1){
	
	System.out.println("1) Create a new survey");
	System.out.println("2) Display a Survey");
	System.out.println("3) Load a Survey");
	System.out.println("4) Save a Survey");
	System.out.println("5) Quit");

	option = keyboard.nextInt();
	
	switch (option){
		case 1:
			Survey survey = new Survey();
			survey.setType("Survey");
			survey.create();
			survey.display();
			break;

		case 2:
			System.out.println("Display a Survey");
			break;
		
		case 3:
			System.out.println("Load a Survey");
			break;

		case 4:
			System.out.println("Save a Survey");
			break;

		case 5:
			exit();

		default:
			System.out.println("Invalid Selection.");
			menu();
			break;
		}
	
	}

	
	else{

	System.out.println("1) Create a new Test");
	System.out.println("2) Display a new Test");
	System.out.println("3) Load a Test");
	System.out.println("4) Save a Test");
	System.out.println("5) Quit");
	
	option = keyboard.nextInt();	
	
	switch (option){
		case 1:
			Test test = new Test();
			test.setType("Test");
			test.create();
			test.display();
			break;

		case 2:
			System.out.println("Display Test");
			break;
		
		case 3:
			System.out.println("Load a Test");
			break;

		case 4:
			System.out.println("Save a Test");
			break;

		case 5:
			exit();

		default:
			System.out.println("Invalid Selection.");
			menu();
			break;
		}
		
	}
		

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
        System.out.println("Exiting....");
        System.exit(0);
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
