import java.util.*;
import java.io.*;
/**
 * 
 */
public class Start implements Serializable {

    /**
     * attributes used for start class
     * stores current surveys and tests that have been created
     */
    private static final double serialVersionUID = -1L;
    private Survey SOT;
    private String path = "./../ser/";
    ArrayList < Survey > createdSurvey = new ArrayList < Survey > ();
    ArrayList < Survey > createdTest = new ArrayList < Survey > ();
    Survey current;

    /**
     * Default constructor
     */
    public Start() {}


    /**
     * Display menu for creating new survey or test
     * creates option based on user input.
     */


    public int menu()  throws IOException, ClassNotFoundException{

        String choice;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\n1) Survey\n2) Test");
        
        //get input check values from available options
        choice = keyboard.nextLine();

        while(!choice.equals("1") && ! choice.equals("2")){
            System.out.println("Invalid Option.");
            System.out.println("\n1) Survey\n2) Test");
            choice = keyboard.nextLine();
            }

        if(choice.equals("1")){
            //surveyMenu();
            return 1;
        }
        else{
            //testMenu();
            return 2;
        }

    }


    /**
     * Function to create a new test.
     */


    public void surveyMenu()  throws IOException, ClassNotFoundException{

            String option;
            Scanner keyboard = new Scanner(System.in);

            //display second menu option
            System.out.println("\n1) Create a new survey");
            System.out.println("2) Display a Survey");
            System.out.println("3) Load a Survey");
            System.out.println("4) Save a Survey");
            System.out.println("5) Modify an Existing Survey");
            System.out.println("6) Take a Survey");
            System.out.println("7) Tabulate a Survey");
            System.out.println("8) Quit");

            option = keyboard.nextLine();

            //based on input run task wanted.
            switch (option) {
                case "1":
                    createSurvey(); //create a new survey
                    break;

                case "2":
                    display("Survey"); //display a created survey
                    break;

                case "3":
                    load("Survey"); //load a saved survey
                    break;

                case "4":
                    save(createdSurvey); //save all created surveys
                    break;

                case "5":
                    editSurvey(); //edit a survey
                    break;

                case "6":
                    takeSurvey(); //take a survey
                    break;

                case "7":
                    tabulate(); //tabulate all surveys
                    break;

                case "8":
                    exit(); 

                default:
                    System.out.println("Invalid Selection. Please select a valid option.");
                    surveyMenu(); //handle wrong input recall menu
                    break;
            }


    }

    public void testMenu() throws IOException, ClassNotFoundException{

            String option;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("\n1) Create a new Test");
            System.out.println("2) Display a new Test");
            System.out.println("3) Load a Test");
            System.out.println("4) Save a Test");
            System.out.println("5) Modify an Existing Test");
            System.out.println("6) Take a Test");
            System.out.println("7) Tabulate a Test");
            System.out.println("8) Quit");

            option = keyboard.nextLine(); 

            switch (option) {
                case "1":
                    createTest(); //create new test
                    break;

                case "2":
                    display("Test"); //display a created test
                    break;

                case "3":
                    load("Test"); //load a saved test into created.
                    break;

                case "4":
                    save(createdTest); //save all created tests
                    break;

                case "5":
                    editTest(); //edit a test
                    break;

                case "6":
                    takeTest(); //take a test
                    break;

                case "7":
                    tabulate(); //tabulate all tests
                    break;

                case "8":
                    exit(); 

                default:
                    System.out.println("Invalid Selection. Please select a valid option.");
                    testMenu(); //handle error recall menu again
                    break;
            }
    }

    public void createTest() {

        //sets the type and adds to created tests
        Test test = new Test();
        test.setType("Test");
        test.create();
        createdTest.add(test);
        this.current = test;
    }


    /**
     * Function to create a new survey.
     */
    public void createSurvey() {

        //creates new survey and adds to created list
        Survey survey = new Survey();
        survey.setType("Survey");
        survey.create();
        //createdSurvey.add(survey);
        this.current = survey;
    }


    /**
     * @param createdSOT paramter inptus a created survey or test (SOT)
     *  serializes the object and stores in ./../ser/{Survey/Test} pathway
     */
    private void save() {

        //if no tests are created return, cant save
        if (this.current == null) {
            System.out.println("\nPlease create a survey or test before saving.");
            return;
        }


        //for each SOT in created, get name,type and pathway

            System.out.println("Saving " + this.current.getName() + " .....");

            try {
                //create output stream for serialization
                FileOutputStream fileOut = new FileOutputStream(this.path + this.current.getType() + "/" + this.current.getName() + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(this.current);
                out.close();
                fileOut.close();

                //write the objects notify user.
                System.out.println("\n" + this.current.getName() + " was saved successfully.");
            } catch (IOException i) {
                i.printStackTrace();
            }
    }

     /**
     * @param type loads a type of file{Survey or Test}
     *  takes the seriliazed file and creates object adds it to created.
     */
    private void load(String type) throws IOException, ClassNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        String name = getFiles(type); //calls helper function

        
        if (name == null) {
            System.out.println("Could not load " + type + ".");
            return;
        }

        System.out.println("Loading: " + name);

        //reads inputstream and creates a survey object from .ser file
        try {
            InputStream file = new FileInputStream(this.path + "/" + type + "/" + name);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            Survey loadSurvey = (Survey) input.readObject();

            //add to correct created type
            if (type.equals("Survey")) {
                createdSurvey.add(loadSurvey);
            } else {
                createdTest.add(loadSurvey);
            }

            System.out.println(name + " loaded successfully");
            //notify user, otherwise cach error

        } catch (Exception e) {
            System.out.println("Error. Could not load " + type + ". ");
        }

    }

    /**
     * @param type loads a type of file{Survey or Test}
     *  helper function for loading, gets all files in directory
     * and gets uer input
     */
    public String getFiles(String type) {

        int count = 1;
        Scanner keyboard = new Scanner(System.in);

        //for each file in folder
        File folder = new File(this.path + type + "/");
        File[] listOfFiles = folder.listFiles();

        //if no files are in folder 
        if (listOfFiles.length == 0) {
            System.out.print("No input files found. ");
            return null;
        }

        try {
            //cycle through files make user select which file he wants loaded.
            for (File file: listOfFiles) {
                if (file.isFile()) {
                    System.out.println(" " + count + "). " + file.getName());
                    count++;
                }
            }
            System.out.println("");

        //catch error if happens
        } catch (Exception e) {
            System.out.println("Could not read from directory");
            return null;
        }

        //returns the name of file selected by user,
        System.out.println("");
        try{
        int choice = keyboard.nextInt();
        String name = listOfFiles[choice - 1].getName();
        return name;
        }
        catch(Exception e){
            System.out.println("Please enter a valid choice.");
            getFiles(type);
        }

        //should never get to this.
        return "";
    }

    
    /**
     * @param created Takes a created SOT 
     *  helper function for display to select which files to display
     */
    public int getOptions(ArrayList<Survey> created){

        int count = 1;
        int choice;
        Scanner keyboard = new Scanner(System.in);

        //if no files are created return -1
        if(created.size() == 0){
            return -1;
        }

        //make user select SOT from ones created
        for(Survey survey : created){
            System.out.println("\n" + count + ") " + survey.getName());
            count ++;
        }

        try{
        choice = keyboard.nextInt();

        //test input make sure it is correct. otherwise recall getOptions
        if( (choice>created.size()) || (choice < 0)){
            System.out.println("Please enter a valid choice");
            getOptions(created);
        }

        return (choice -1);
        }
        catch(Exception e){
            System.out.println("Please enter a valid choice");
            getOptions(created);
        }
        return -1;
    }


    /**
     * @param type loads a type of file{Survey or Test}
     *  displays SOT after calling getOptions
     */
    public void display(String type) {

        Survey SOT;
        int number;
        
        //get options for survey if thats the type
        if(type.equals("Survey")){
            number = getOptions(createdSurvey);
            if(number == -1){
                System.out.println("No " + type + " created yet.");
                return;
            }
            SOT = createdSurvey.get(number); //get selected survey and display it
        }
        //otherwise get options for test
        else{

           number = getOptions(createdTest);
            if(number < 0){
                System.out.println("No " + type + " created yet.");
                return;
            }

            SOT = createdTest.get(number); //get selected test and display it
        }


        //store questions from SOT
        ArrayList < Question > Questions = SOT.getQuestions();

        int count = 1;
        int index;

        //display name
        System.out.println("\n********************************");
        System.out.println("*" + SOT.getType() + " : " + SOT.getName() + "*");
        System.out.println("********************************\n");

        //display the loaded file
        SOT.display();

    }


    /**
     * Exit function
     */
    public void exit() {
        // TODO implement here
        System.out.println("\nExiting....");
        System.exit(0);
    }



    /*FUNCTIONS BELOW FOR LATER IMPLIMENTATION*/

    /**
     *
     * @param String Survey 
     * @return null
     */
    public void takeSurvey() {
        // TODO implement here
    }

    /**
     * @return null
     */
    public void editTest() {
        
        System.out.println("What question do you wish to modify?");
        System.out.println("Enter existing question.");
    }

    /**
     * @return null
     */
    public void editSurvey() {

        System.out.println("What question do you wish to modify?");
        System.out.println("Enter existing question.");
    }

    /**
     * @param String Test 
     * @return null
     */
    public void takeTest() {
        // TODO implement here
    }

    public void tabulate(){

    }

}