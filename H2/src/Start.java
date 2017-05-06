
import java.util.*;
import java.io.*;
/**
 * 
 */
public class Start implements Serializable {

    private Survey SOT;
    private String path = "./../ser/";

    /**
     * Default constructor
     */
    public Start() {}


    /**
     * @return
     */
    public void menu() {
        // TODO implement here

	String choice, option;
	Scanner keyboard = new Scanner(System.in);


	System.out.println("1) Survey\n2) Test");
			
	choice = keyboard.nextLine();
		
	if(choice == "1"){
	
	System.out.println("1) Create a new survey");
	System.out.println("2) Display a Survey");
	System.out.println("3) Load a Survey");
	System.out.println("4) Save a Survey");
	System.out.println("5) Quit");

	option = keyboard.nextLine();
	
	switch (option){
		case "1":
			Survey survey = new Survey();
			survey.setType("Survey");
			survey.create();
			this.SOT = survey;
			break;

		case "2":
			System.out.println("Display a Survey");
			break;
		
		case "3":
			System.out.println("Load a Survey");
			load("Survey");
			break;

		case "4":
			System.out.println("Save a Survey");
			save(this.SOT);
			break;

		case "5":
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
	
	option = keyboard.nextLine();	
	
	switch (option){
		case "1":
			Test test = new Test();
			test.setType("Test");
			test.create();
			this.SOT = test;
			save(this.SOT);
			break;
		case "2":
			System.out.println("Display Test");
			break;
		case "3":
			System.out.println("Load a Test");
			load("");
			break;
		case "4":
			System.out.println("Save a Test");
			save(this.SOT);
			break;
		case "5":
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
    public void save(Survey SOT) {
	
	System.out.println("Saving " + SOT.getName()  + " .....");

       try {
         FileOutputStream fileOut =
         new FileOutputStream(this.path + SOT.getType() + "/" + SOT.getName() + ".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(SOT);
         out.close();
         fileOut.close();
         System.out.println(SOT.getName() + " was saved successfully.");
      }catch(IOException i) {
         i.printStackTrace();
      }

    }

    public void load(String type){


    int count=1;
    Scanner keyboard = new Scanner(System.in);

	File folder = new File(this.path + type + "");
	File[] listOfFiles = folder.listFiles();

	for (File file : listOfFiles) {
	    if (file.isFile()) {
	        System.out.println(count +"). "+ file.getName());
	        count++;
	    }


	}


	}


}
