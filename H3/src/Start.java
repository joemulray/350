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

        System.out.println("\n1) Survey\n2) Test\n3) Quit");
        
        //get input check values from available options
        choice = keyboard.nextLine();

        while( (!choice.equals("1") && !choice.equals("2")) && (!choice.equals("3") )){

            System.out.println("\n1) Survey\n2) Test\n3) Quit");
            choice = keyboard.nextLine();
            }

        if(choice.equals("1")){
            //surveyMenu();
            return 1;
        }
        else if(choice.equals("2")){
            //testMenu();
            return 2;
        }
        else{
            exit();
        }
            //Should never get here
            return -1;

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
                    display(); //display a created survey
                    break;

                case "3":
                    load("Survey"); //load a saved survey
                    break;

                case "4":
                    save(); //save all created surveys
                    break;

                case "5":
                    edit("Survey"); //edit a survey
                    break;

                case "6":
                    take("Survey"); //take a survey
                    break;

                case "7":
                    tabulate(); //tabulate all surveys
                    break;

                case "8":
                    exit(); 

                default:
                    //System.out.println("Invalid Selection. Please select a valid option.");
                    surveyMenu(); //handle wrong input recall menu
                    break;
            }


    }

    public void testMenu() throws IOException, ClassNotFoundException{

            String option;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("\n1) Create a new Test");
            System.out.println("2) Display a Test");
            System.out.println("3) Load a Test");
            System.out.println("4) Save a Test");
            System.out.println("5) Modify an Existing Test");
            System.out.println("6) Take a Test");
            System.out.println("7) Tabulate a Test");
            System.out.println("8) Grade a Test");
            System.out.println("9) Quit");

            option = keyboard.nextLine(); 

            switch (option) {
                case "1":
                    createTest(); //create new test
                    break;

                case "2":
                    display(); //display a created test
                    break;

                case "3":
                    load("Test"); //load a saved test into created.
                    break;

                case "4":
                    save(); //save all created tests
                    break;

                case "5":
                    edit("Test"); //edit a test
                    break;

                case "6":
                    take("Test"); //take a test
                    break;

                case "7":
                    tabulate(); //tabulate all tests
                    break;

                case "8":
                    gradeTest();
                    break;


                case "9":
                    exit();

                default:
                    //System.out.println("Invalid Selection. Please select a valid option.");
                    testMenu(); //handle error recall menu again
                    break;
            }
    }

    public void createTest() {

        //sets the type and adds to created tests
        Test test = new Test();
        test.setType("Test");
        test.create();
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
        this.current = survey;
    }


    /**
     * @param createdSOT paramter inptus a created survey or test (SOT)
     *  serializes the object and stores in ./../ser/{Survey/Test} pathway
     */
    private void save() {

        //if no tests are created return, cant save
        if (this.current == null) {
            System.out.println("\nPlease create survey or test before saving.");
            return;
        }


        //for each SOT in created, get name,type and pathway

            System.out.println("\nSaving " + this.current.getName() + " .....");

            try {
                //create output stream for serialization
                FileOutputStream fileOut = new FileOutputStream(this.path + this.current.getType() + "/" + this.current.getName() + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(this.current);
                out.close();
                fileOut.close();

                //write the objects notify user.
                System.out.println(this.current.getName() + " was saved successfully.\n");
            } catch (IOException e) {
               System.out.println("Could not save " + this.current.getName());
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

        System.out.println("\nLoading: " + name + "...");

        //reads inputstream and creates a survey object from .ser file
        try {
            InputStream file = new FileInputStream(this.path + "/" + type + "/" + name);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            Survey loadSurvey = (Survey) input.readObject();

            //add to correct created type
            this.current = loadSurvey;

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
            System.out.println("");
            for (File file: listOfFiles) {
                if (file.isFile()) {
                    System.out.println(" " + count + "). " + file.getName());
                    count++;
                }
            }

        //catch error if happens
        } catch (Exception e) {
            System.out.println("Could not read from directory");
            return null;
        }

        //returns the name of file selected by user,

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
    public void display() {

        if(this.current == null){
             System.out.println("\nPlease create/load a survey or test before displaying.");
             return;
        }


        //display name
        System.out.println("\n=========================================");
        System.out.println("           " + this.current.getType() + " : " + this.current.getName());
       System.out.println("=========================================\n");

        //display the loaded file
        this.current.display();

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
    public void take(String type) throws IOException, ClassNotFoundException{
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nWhat " + type + " do you wish to take?");
        load(type);

        //error handle just in case could not load serialization file.
        if(this.current == null)
            return ;

        //take the current survey or test loaded.

        this.current.take();

    }

    public void tabulate(){

    }


    public void gradeTest(){

    }


    public void edit(String type)throws IOException, ClassNotFoundException {
    
    int number;
    Scanner keyboard = new Scanner(System.in);
    boolean isTrue = true;
    
    System.out.println("\nWhat " + type + " do you wish to modify");
    load(type);


    System.out.println("\nWhat question do you wish to modify?");
    System.out.print("Enter existing question: ");

    while(isTrue){

        try{
            number = keyboard.nextInt();
            this.current.editQuestion(number);
            isTrue = false;

        }
        catch(Exception e){
             System.out.print("Enter existing question: ");
        }
    }
}

}