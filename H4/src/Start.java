import java.util.*;
import java.io.*;
/**
 * 
 */
public class Start extends Main implements Serializable{

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

        out.print("\n1) Survey\n2) Test\n3) Quit");
        
        //get input check values from available options
        choice = keyboard.nextLine();

        while( (!choice.equals("1") && !choice.equals("2")) && (!choice.equals("3") )){

            out.print("\n1) Survey\n2) Test\n3) Quit");
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
            out.print("\n1) Create a new survey" +
            "\n2) Display a Survey" + 
            "\n3) Load a Survey" +
            "\n4) Save a Survey" + 
            "\n5) Modify an Existing Survey" + 
            "\n6) Take a Survey" +
            "\n7) Tabulate a Survey" +
            "\n8) Quit");

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
                    //out.print("Invalid Selection. Please select a valid option.");
                    surveyMenu(); //handle wrong input recall menu
                    break;
            }


    }

    public void testMenu() throws IOException, ClassNotFoundException{

            String option;
            Scanner keyboard = new Scanner(System.in);

            out.print("\n1) Create a new Test" +
            "\n2) Display a Test" +
            "\n3) Load a Test" + 
            "\n4) Save a Test" + 
            "\n5) Modify an Existing Test" +
            "\n6) Take a Test" +
            "\n7) Tabulate a Test" +
            "\n8) Grade a Test" +
            "\n9) Quit");

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
                    //out.print("Invalid Selection. Please select a valid option.");
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
            out.print("\nPlease create survey or test before saving.");
            return;
        }


        //for each SOT in created, get name,type and pathway

            out.print("\nSaving " + this.current.getName() + " .....");

            try {
                //create output stream for serialization
                FileOutputStream fileOut = new FileOutputStream(this.path + this.current.getType() + "/" + this.current.getName() + ".ser");
                ObjectOutputStream objOutStream = new ObjectOutputStream(fileOut);
                objOutStream.writeObject(this.current);
                objOutStream.close();
                fileOut.close();

                //write the objects notify user.
                out.print(this.current.getName() + " was saved successfully.\n");
            } catch (IOException e) {
                System.out.println(e);
               out.print("Could not save " + this.current.getName());
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
            out.print("Could not load " + type + ".");
            return;
        }

        out.print("\nLoading: " + name + "...");

        //reads inputstream and creates a survey object from .ser file
        try {
            InputStream file = new FileInputStream(this.path + "/" + type + "/" + name);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            Survey loadSurvey = (Survey) input.readObject();

            //add to correct created type
            this.current = loadSurvey;

            out.print(name + " loaded successfully");
            //notify user, otherwise cach error

        } catch (Exception e) {
            out.print("Error. Could not load " + type + ". ");
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
            out.print("\nNo input files found. ");
            return null;
        }

        try {


            //cycle through files make user select which file he wants loaded.
            out.print("");
            for (File file: listOfFiles) {
                if (file.isFile()) {
                    out.print(" " + count + "). " + file.getName());
                    count++;
                }
            }

        //catch error if happens
        } catch (Exception e) {
            out.print("Could not read from directory");
            return null;
        }

        //returns the name of file selected by user,

        try{
        int choice = keyboard.nextInt();
        String name = listOfFiles[choice - 1].getName();
        return name;
        }
        catch(Exception e){
            out.print("Please enter a valid choice.");
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
            out.print("\n" + count + ") " + survey.getName());
            count ++;
        }

        try{
        choice = keyboard.nextInt();

        //test input make sure it is correct. otherwise recall getOptions
        if( (choice>created.size()) || (choice < 0)){
            out.print("Please enter a valid choice");
            getOptions(created);
        }

        return (choice -1);
        }
        catch(Exception e){
            out.print("Please enter a valid choice");
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
             out.print("\nPlease create/load a survey or test before displaying.");
             return;
        }


        //display name
        this.current.displayName();

        //display the loaded file
        this.current.display();

    }


    /**
     * Exit function
     */
    public void exit() {
        // TODO implement here
        out.print("\nExiting....");
        System.exit(0);
    }



    /**
     * @throws IOException
     * @throws ClassNotFoundException
     * @param String Survey 
     * @return null
     */
    public void take(String type) throws IOException, ClassNotFoundException{
        Scanner keyboard = new Scanner(System.in);

        out.print("\nWhat " + type + " do you wish to take?");
        load(type);

        //error handle just in case could not load serialization file.
        if(this.current == null)
            return ;

        //take the current survey or test loaded.

        this.current.displayName();

        this.current.take();
        
        //save survey or test after take
        out.print("Saving your " + type + " results.");
        save();


    }

    /**
    * Function to tabulate a Survey or Test
    * uses current test or survey, not loaded.
    */
    public void tabulate(){
        
        //check there is a current SOT available
        if(this.current == null){
             out.print("\nPlease create/load a survey or test before tabulating.");
             return;
        }

        //call tabulate
        this.current.tabulate();
    }


    /**
    * Function to grade a test 
    * uses current test not loaded.
    */
    public void gradeTest(){

        //Grade current test loaded. if none return
         if(this.current == null)
            return ;

        //call grade for test.
        this.current.grade();

    }

    /**
     * Function to edit a Test or Survey
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void edit(String type)throws IOException, ClassNotFoundException {
    
    int number;
    Scanner keyboard = new Scanner(System.in);
    
    //load the files from user for editing
    out.print("\nWhat " + type + " do you wish to modify");
    load(type);

    //if fails on loading return
    if(this.current == null){
        return ;
    }

    display();

    out.print("\nWhat question do you wish to modify?");
    out.print("Enter existing question: ");

        //handling invalid input
        try{
            number = keyboard.nextInt();
            this.current.editQuestion(number);
        }
        catch(Exception e){
            out.print("Enter existing question: ");
            number = keyboard.nextInt();
            this.current.editQuestion(number);
        }
}

}
